package com.encurtador.msanalytics.domain;

import java.util.Date;

/**
 * The type Read event.
 */
public class ReadEvent {

    /**
     * Short URL.
     */
    private String shortUrl;

    /**
     * Event date.
     */
    private Date eventDate;

    /**
     * Original URL.
     */
    private String originalUrl;

    /**
     * Instantiates a new Read event.
     */
    public ReadEvent() {
        //Empty constructor.
    }

    /**
     * Instantiates a new Read event.
     *
     * @param shortUrl    the short url
     * @param eventDate   the event date
     * @param originalUrl the original url
     */
    public ReadEvent(String shortUrl, Date eventDate, String originalUrl) {
        this.shortUrl = shortUrl;
        this.eventDate = eventDate;
        this.originalUrl = originalUrl;
    }

    /**
     * Gets short url.
     *
     * @return the short url
     */
    public String getShortUrl() {
        return shortUrl;
    }

    /**
     * Sets short url.
     *
     * @param shortUrl the short url
     */
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    /**
     * Gets event date.
     *
     * @return the event date
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * Sets event date.
     *
     * @param eventDate the event date
     */
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * Gets original url.
     *
     * @return the original url
     */
    public String getOriginalUrl() {
        return originalUrl;
    }

    /**
     * Sets original url.
     *
     * @param originalUrl the original url
     */
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

}
