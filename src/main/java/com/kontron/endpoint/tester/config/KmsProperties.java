package com.kontron.endpoint.tester.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.kms")
public class KmsProperties extends BaseProperties {

}

