package com.kontron.endpoint.tester.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public abstract class BaseProperties {
    private String baseUrl;
    private String pathPrefix;
    private String alarmsPath = "";
    private boolean httpEnabled = true;
    private boolean controllerEnabled = true;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getPathPrefix() {
        return pathPrefix;
    }

    public void setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
    }

    public String getAlarmsPath() {
        return alarmsPath;
    }

    public void setAlarmsPath(String alarmsPath) {
        this.alarmsPath = alarmsPath;
    }

    public boolean isHttpEnabled() {
        return httpEnabled;
    }

    public void setHttpEnabled(boolean httpEnabled) {
        this.httpEnabled = httpEnabled;
    }

    public boolean isControllerEnabled() {
        return controllerEnabled;
    }

    public void setControllerEnabled(boolean controllerEnabled) {
        this.controllerEnabled = controllerEnabled;
    }

    public String getFullUrl() {
        // Remove trailing slash from baseUrl if present
        String normalizedBaseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        // Normalize path components
        String normalizedPrefix = pathPrefix != null ? "/" + pathPrefix.replaceAll("^/+|/+$", "") : "";
        String normalizedPath = alarmsPath != null ? "/" + alarmsPath.replaceAll("^/+|/+$", "") : "";

        return normalizedBaseUrl + normalizedPrefix + normalizedPath;
    }
}
