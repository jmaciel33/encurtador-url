package com.encurtador.mseventrefresher.domain;

import java.util.Date;

/**
 * The type Command event.
 */
public class CommandEvent {

    private String shortUrl;

    private Date eventDate;

    private String originalUrl;

    private String eventAction;

    /**
     * Instantiates a new Command event.
     */
    public CommandEvent() {
    }

    /**
     * Instantiates a new Command event.
     *
     * @param shortUrl    the short url
     * @param eventDate   the event date
     * @param originalUrl the original url
     * @param eventAction the event action
     */
    public CommandEvent(String shortUrl, Date eventDate, String originalUrl, String eventAction) {
        this.shortUrl = shortUrl;
        this.eventDate = eventDate;
        this.originalUrl = originalUrl;
        this.eventAction = eventAction;
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

    /**
     * Gets event action.
     *
     * @return the event action
     */
    public String getEventAction() {
        return eventAction;
    }

    /**
     * Sets event action.
     *
     * @param eventAction the event action
     */
    public void setEventAction(String eventAction) {
        this.eventAction = eventAction;
    }
}
