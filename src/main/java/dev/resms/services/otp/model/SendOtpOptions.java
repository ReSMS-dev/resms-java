package dev.resms.services.otp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SendOtpOptions {
  private String to;
  private String message;
  private String senderId;
  private OtpCode codeType;
  private int codeLength;
  private int validityMinutes;
}
