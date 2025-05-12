package com.kontron.endpoint.tester.http.utils;

import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

public class HttpUtils {

    public static <T> Mono<T> constructRequest(WebClient webClient, HttpMethod httpMethod, String url, Class<T> responseType) {
        return webClient.method(httpMethod)
                .uri(url)
                .retrieve()
                .bodyToMono(responseType);
    }

    public static String handleError(String endpointName, String url, Throwable error) {
        String errorOutput;
        if (error instanceof WebClientResponseException.NotFound) {
            errorOutput = String.format("%s: Endpoint not found (%s)", endpointName, url);
        } else if (error instanceof WebClientRequestException) {
            errorOutput = String.format("%s: Location not reachable (%s)", endpointName, url);
        } else {
            errorOutput = String.format("%s (%s): Error: %s", endpointName, url, error.getLocalizedMessage());
        }
        return errorOutput;
    }
}
