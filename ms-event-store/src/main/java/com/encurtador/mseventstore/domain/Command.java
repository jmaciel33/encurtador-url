package com.encurtador.mseventstore.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * The type Short url.
 */
@Table("event_store")
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
     */
    public Command(CommandKey shortURLKey, String originalUrl, String eventAction) {
        this.shortURLKey = shortURLKey;
        this.originalUrl = originalUrl;
        this.eventAction = eventAction;
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

