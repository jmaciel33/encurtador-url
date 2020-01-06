package com.encurtador.msencurtadorurl.controller;

import com.encurtador.msencurtadorurl.domain.GenericError;
import com.encurtador.msencurtadorurl.exception.ErrorToSendCommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Exception handler.
 */
@RestControllerAdvice
public class EncurtadorExceptionHandler {

    /**
     * Error message.
     */
    private static final String ERROR_MESSAGE_TAG = "Error: {}";

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EncurtadorExceptionHandler.class);


    @ExceptionHandler(ErrorToSendCommandException.class)
    public ResponseEntity<GenericError> encurtadorExceptionHandler(ErrorToSendCommandException errorToSendCommandException) {

        GenericError error = null;

        error = new GenericError("503", "Oooops, estamos com alguns problemas.");

        LOGGER.error(ERROR_MESSAGE_TAG, errorToSendCommandException.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
