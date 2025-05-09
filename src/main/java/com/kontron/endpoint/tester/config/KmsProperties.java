package com.kontron.endpoint.tester.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "app.kms")
@Configuration
public class KmsProperties extends BaseProperties {

}

