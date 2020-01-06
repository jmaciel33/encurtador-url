package com.encurtador.msencurtadorurl.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * The type Short url.
 */
@Table("es_encurtador")
public class Command {

    /**
     * Short URL Constructor.
     */
    @PrimaryKey
    private CommandKey shortURLKey;

    /**
     * Original URL.
     */
    @Column("original_url")
    private String originalUrl;

    /**
     * Event status.
     */
    @Column("event_action")
    private String eventAction;

    /**
     * Event status.
     */
    @Column("event_status")
    private String eventStatus;

    /**
     * Instantiates a new Short url.
     */
    public Command() {
        //empty constructor.
    }

    /**
     * Instantiates a new Short url.
     *
     * @param shortURLKey the short url key
     * @param originalUrl the original url
     * @param eventAction the event action
     * @param eventStatus the event status
     */
    public Command(CommandKey shortURLKey, String originalUrl, String eventAction, String eventStatus) {
        this.shortURLKey = shortURLKey;
        this.originalUrl = originalUrl;
        this.eventAction = eventAction;
        this.eventStatus = eventStatus;
    }

    /**
     * Gets short url key.
     *
     * @return the short url key
     */
    public CommandKey getShortURLKey() {
        return shortURLKey;
    }

    /**
     * Sets short url key.
     *
     * @param shortURLKey the short url key
     */
    public void setShortURLKey(CommandKey shortURLKey) {
        this.shortURLKey = shortURLKey;
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
     * Gets event status.
     *
     * @return the event status
     */
    public String getEventStatus() {
        return eventStatus;
    }

    /**
     * Sets event status.
     *
     * @param eventStatus the event status
     */
    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
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

