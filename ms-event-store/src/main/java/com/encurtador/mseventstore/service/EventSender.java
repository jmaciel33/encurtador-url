package com.encurtador.mseventstore.service;

import com.encurtador.mseventstore.domain.CommandEvent;
import org.springframework.amqp.core.Message;

public interface EventSender {

    /**
     * Method responsible for build message.
     * @param event Event.
     * @return Message.
     */
    Message buidMessage(CommandEvent event);

    /**
     * Method responsible for sending the mounted message to the exchange.
     * @param event Event.
     */
    void sendCommand(CommandEvent event);
}
