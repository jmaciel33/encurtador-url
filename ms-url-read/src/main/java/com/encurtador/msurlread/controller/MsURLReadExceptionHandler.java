package com.encurtador.msurlread.controller;

import com.encurtador.msurlread.domain.GenericError;
import com.encurtador.msurlread.exception.URLNotFoundException;
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
public class MsURLReadExceptionHandler {

    /**
     * Error message.
     */
    private static final String ERROR_MESSAGE_TAG = "Error: {}";

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MsURLReadExceptionHandler.class);


    @ExceptionHandler(URLNotFoundException.class)
    public ResponseEntity<GenericError> urlNotFoundExceptionHandler(URLNotFoundException urlNotFoundException) {

        GenericError error = null;

        error = new GenericError("404", urlNotFoundException.getMessage());

        LOGGER.error(ERROR_MESSAGE_TAG, urlNotFoundException.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
