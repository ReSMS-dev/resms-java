package dev.resms.exception.sms;

import dev.resms.exception.ReSMSException;

public class InsufficientSmsQuotaException extends ReSMSException {
  public InsufficientSmsQuotaException(String message) {
    super(message);
  }
}
