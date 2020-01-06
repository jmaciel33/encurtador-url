package com.encurtador.msanalytics.service;

import com.encurtador.msanalytics.domain.Read;
import com.encurtador.msanalytics.domain.ReadEvent;
import com.encurtador.msanalytics.repository.EventRepository;
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

    @Autowired
    private EventRepository eventRepository;


    @Override
    public void saveEvent(ReadEvent readEvent) {
        final Read read = new Read(readEvent.getShortUrl(), readEvent.getEventDate(), readEvent.getOriginalUrl());
        this.eventRepository.save(read);
    }
}
