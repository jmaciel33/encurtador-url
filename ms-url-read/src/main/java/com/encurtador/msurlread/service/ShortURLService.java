package com.encurtador.msurlread.service;

import com.encurtador.msurlread.domain.OriginalURLDTO;
import com.encurtador.msurlread.domain.ReadEvent;
import com.encurtador.msurlread.domain.ShortURL;
import com.encurtador.msurlread.exception.URLNotFoundException;

import java.util.List;

/**
 * The interface Short url service.
 */
public interface ShortURLService {


    /**
     * Gets url.
     *
     * @param shortURLKey the short url
     * @return the url
     * @throws URLNotFoundException the url not found exception
     */
    ShortURL getshortURL(String shortURLKey) throws URLNotFoundException;


    /**
     * Gets all urls.
     *
     * @return the all urls
     */
    List<ShortURL> getAllUrls();

    /**
     * Send event to broker.
     *
     * @param readEvent the read event
     */
    void sendEventToBroker(ReadEvent readEvent);


    /**
     * Gets original url.
     *
     * @param shortURLKey the short url
     * @return the original url
     */
    OriginalURLDTO getOriginalURL(String shortURLKey) throws URLNotFoundException;

    /**
     * Gets original url for redirect.
     *
     * @param shortURLKey the short url
     * @return the original url
     */
    OriginalURLDTO getOriginalURLForRedirect(String shortURLKey) throws URLNotFoundException;

}
