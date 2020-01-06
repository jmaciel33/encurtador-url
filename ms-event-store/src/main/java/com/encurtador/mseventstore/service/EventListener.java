package com.encurtador.mseventstore.service;

import com.encurtador.mseventstore.domain.CommandEvent;

public interface EventListener {

    /**
     * Method responsible for listening to the queue: obk-event-processor and calling the event handler.
     * @param commandEvent Event.
     */
    void onMessageReceived(CommandEvent commandEvent);
}
