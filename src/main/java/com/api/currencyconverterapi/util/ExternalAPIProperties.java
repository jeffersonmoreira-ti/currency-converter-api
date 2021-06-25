package com.api.currencyconverterapi.util;

public class ExternalAPIProperties {
    private String baseURL;
    private String key;
    private String latestPath;

    public ExternalAPIProperties(PropertiesLoader propertiesLoader) {

        if (propertiesLoader != null) {
            this.setBaseURL(propertiesLoader.getPropertyValue("baseurl"));
            this.setKey(propertiesLoader.getPropertyValue("key"));
        }
    }

    public ExternalAPIProperties(String baseURL, String key, String latestPath) {
        this.baseURL = baseURL;
        this.key = key;
        this.latestPath = latestPath;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLatestPath() {
        return latestPath;
    }

    public void setLatestPath(String latestPath) {
        this.latestPath = latestPath;
    }
}
