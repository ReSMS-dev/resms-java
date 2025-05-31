package dev.resms.config;

import java.net.http.HttpClient;
import java.time.Duration;

/**
 * Configuration class for ReSMS SDK
 */
public class ReSMSConfig {
    private static final String BASE_URL = "https://api.resms.dev/";

    private final String apiKey;
    private final int timeoutSeconds;
    private final HttpClient httpClient;

    public ReSMSConfig(String apiKey, int timeoutSeconds) {
        this.apiKey = apiKey.trim();
        this.timeoutSeconds = timeoutSeconds;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(timeoutSeconds))
                .build();
    }

    public String getApiKey() {
        return apiKey;
    }

    public int getTimeoutSeconds() {
        return timeoutSeconds;
    }

    public String getUrl() {
        return BASE_URL;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }
}
