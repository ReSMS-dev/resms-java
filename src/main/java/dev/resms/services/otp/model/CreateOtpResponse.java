package dev.resms.services.otp.model;

import lombok.Getter;

@Getter
public class CreateOtpResponse {
  private CreateOtpResponseData data;

  @Getter
  public static class CreateOtpResponseData {
    private String phoneNumber;
    private String expiresAt;
  }
}
