package com.kontron.endpoint.tester.http;

import com.kontron.endpoint.tester.http.service.HttpClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Component
public class HttpClientHandler {
    private final Logger log = LoggerFactory.getLogger(HttpClientHandler.class);

    private final HttpClientService httpClientService;

    public HttpClientHandler(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }

    public Mono<String> fetch(String endpointName, String url) {
        return httpClientService.fetch(url)
                .doOnNext(response -> log.info("{}: \n{}", endpointName, response))
                .doOnError(error -> {
                    if (error instanceof WebClientResponseException.NotFound) {
                        log.error("{}: Endpoint not found", endpointName);
                    } else if (error instanceof WebClientRequestException) {
                        log.error("{}: Location not reachable", endpointName);
                    }
                    else {
                        log.error("{}: Error: {}", endpointName, error);
                    }
                })
                .onErrorResume(error -> Mono.empty());
    }

}
