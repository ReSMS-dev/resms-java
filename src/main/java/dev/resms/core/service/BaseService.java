package dev.resms.core.service;

import dev.resms.core.mapper.ReSMSMapper;
import dev.resms.core.net.IHttpClient;
import dev.resms.core.net.impl.HttpClient;
import lombok.Getter;

/**
 * An abstract base class for service implementations, providing common functionality such as HTTP
 * client, authentication provider, and mapper initialization.
 */
@Getter
public abstract class BaseService {

  /** Apikey used for authenticating requests. */
  protected final String apiKey;

  /** HTTP client for making HTTP requests. */
  protected final IHttpClient httpClient;

  /** Mapper responsible for mapping data between different representations. */
  protected final ReSMSMapper reSMSMapper;

  /**
   * Constructs a BaseService instance with the specified authentication provider, default HTTP
   * client, and mapper.
   *
   * @param apiKey The apiKey to use.
   */
  protected BaseService(final String apiKey) {
    this.apiKey = apiKey;
    this.httpClient = new HttpClient();
    this.reSMSMapper = new ReSMSMapper();
  }
}
