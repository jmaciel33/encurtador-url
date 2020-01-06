package com.encurtador.msencurtadorurl.controller;

import com.encurtador.msencurtadorurl.domain.OriginalURLDTO;
import com.encurtador.msencurtadorurl.domain.ShortURLDTO;
import com.encurtador.msencurtadorurl.exception.ErrorToSendCommandException;
import com.encurtador.msencurtadorurl.service.EventService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.net.URISyntaxException;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EncurtadorControllerTest {

    @Mock
    private EventService eventService;

    @InjectMocks
    private EncurtadorController encurtadorController;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createShortURL() throws ErrorToSendCommandException {
        this.encurtadorController.createShortURL(new OriginalURLDTO(Mockito.anyString()));
        Mockito.verify(this.eventService, Mockito.atLeast(1))
                .commandCreate(Mockito.anyString());
    }

    @Test
    public void deleteShortURL() throws ErrorToSendCommandException, URISyntaxException {
        this.encurtadorController.deleteShortURL(new ShortURLDTO(Mockito.anyString()));

        Mockito.verify(this.eventService, Mockito.atLeast(1))
                .commandDelete(Mockito.anyString());
    }
}