package dev.resms.services.otp.model;

import dev.resms.core.model.Response;
import lombok.Getter;

@Getter
public class DeleteOtpResponse extends Response {
  private String otpId;
  private String phoneNumber;
  private String revokedAt;
}
