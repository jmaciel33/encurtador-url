package com.encurtador.mseventrefresher.service;

import com.encurtador.mseventrefresher.domain.Command;
import com.encurtador.mseventrefresher.domain.CommandEvent;

/**
 * The interface Event processor service.
 */
public interface EventProcessorService {

    /**
     * Event router.
     *
     * @param commandEvent the command event
     */
    void eventRouter(CommandEvent commandEvent);

    /**
     * Create event.
     *
     * @param command the command
     */
    void createEvent(Command command);

    /**
     * Delete event.
     *
     * @param command the command
     */
    void deleteEvent(Command command);

}
