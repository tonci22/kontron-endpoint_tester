package com.kontron.endpoint.tester.config;

public abstract class BaseProperties {
    private String baseUrl;
    private MonitoringConfig alarms;
    private MonitoringConfig performance;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

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



    public MonitoringConfig getAlarms() {
        return alarms;
    }

    public void setAlarms(MonitoringConfig alarms) {
        this.alarms = alarms;
    }

    public MonitoringConfig getPerformance() {
        return performance;
    }

    public void setPerformance(MonitoringConfig performance) {
        this.performance = performance;
    }


    public static class MonitoringConfig {
        private boolean controllerEnabled;
        private String controllerPath;
        private boolean httpEnabled;
        private String httpPath;

        // getters and setters
        public boolean isControllerEnabled() {
            return controllerEnabled;
        }

        public void setControllerEnabled(boolean controllerEnabled) {
            this.controllerEnabled = controllerEnabled;
        }

        public String getControllerPath() {
            return controllerPath;
        }

        public void setControllerPath(String controllerPath) {
            this.controllerPath = controllerPath;
        }

        public boolean isHttpEnabled() {
            return httpEnabled;
        }

        public void setHttpEnabled(boolean httpEnabled) {
            this.httpEnabled = httpEnabled;
        }

        public String getHttpPath() {
            return httpPath;
        }

        public void setHttpPath(String httpPath) {
            this.httpPath = httpPath;
        }
    }
}
