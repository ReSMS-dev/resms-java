package dev.resms.services.sms.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SendSmsOptions {
  private String to;
  private String message;
  private String senderId;
}
