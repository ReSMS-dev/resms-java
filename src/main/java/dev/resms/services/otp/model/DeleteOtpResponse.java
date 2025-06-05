package dev.resms.services.otp.model;

import lombok.Getter;

@Getter
public class DeleteOtpResponse {
  private String otpId;
  private String phoneNumber;
  private String revokedAt;
}
