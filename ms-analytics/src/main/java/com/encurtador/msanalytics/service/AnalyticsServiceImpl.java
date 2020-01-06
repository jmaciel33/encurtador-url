package com.encurtador.msanalytics.service;

import com.encurtador.msanalytics.domain.Read;
import com.encurtador.msanalytics.domain.StatisticsDTO;
import com.encurtador.msanalytics.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public StatisticsDTO getStatistics(String shortURL) {

        final List<Read> readList = this.eventRepository.findByReadKeyShortUrl(shortURL);
        return new StatisticsDTO(shortURL, readList.size());
    }
}
