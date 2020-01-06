package com.encurtador.msencurtadorurl.controller;

import com.encurtador.msencurtadorurl.domain.GenericError;
import com.encurtador.msencurtadorurl.domain.OriginalURLDTO;
import com.encurtador.msencurtadorurl.domain.ShortURLDTO;
import com.encurtador.msencurtadorurl.exception.ErrorToSendCommandException;
import com.encurtador.msencurtadorurl.service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.net.URISyntaxException;

@RestController
@RequestMapping("encurtador/v1")
@Api(value = "Encurtador URL", tags = {"Encurtador URL"})
public class EncurtadorController {

    @Autowired
    private EventService eventService;

    @ApiOperation(
            notes = "Cria uma link com URL encurtada.", value = "Cria uma link com URL encurtada.",
            response = ShortURLDTO.class)
    @ApiResponses({
            @ApiResponse(code = 202, message = "Success", response = ShortURLDTO.class),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 503, message = "Unavailable", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GenericError.class)})
    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public DeferredResult<ResponseEntity<?>> createShortURL(@RequestBody OriginalURLDTO originalURLDTO) throws ErrorToSendCommandException {

        final DeferredResult<ResponseEntity<?>> response = new DeferredResult<>();
        response.setResult(new ResponseEntity<>(this.eventService.commandCreate(
                originalURLDTO.getOriginalURL()), HttpStatus.CREATED));

        return response;
    }

    @ApiOperation(notes = "Deletar URL encurtada.", value = "Deletar URL encurtada.")
    @ApiResponses({
            @ApiResponse(code = 202, message = "Success", response = ShortURLDTO.class),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 503, message = "Unavailable", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GenericError.class)})
    @DeleteMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public DeferredResult<ResponseEntity<?>> deleteShortURL(@RequestBody ShortURLDTO shortURLDTO) throws ErrorToSendCommandException, URISyntaxException {

        final DeferredResult<ResponseEntity<?>> response = new DeferredResult<>();
        this.eventService.commandDelete(shortURLDTO.getShortURL());
        response.setResult(new ResponseEntity<>(HttpStatus.ACCEPTED));

        return response;
    }



}
