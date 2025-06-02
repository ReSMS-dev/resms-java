package dev.resms.model;

import lombok.Getter;

@Getter
public class ErrorResponse extends Response {
  private ErrorDetails error;

  @Getter
  public static class ErrorDetails {
    private String name;
    private String message;
  }
}
