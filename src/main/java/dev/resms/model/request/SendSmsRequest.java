package dev.resms.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/** Request object for sending SMS */
@Getter
@AllArgsConstructor
public class SendSmsRequest {
  @NonNull private final String to;
  @NonNull private final String message;
}
