package com.encurtador.msencurtadorurl.service;

import com.encurtador.msencurtadorurl.domain.Command;
import com.encurtador.msencurtadorurl.domain.CommandEvent;
import com.encurtador.msencurtadorurl.domain.CommandKey;
import com.encurtador.msencurtadorurl.domain.ShortURLDTO;
import com.encurtador.msencurtadorurl.exception.ErrorToSendCommandException;
import com.encurtador.msencurtadorurl.repository.EventRepository;
import com.encurtador.msencurtadorurl.utils.EncurtadorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpConnectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.CassandraConnectionFailureException;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EventSenderImpl.class);

    private static final String PROCESSANDO = "PROCESSANDO";
    private static final String PROCESSADO = "PROCESSADO";
    private static final String ACAO_CRIAR = "CRIAR";
    private static final String ACAO_DELETAR = "DELETAR";

    @Value("${encurtador.host}")
    private String msHost;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventSender eventSender;

    @Override
    public ShortURLDTO commandCreate(String originalURL) throws ErrorToSendCommandException {

        final var shortUrlPath = EncurtadorUtils.generateString(7);
        final var finalShortURL = this.msHost.concat(shortUrlPath);

        final Command shortURL = new Command(
                new CommandKey(shortUrlPath, new Date()),
                originalURL,
                ACAO_CRIAR,
                PROCESSANDO);

        boolean isSavedOnDB = this.saveEventSync(shortURL);

        if (isSavedOnDB) {
            this.sendEventToQueueAsync(new CommandEvent(shortURL.getShortURLKey().getShortUrl(),
                    shortURL.getShortURLKey().getEventDate(),
                    shortURL.getOriginalUrl(),
                    shortURL.getEventAction()));
        }

        return new ShortURLDTO(finalShortURL);
    }


    @Override
    public void commandDelete(String shortURL) throws ErrorToSendCommandException, URISyntaxException {

        final URI uri = new URI(shortURL);
        final String pathUrl = uri.getPath().replace("/", "");

        final Command command = new Command(
                new CommandKey(pathUrl, new Date()),
                null,
                ACAO_DELETAR,
                PROCESSANDO);

        final boolean isSavedOnDB = this.saveEventSync(command);

        if (isSavedOnDB) {
            this.sendEventToQueueAsync(new CommandEvent(command.getShortURLKey().getShortUrl(),
                    command.getShortURLKey().getEventDate(),
                    command.getOriginalUrl(),
                    command.getEventAction()));
        }
    }

    @Override
    public boolean saveEventSync(Command shortURL) throws ErrorToSendCommandException {

        try {
            this.eventRepository.save(shortURL);
            LOGGER.info("Evento salvo no BD.");
            return true;
        } catch (CassandraConnectionFailureException ex) {
            LOGGER.error("Erro ao salvar evento na base, vamos envia-lo ao broker.", ex);
        }

        return sendEventToQueueSync(shortURL);
    }


    public boolean sendEventToQueueSync(Command command) throws ErrorToSendCommandException {
        try {
            this.eventSender.sendCommand(new CommandEvent(command.getShortURLKey().getShortUrl(),
                    command.getShortURLKey().getEventDate(),
                    command.getOriginalUrl(),
                    command.getEventAction()));

            LOGGER.info("Evento enviado ao Broker");

            return false;
        } catch (AmqpConnectException ex) {
            LOGGER.error("Erro ao enviar envento ao broker", ex);
            throw new ErrorToSendCommandException("Ooooops, estamos com alguns problemas..");
        }
    }

    @Override
    public void sendEventToQueueAsync(CommandEvent shortURLEvent) {

        try {
            this.eventSender.sendCommand(shortURLEvent);
            Optional<Command> foundedShortURL = this.eventRepository.findById(new CommandKey(
                    shortURLEvent.getShortUrl(),
                    shortURLEvent.getEventDate()));
            if (foundedShortURL.isPresent()) {
                Command shortURL = foundedShortURL.get();
                shortURL.setEventStatus(PROCESSADO);
                this.eventRepository.save(shortURL);
            }

        } catch (AmqpConnectException ex) {
            LOGGER.error("Erro ao enviar envento ao broker", ex);
        }

    }
}
