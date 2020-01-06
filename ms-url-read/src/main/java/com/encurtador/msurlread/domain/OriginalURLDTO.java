package com.encurtador.msurlread.domain;

public class OriginalURLDTO {

    private String originalURL;

    public OriginalURLDTO() {
    }

    public OriginalURLDTO(String originalURL) {
        this.originalURL = originalURL;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }
}
