package com.encurtador.msurlread.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

/**
 * The type Short url.
 */
@Table("short_url")
public class ShortURL implements Serializable {

    /**
     * Short url.
     */
    @PrimaryKey("short_url")
    private String shortUrl;

    /**
     * Original URL.
     */
    @Column("original_url")
    private String originalUrl;


    /**
     * Instantiates a new Short url.
     */
    public ShortURL() {
        //empty constructor.
    }

    public ShortURL(String shortUrl, String originalUrl) {
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}

