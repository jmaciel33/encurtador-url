package com.encurtador.mseventrefresher.service;

import com.encurtador.mseventrefresher.domain.Command;
import com.encurtador.mseventrefresher.domain.CommandEvent;
import com.encurtador.mseventrefresher.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Event processor service.
 */
@Service
public class EventProcessorServiceImpl implements EventProcessorService{

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EventProcessorServiceImpl.class);

    private static final String ACAO_CRIAR = "CRIAR";
    private static final String ACAO_DELETAR = "DELETAR";

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void eventRouter(CommandEvent commandEvent) {
        final Command command = new Command(commandEvent.getShortUrl(), commandEvent.getOriginalUrl());

        final String action=commandEvent.getEventAction();

        switch (action){
            case ACAO_CRIAR :
                this.createEvent(command);
                break;
            case ACAO_DELETAR :
                this.deleteEvent(command);
                break;
            default:
                LOGGER.info("Este ação não existe.");
        }
    }

    @Override
    public void createEvent(Command command) {
        this.eventRepository.save(command);
    }

    @Override
    public void deleteEvent(Command command) {
        this.eventRepository.delete(command);
    }
}
