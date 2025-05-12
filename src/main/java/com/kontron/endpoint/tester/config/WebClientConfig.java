package com.kontron.endpoint.tester.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Configuration
public class WebClientConfig {
    private static final String ASSERTED_IDENTITY_HEADER = "X-3GPP-Asserted-Identity";

    private final CgmsProperties cgmsProperties;
    private final KmsProperties kmsProperties;

    @Bean
    public WebClient cgmsWebClient() {
        return createWebClient(cgmsProperties.getMcpttSecurity());
    }

    @Bean
    public WebClient kmsWebClient() {
        return createWebClient(kmsProperties.getMcpttSecurity());
    }

    public WebClient createWebClient(BaseProperties.McpttSecurity mcpttSecurityProperties) {
        return WebClient
                .builder()
                .defaultHeader(ASSERTED_IDENTITY_HEADER, assertedIdentityValue(mcpttSecurityProperties))
                .build();
    }

    private String assertedIdentityValue(BaseProperties.McpttSecurity properties) {
        String identity = properties
                .getAssertedIdentityAuthorities()
                .keySet()
                .iterator()
                .next();
        return "\"" + identity + "\"";
    }

}