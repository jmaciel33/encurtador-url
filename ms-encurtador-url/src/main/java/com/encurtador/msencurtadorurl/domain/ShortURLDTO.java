package com.encurtador.msencurtadorurl.domain;

public class ShortURLDTO {

    /**
     * Complete Short URL.
     */
    private String shortURL;

    public ShortURLDTO() {
        //Empty constructor.
    }

    public ShortURLDTO(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getShortURL() {
        return shortURL;
    }
}
