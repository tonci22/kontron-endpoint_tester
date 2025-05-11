package com.kontron.endpoint.tester.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class BaseProperties {
    private String baseUrl;
    private MonitoringConfig alarms;
    private MonitoringConfig performance;

    public String getAlarmUrl() {
        return getFullUrl(alarms.getHttpPath());
    }

    public String getPerformanceUrl() {
        return getFullUrl(performance.getHttpPath());
    }

    public String getFullUrl(String path) {
        String normalizedPath = path != null ? "/" + path.replaceAll("^/+|/+$", "") : "";
        return getBaseUrl() + normalizedPath;
    }

    @Getter
    @Setter
    @ToString
    public static class MonitoringConfig {
        private boolean controllerEnabled;
        private String controllerPath;
        private boolean httpEnabled;
        private String httpPath;
    }
}
