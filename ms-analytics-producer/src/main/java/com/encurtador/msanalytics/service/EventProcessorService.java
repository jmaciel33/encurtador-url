package com.encurtador.msanalytics.service;

import com.encurtador.msanalytics.domain.ReadEvent;

/**
 * The interface Event processor service.
 */
public interface EventProcessorService {

    /**
     * Event router.
     *
     * @param commandEvent the command event
     */
    void saveEvent(ReadEvent readEvent);


}
