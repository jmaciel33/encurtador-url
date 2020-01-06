package com.encurtador.mseventrefresher.service;

import com.encurtador.mseventrefresher.domain.CommandEvent;

public interface EventListener {

    /**
     * Method responsible for listening to the queue: obk-event-processor and calling the event handler.
     * @param commandEvent Event.
     */
    void onMessageReceived(CommandEvent commandEvent);
}
