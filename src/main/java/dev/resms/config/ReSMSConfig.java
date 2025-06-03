package dev.resms.config;

import lombok.Getter;
import lombok.NonNull;

/** Configuration class for ReSMS SDK */
@Getter
public class ReSMSConfig {
  public static final String BASE_URL = "https://api.resms.dev/";

  private final String apiKey;

  public ReSMSConfig(@NonNull String apiKey) {
    if (apiKey.isBlank()) {
      throw new IllegalArgumentException("API key cannot be blank");
    }
    this.apiKey = apiKey.trim();
  }
}
