package com.encurtador.msencurtadorurl.service;

import com.encurtador.msencurtadorurl.domain.Command;
import com.encurtador.msencurtadorurl.domain.CommandEvent;
import com.encurtador.msencurtadorurl.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledServiceImpl implements ScheduledService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledServiceImpl.class);

    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepository eventRepository;

    @Override
    @Scheduled(cron = "0 0/1 * 1/1 * ?")
    public void resendEventsToBroker() {

        final List<Command> commands = this.eventRepository.findAll();

        if (commands.size() > 0){
            commands.parallelStream()
                    .filter(command -> command.getEventStatus().equals("PROCESSANDO"))
                    .map(command -> new CommandEvent(
                            command.getShortURLKey().getShortUrl(),
                            command.getShortURLKey().getEventDate(),
                            command.getOriginalUrl(),
                            command.getEventAction()))
                    .forEach(commandEvent -> this.eventService.sendEventToQueueAsync(commandEvent));
        }
    }
}
