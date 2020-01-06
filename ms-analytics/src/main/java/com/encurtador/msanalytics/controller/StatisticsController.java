package com.encurtador.msanalytics.controller;

import com.encurtador.msanalytics.domain.StatisticsDTO;
import com.encurtador.msanalytics.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;


@RestController
@RequestMapping("statistics/v1")
public class StatisticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping(value = "/{shortURL}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public DeferredResult<ResponseEntity<?>> deleteShortURL(@PathVariable("shortURL") String shortURL) {

        final DeferredResult<ResponseEntity<?>> response = new DeferredResult<>();
        final StatisticsDTO statisticsDTO = this.analyticsService.getStatistics(shortURL);
        response.setResult(new ResponseEntity<>(statisticsDTO, HttpStatus.OK));

        return response;
    }
}
