package dev.resms.core.net.impl;

import dev.resms.core.net.AbstractHttpResponse;
import dev.resms.core.net.HttpMethod;
import dev.resms.core.net.IHttpClient;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * An implementation of the {@link IHttpClient} interface for performing HTTP requests. This
 * implementation uses the OkHttp library for handling HTTP communication.
 */
public class HttpClient implements IHttpClient<Response> {

  /** The base URL for the API. */
  public static final String BASE_API = "https://api.resms.dev/";

  /** The OkHttpClient instance for handling HTTP requests. */
  private final OkHttpClient httpClient;

  /** Constructs an instance of the HttpClient. */
  public HttpClient() {
    this.httpClient = new OkHttpClient();
  }

  /**
   * Performs an HTTP request with the specified path, HTTP method, and payload.
   *
   * @param path The path or endpoint of the request.
   * @param apiKey The API Key used to authenticate the request.
   * @param method The HTTP method (GET, POST, PUT, DELETE, etc.).
   * @param payload The payload or data to send with the request.
   * @return An {@link AbstractHttpResponse} representing the response from the server.
   */
  @Override
  public AbstractHttpResponse<Response> perform(
      final String path, final String apiKey, final HttpMethod method, final String payload) {

    RequestBody requestBody = null;
    if (payload != null) {
      requestBody = RequestBody.create(payload, MediaType.get("application/json"));
    }

    Request request =
        new Request.Builder()
            .url(BASE_API + path)
            .addHeader("Accept", "application/json")
            .addHeader("X-Api-Key", apiKey)
            .method(method.name(), requestBody)
            .build();

    try {
      Response response = httpClient.newCall(request).execute();
      return new AbstractHttpResponse(
          response.code(), response.body().string(), response.isSuccessful());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
