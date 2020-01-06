package com.encurtador.msurlread.service;

import com.encurtador.msurlread.domain.OriginalURLDTO;
import com.encurtador.msurlread.domain.ReadEvent;
import com.encurtador.msurlread.domain.ShortURL;
import com.encurtador.msurlread.exception.URLNotFoundException;
import com.encurtador.msurlread.repository.ShortURLRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpConnectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ShortURLServiceImpl implements ShortURLService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ShortURLServiceImpl.class);

    @Autowired
    private ShortURLRepository shortURLRepository;

    @Autowired
    private EventSender eventSender;

    @Override
    public ShortURL getshortURL(String shortURLKey) throws URLNotFoundException {

        final Optional<ShortURL> optionalShortURL = this.shortURLRepository.findById(shortURLKey);
        if (optionalShortURL.isPresent()) {
            return new ShortURL(optionalShortURL.get().getShortUrl(), optionalShortURL.get().getOriginalUrl());
        } else {
            throw new URLNotFoundException("Essa URL não existe.");
        }

    }

    @Override
    public void sendEventToBroker(ReadEvent readEvent) {

        try {
            this.eventSender.sendCommand(readEvent);

        } catch (
                AmqpConnectException ex) {
            LOGGER.error("Erro ao enviar envento ao broker", ex);
        }

    }

    @Override
    public OriginalURLDTO getOriginalURL(String shortURLKey) throws URLNotFoundException {
        final ShortURL shortURL = this.getshortURL(shortURLKey);
        return new OriginalURLDTO(shortURL.getOriginalUrl());
    }

    @Override
    public OriginalURLDTO getOriginalURLForRedirect(String shortURLKey) throws URLNotFoundException {
        final ShortURL shortURL = this.getshortURL(shortURLKey);
        this.sendEventToBroker(new ReadEvent(shortURL.getShortUrl(), new Date(), shortURL.getOriginalUrl()));
        return new OriginalURLDTO(shortURL.getOriginalUrl());    }
}
