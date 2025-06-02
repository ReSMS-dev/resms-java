package dev.resms.model.response;

import dev.resms.model.Response;
import lombok.Getter;

/** Response object returned after sending an SMS */
@Getter
public class SendSmsResponse extends Response {
  private SendSmsResponseData data;

  @Getter
  public static class SendSmsResponseData {
    private String messageId;
  }
}
