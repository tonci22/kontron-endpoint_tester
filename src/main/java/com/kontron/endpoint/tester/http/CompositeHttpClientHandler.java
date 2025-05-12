package com.kontron.endpoint.tester.http;

import com.kontron.endpoint.tester.http.service.HttpClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class CompositeHttpClientHandler {

    private final List<HttpClientService> httpClientServices;

    @Scheduled(initialDelay = 3000, fixedDelay = 5000)
    public void fetchAlarms() {
        log.debug("Fetching ALARM data from endpoints...");
        httpClientServices.forEach(HttpClientService::fetchAlarms);
    }

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void fetchPerformance() {
        log.debug("Fetching PERFORMANCE data from endpoints...");
        httpClientServices.forEach(HttpClientService::fetchPerformance);
    }

}
