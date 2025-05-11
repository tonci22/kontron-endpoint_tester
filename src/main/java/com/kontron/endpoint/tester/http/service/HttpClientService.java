package com.kontron.endpoint.tester.http.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class HttpClientService {
    private final WebClient webClient;

    public Mono<String> fetch(String url) {
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
    }
}