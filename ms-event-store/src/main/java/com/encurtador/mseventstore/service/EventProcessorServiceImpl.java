package com.encurtador.mseventstore.service;

import com.encurtador.mseventstore.domain.Command;
import com.encurtador.mseventstore.domain.CommandEvent;
import com.encurtador.mseventstore.domain.CommandKey;
import com.encurtador.mseventstore.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventProcessorServiceImpl implements EventProcessorService {

    @Autowired
    private EventSender eventSender;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void processEvent(CommandEvent commandEvent) {

        final Command command = new Command(
                new CommandKey(commandEvent.getShortUrl(), commandEvent.getEventDate()),
                commandEvent.getOriginalUrl(),
                commandEvent.getEventAction());

        this.eventSender.sendCommand(commandEvent);
        this.eventRepository.save(command);
    }
}
