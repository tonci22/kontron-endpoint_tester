package com.kontron.endpoint.tester.cgms;

import com.kontron.endpoint.tester.config.CgmsProperties;
import com.kontron.endpoint.tester.http.HttpClientHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.cgms.http-enabled", havingValue = "true")
public class CgmsHttpClient {
    private final Logger log = LoggerFactory.getLogger(CgmsHttpClient.class);

    private final CgmsProperties properties;
    private final HttpClientHandler httpClientHandler;

    public CgmsHttpClient(CgmsProperties properties,
                          HttpClientHandler httpClientHandler) {
        this.properties = properties;
        this.httpClientHandler = httpClientHandler;
        log.debug("CGMS HTTP client initialized");
    }

    @Scheduled(initialDelay = 3000, fixedDelay = 5000)
    public void pollAlarms() {
        httpClientHandler.fetch(
               "CGMS CNMS alarms",
                properties.getFullUrl()
       ).subscribe();
    }
}
