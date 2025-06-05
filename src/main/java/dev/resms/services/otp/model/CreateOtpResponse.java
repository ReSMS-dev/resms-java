package dev.resms.services.otp.model;

import dev.resms.core.model.Response;
import lombok.Getter;

@Getter
public class CreateOtpResponse extends Response {
  private CreateOtpResponseData data;

  @Getter
  public static class CreateOtpResponseData {
    private String phoneNumber;
    private String expiresAt;
  }
}
