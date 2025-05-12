package com.kontron.endpoint.tester.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public abstract class BaseProperties {
    private String baseUrl;
    private MonitoringConfig alarms = new MonitoringConfig();
    private MonitoringConfig performance = new MonitoringConfig();
    private final McpttSecurity mcpttSecurity = new McpttSecurity();


    public String getAlarmControllerUrl() {
        return getFullUrl(alarms.getControllerPath());
    }

    public String getPerformanceControllerUrl() {
        return getFullUrl(performance.getControllerPath());
    }

    public String getAlarmHttpUrl() {
        return getFullUrl(alarms.getHttpPath());
    }

    public String getPerformanceHttpUrl() {
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

    @Getter
    public static class McpttSecurity {
        private final Map<String, String> assertedIdentityAuthorities = new HashMap<>();

    }
}
