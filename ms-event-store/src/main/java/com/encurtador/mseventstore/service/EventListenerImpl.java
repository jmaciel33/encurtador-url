package com.encurtador.mseventstore.service;


import com.encurtador.mseventstore.domain.CommandEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventListenerImpl implements EventListener {

    @Autowired
    private EventProcessorService eventProcessorService;

    @Transactional
    @RabbitListener(queues = "${broker.queue}")
    @Override
    public void onMessageReceived(CommandEvent commandEvent) {
        this.eventProcessorService.processEvent(commandEvent);
    }
}
