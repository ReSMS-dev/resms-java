package dev.resms.services.otp.model;

import dev.resms.core.model.Response;
import lombok.Getter;

@Getter
public class VerifyOtpResponse extends Response {
  private VerifyOtpResponseData data;

  @Getter
  public static class VerifyOtpResponseData {
    private String otpId;
    private String phoneNumber;
    private String verifiedAt;
  }
}
