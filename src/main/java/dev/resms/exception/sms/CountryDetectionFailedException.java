package dev.resms.exception.sms;

import dev.resms.exception.ReSMSException;

public class CountryDetectionFailedException extends ReSMSException {
  public CountryDetectionFailedException(String message) {
    super(message);
  }
}
