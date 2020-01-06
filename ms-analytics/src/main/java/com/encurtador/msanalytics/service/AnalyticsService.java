package com.encurtador.msanalytics.service;

import com.encurtador.msanalytics.domain.StatisticsDTO;

/**
 * The interface Analytics service.
 */
public interface AnalyticsService {

    /**
     * Gets statistics.
     *
     * @param shortURL the short url
     * @return the statistics
     */
    StatisticsDTO getStatistics(String shortURL);

}
