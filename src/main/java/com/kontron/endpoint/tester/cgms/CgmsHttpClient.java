package com.kontron.endpoint.tester.cgms;

import com.kontron.endpoint.tester.config.CgmsProperties;
import com.kontron.endpoint.tester.http.HttpClientHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
@ConditionalOnProperty(name = "app.cgms.alarms.http-enabled", havingValue = "true")
public class CgmsHttpClient {

    private final CgmsProperties properties;
    private final HttpClientHandler httpClientHandler;

    static {
        log.debug("CGMS HTTP client initialized");
    }

    @Scheduled(initialDelay = 3000, fixedDelay = 5000)
    public void pollAlarms() {
        httpClientHandler.fetch(
               "CGMS CNMS alarms",
                properties.getAlarmUrl()
       ).subscribe();
    }
}
