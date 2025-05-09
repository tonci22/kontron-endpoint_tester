package com.kontron.endpoint.tester.http.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HttpClientService {
    private final WebClient webClient;

    public HttpClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> fetch(String url) {
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
    }
}