package com.encurtador.msanalytics.domain;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.Date;

@PrimaryKeyClass
public class ReadKey {

    @PrimaryKeyColumn(name = "short_url", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String shortUrl;

    @PrimaryKeyColumn(name = "event_date", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    private Date eventDate;

    public ReadKey(String shortUrl, Date eventDate) {
        this.shortUrl = shortUrl;
        this.eventDate = eventDate;
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

}
