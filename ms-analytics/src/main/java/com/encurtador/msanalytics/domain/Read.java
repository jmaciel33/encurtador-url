package com.encurtador.msanalytics.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * The type Short url.
 */
@Table("encurtador")
public class Read {

    /**
     * primary key.
     */
    @PrimaryKey
    private ReadKey readKey;

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
     * @param readKey     the read key
     * @param originalUrl the original url
     */
    public Read(ReadKey readKey, String originalUrl) {
        this.readKey = readKey;
        this.originalUrl = originalUrl;
    }

    /**
     * Gets read key.
     *
     * @return the read key
     */
    public ReadKey getReadKey() {
        return readKey;
    }

    /**
     * Sets read key.
     *
     * @param readKey the read key
     */
    public void setReadKey(ReadKey readKey) {
        this.readKey = readKey;
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

