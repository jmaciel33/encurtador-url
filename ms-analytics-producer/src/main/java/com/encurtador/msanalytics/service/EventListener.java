package com.encurtador.msanalytics.service;

import com.encurtador.msanalytics.domain.ReadEvent;

public interface EventListener {

    /**
     * Method responsible for listening to the queue: obk-event-processor and calling the event handler.
     * @param readEvent Event.
     */
    void onMessageReceived(ReadEvent readEvent);
}
