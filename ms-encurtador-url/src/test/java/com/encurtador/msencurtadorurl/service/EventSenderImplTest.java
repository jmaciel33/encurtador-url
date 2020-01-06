package com.encurtador.msencurtadorurl.service;

import com.encurtador.msencurtadorurl.config.BrokerConfig;
import com.encurtador.msencurtadorurl.domain.CommandEvent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EventSenderImplTest {

    @InjectMocks
    private EventSenderImpl eventSender;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @Mock
    private BrokerConfig brokerConfig;

    @Test
    public void sendCommand() {
        Mockito.when(brokerConfig.getExchange()).thenReturn("exchange");
        Mockito.when(brokerConfig.getRoutingKey()).thenReturn("routingKey");
        this.eventSender.sendCommand(new CommandEvent());
        Mockito.verify(rabbitTemplate, Mockito.atLeastOnce())
                .send(Mockito.eq("exchange"), Mockito.eq("routingKey"), Mockito.any(Message.class));
    }


}