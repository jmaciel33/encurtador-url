package com.encurtador.msencurtadorurl.domain;

import java.io.Serializable;

public class GenericError implements Serializable {
    private static final long serialVersionUID = -6284182285080337767L;

    private String code;
    private String message;

    public GenericError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
