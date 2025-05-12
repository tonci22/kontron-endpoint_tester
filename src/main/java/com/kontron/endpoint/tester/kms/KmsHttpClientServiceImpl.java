package com.kontron.endpoint.tester.kms;

import com.kontron.endpoint.tester.config.KmsProperties;
import com.kontron.endpoint.tester.http.service.HttpClientService;
import com.kontron.endpoint.tester.http.utils.HttpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
@ConditionalOnProperty(name = "app.kms.alarms.http-enabled", havingValue = "true")
public class KmsHttpClientServiceImpl implements HttpClientService {

    private final WebClient kmsWebClient;
    private final KmsProperties properties;

    @Override
    public void fetch() {
        String endpointName = "KMS CNMS alarms";
        String url = properties.getAlarmUrl();

        HttpUtils.constructRequest(kmsWebClient, HttpMethod.GET, url, String.class)
                .doOnNext(response -> log.info("{} ({}): \n{}", endpointName, url, response))
                .doOnError(error -> log.error(HttpUtils.handleError(endpointName, url, error)))
                .onErrorResume(error -> Mono.empty()).subscribe();
    }
}
