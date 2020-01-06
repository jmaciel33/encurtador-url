package com.encurtador.mseventstore.service;

import com.encurtador.mseventstore.domain.CommandEvent;

public interface EventProcessorService {

    void processEvent(CommandEvent commandEvent);
}
