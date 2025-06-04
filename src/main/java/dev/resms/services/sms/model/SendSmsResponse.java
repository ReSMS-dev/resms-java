package dev.resms.services.sms.model;

import dev.resms.core.model.Response;
import lombok.Getter;

/** Represents a response after sending an SMS. */
@Getter
public class SendSmsResponse extends Response {
  private SendSmsResponseData data;

  @Getter
  public static class SendSmsResponseData {
    private String messageId;
  }
}
