package com.encurtador.msencurtadorurl.service;

import com.encurtador.msencurtadorurl.domain.Command;
import com.encurtador.msencurtadorurl.domain.CommandEvent;
import com.encurtador.msencurtadorurl.domain.ShortURLDTO;
import com.encurtador.msencurtadorurl.exception.ErrorToSendCommandException;

import java.net.URISyntaxException;

/**
 * The interface Event service.
 */
public interface EventService {

    /**
     * Create short url.
     *
     * @param originalURL the original url
     * @return the short urldto
     */
    ShortURLDTO commandCreate(String originalURL) throws ErrorToSendCommandException;

    /**
     * Delete short URL.
     *
     * @param shortURL
     * @throws ErrorToSendCommandException
     */
    void commandDelete(String shortURL) throws ErrorToSendCommandException, URISyntaxException;


    /**
     * Save event short url.
     *
     * @param shortURL the Short URL.
     * @return the short urldto
     */
    boolean saveEventSync(Command shortURL) throws ErrorToSendCommandException;


    /**
     * Send event to queue.
     *
     * @param shortURLEvent the short url event
     * @return the boolean
     */
    void sendEventToQueueAsync(CommandEvent shortURLEvent);
}
