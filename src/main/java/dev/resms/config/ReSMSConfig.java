package dev.resms.config;

import java.net.http.HttpClient;
import java.time.Duration;
import lombok.Getter;

/** Configuration class for ReSMS SDK */
@Getter
public class ReSMSConfig {
  public static final String BASE_URL = "https://api.resms.dev/";

  private final String apiKey;
  private final int timeoutSeconds;
  private final HttpClient httpClient;

  public ReSMSConfig(String apiKey, int timeoutSeconds) {
    this.apiKey = apiKey.trim();
    this.timeoutSeconds = timeoutSeconds;
    this.httpClient =
        HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(timeoutSeconds)).build();
  }
}
