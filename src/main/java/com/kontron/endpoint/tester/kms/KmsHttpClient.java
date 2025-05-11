package com.kontron.endpoint.tester.kms;

import com.kontron.endpoint.tester.config.KmsProperties;
import com.kontron.endpoint.tester.http.HttpClientHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
@ConditionalOnProperty(name = "app.kms.alarms.http-enabled", havingValue = "true")
public class KmsHttpClient {

    private final KmsProperties properties;
    private final HttpClientHandler httpClientHandler;

    static {
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

