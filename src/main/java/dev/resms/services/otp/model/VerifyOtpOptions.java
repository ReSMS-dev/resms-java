package dev.resms.services.otp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VerifyOtpOptions {
  private String to;
  private String code;
}
