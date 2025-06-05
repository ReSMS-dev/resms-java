package dev.resms.services.otp.model;

import lombok.Getter;

@Getter
public class VerifyOtpResponse {
  private VerifyOtpResponseData data;

  @Getter
  public static class VerifyOtpResponseData {
    private String otpId;
    private String phoneNumber;
    private String verifiedAt;
  }
}
