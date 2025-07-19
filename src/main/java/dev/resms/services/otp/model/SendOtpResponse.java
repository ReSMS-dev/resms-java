package dev.resms.services.otp.model;

import dev.resms.core.model.Response;
import lombok.Getter;

@Getter
public class SendOtpResponse extends Response {
  private SendOtpResponseData data;

  @Getter
  public static class SendOtpResponseData {
    private String phoneNumber;
    private String expiresAt;
  }
}
