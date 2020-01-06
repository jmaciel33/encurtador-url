package com.encurtador.msanalytics.domain;

public class StatisticsDTO {

    private String shortURL;
    private int redirects;

    public StatisticsDTO() {
    }

    public StatisticsDTO(String shortURL, int redirects) {
        this.shortURL = shortURL;
        this.redirects = redirects;
    }

    public int getRedirects() {
        return redirects;
    }

    public void setRedirects(int redirects) {
        this.redirects = redirects;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }
}
