package dev.resms.core.net;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an HTTP response containing the response code, body, and success status.
 *
 * @param <T> The type of the response body.
 */
@Getter
@Setter
@AllArgsConstructor
public class AbstractHttpResponse<T> {

  /** The HTTP response code. */
  private int code;

  /** The response body. */
  private T body;

  /** Indicates whether the HTTP request was successful. */
  private boolean isSuccessful;
}
