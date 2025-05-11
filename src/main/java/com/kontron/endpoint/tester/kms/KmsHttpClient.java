package com.kontron.endpoint.tester.kms;

import com.kontron.endpoint.tester.config.KmsProperties;
import com.kontron.endpoint.tester.http.HttpClientHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.kms.alarms.http-enabled", havingValue = "true")
public class KmsHttpClient {
    private final Logger log = LoggerFactory.getLogger(KmsHttpClient.class);

    private final KmsProperties properties;
    private final HttpClientHandler httpClientHandler;

    public KmsHttpClient(KmsProperties properties,
                         HttpClientHandler httpClientHandler) {
        this.properties = properties;
        this.httpClientHandler = httpClientHandler;
        log.debug("KMS HTTP client initialized");
    }

    @Scheduled(initialDelay = 3000, fixedDelay = 5000)
    public void pollAlarms() {
        httpClientHandler.fetch(
                "KMS CNMS alarms",
                properties.getAlarmUrl()
        ).subscribe();
    }
}

