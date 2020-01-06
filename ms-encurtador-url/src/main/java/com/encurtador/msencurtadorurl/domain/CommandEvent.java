package com.encurtador.msencurtadorurl.domain;

import java.util.Date;

public class CommandEvent {

    private String shortUrl;

    private Date eventDate;

    private String originalUrl;

    private String eventAction;

    public CommandEvent() {
    }

    public CommandEvent(String shortUrl, Date eventDate, String originalUrl, String eventAction) {
        this.shortUrl = shortUrl;
        this.eventDate = eventDate;
        this.originalUrl = originalUrl;
        this.eventAction = eventAction;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getEventAction() {
        return eventAction;
    }

    public void setEventAction(String eventAction) {
        this.eventAction = eventAction;
    }
}
