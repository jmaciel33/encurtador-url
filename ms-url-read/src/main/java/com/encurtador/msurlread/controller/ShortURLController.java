package com.encurtador.msurlread.controller;

import com.encurtador.msurlread.domain.OriginalURLDTO;
import com.encurtador.msurlread.exception.URLNotFoundException;
import com.encurtador.msurlread.service.ShortURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("encurtador/v1")
public class ShortURLController {

    @Autowired
    private ShortURLService shortURLService;

    @GetMapping(value = "/{shortURL}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public DeferredResult<ResponseEntity<?>> getShort(@PathVariable("shortURL") String shortURL) throws URLNotFoundException {

        final DeferredResult<ResponseEntity<?>> response = new DeferredResult<>();
        final OriginalURLDTO originalURLDTO = this.shortURLService.getOriginalURL(shortURL);
        response.setResult(new ResponseEntity<>(originalURLDTO, HttpStatus.OK));

        return response;
    }


    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public DeferredResult<ResponseEntity<?>> getAllShortUrl() throws URLNotFoundException {
        final DeferredResult<ResponseEntity<?>> response = new DeferredResult<>();
        response.setResult(new ResponseEntity<>(this.shortURLService.getAllUrls(), HttpStatus.OK));

        return response;
    }
}
