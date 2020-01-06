package com.encurtador.msurlread.exception;

public class URLNotFoundException extends Exception {
    private static final long serialVersionUID = -759545063699892255L;

    public URLNotFoundException() {
    }

    public URLNotFoundException(String message) {
        super(message);
    }

    public URLNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public URLNotFoundException(Throwable cause) {
        super(cause);
    }

    public URLNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
