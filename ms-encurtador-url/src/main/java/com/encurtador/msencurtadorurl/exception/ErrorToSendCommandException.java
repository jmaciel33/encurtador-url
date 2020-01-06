package com.encurtador.msencurtadorurl.exception;

public class ErrorToSendCommandException extends Exception {
    private static final long serialVersionUID = -759545063699892255L;

    public ErrorToSendCommandException() {
    }

    public ErrorToSendCommandException(String message) {
        super(message);
    }

    public ErrorToSendCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorToSendCommandException(Throwable cause) {
        super(cause);
    }

    public ErrorToSendCommandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
