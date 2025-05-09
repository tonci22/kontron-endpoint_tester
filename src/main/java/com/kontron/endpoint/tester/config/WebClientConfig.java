package com.kontron.endpoint.tester.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .defaultHeader("X-3GPP-Asserted-Identity", "\"sip:testSystemAdminXUI\"")
                .build();
    }
}