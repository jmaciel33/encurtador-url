package com.encurtador.msanalytics.domain;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

/**
 * The type Short url.
 */
@Table("encurtador")
public class Read {

    /**
     * Short url.
     */
    @PrimaryKeyColumn(name = "short_url", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String shortUrl;

    @Column("event_date")
    private Date eventDate;

    /**
     * Original URL.
     */
    @Column("original_url")
    private String originalUrl;


    /**
     * Instantiates a new Short url.
     */
    public Read() {
        //empty constructor.
    }

    /**
     * Instantiates a new Read.
     *
     * @param shortUrl    the short url
     * @param eventDate   the event date
     * @param originalUrl the original url
     */
    public Read(String shortUrl, Date eventDate, String originalUrl) {
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
}

