package com.encurtador.msurlread.domain;

import java.util.Date;

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

    public ReadEvent() {
        //Empty constructor.
    }

    public ReadEvent(String shortUrl, Date eventDate, String originalUrl) {
        this.shortUrl = shortUrl;
        this.eventDate = eventDate;
        this.originalUrl = originalUrl;
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

}
