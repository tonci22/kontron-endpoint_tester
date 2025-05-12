package com.kontron.endpoint.tester.kms;

import com.kontron.endpoint.tester.config.KmsProperties;
import com.kontron.endpoint.tester.http.service.HttpClientService;
import com.kontron.endpoint.tester.http.utils.HttpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class KmsHttpClientServiceImpl implements HttpClientService {

    private final WebClient kmsWebClient;
    private final KmsProperties properties;

    @Override
    public void fetchAlarms() {
        if (!properties.getAlarms().isHttpEnabled()) {
            log.debug("KMS Alarms HTTP client is disabled");
            return;
        }

        String endpointName = "KMS CNMS alarms";
        String url = properties.getAlarmHttpUrl();

        HttpUtils.constructRequest(kmsWebClient, HttpMethod.GET, url, String.class)
                .doOnNext(response -> log.info("{} ({}): \n{}", endpointName, url, response))
                .doOnError(error -> log.error(HttpUtils.handleError(endpointName, url, error)))
                .onErrorResume(error -> Mono.empty()).subscribe();
    }

    @Override
    public void fetchPerformance() {
        if (!properties.getPerformance().isHttpEnabled()) {
            log.debug("KMS Performance HTTP client is disabled");
            return;
        }

        String endpointName = "KMS performance management";
        String url = properties.getPerformanceHttpUrl();

        HttpUtils.constructRequest(kmsWebClient, HttpMethod.GET, url, String.class)
                .doOnNext(response -> log.info("{} ({}): \n{}", endpointName, url, response))
                .doOnError(error -> log.error(HttpUtils.handleError(endpointName, url, error)))
                .onErrorResume(error -> Mono.empty()).subscribe();
    }
}
