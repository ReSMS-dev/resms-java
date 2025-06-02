package dev.resms.config;

import java.net.http.HttpClient;
import java.time.Duration;
import lombok.Getter;
import lombok.NonNull;

/** Configuration class for ReSMS SDK */
@Getter
public class ReSMSConfig {
  public static final String BASE_URL = "https://api.resms.dev/";
  private static final int DEFAULT_TIMEOUT = 10;

  private final String apiKey;
  private final HttpClient httpClient;

  public ReSMSConfig(@NonNull String apiKey, int timeoutSeconds) {
    if (apiKey.isBlank()) {
      throw new IllegalArgumentException("API key cannot be blank");
    }

    this.apiKey = apiKey.trim();
    this.httpClient =
        HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(timeoutSeconds)).build();
  }

  public ReSMSConfig(String apiKey) {
    this(apiKey, DEFAULT_TIMEOUT);
  }
}
