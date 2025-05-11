package com.kontron.endpoint.tester.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.cgms")
public class CgmsProperties extends BaseProperties {

}

