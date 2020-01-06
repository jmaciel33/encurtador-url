package com.encurtador.msurlread.service;

import com.encurtador.msurlread.domain.ReadEvent;
import org.springframework.amqp.core.Message;

public interface EventSender {

    /**
     * Method responsible for build message.
     * @param event Event.
     * @return Message.
     */
    Message buidMessage(ReadEvent event);

    /**
     * Method responsible for sending the mounted message to the exchange.
     * @param event Event.
     */
    void sendCommand(ReadEvent event);
}
