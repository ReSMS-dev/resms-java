package dev.resms.exception.senderid;

import dev.resms.exception.ReSMSException;

public class NoDefaultSenderIdException extends ReSMSException {
  public NoDefaultSenderIdException(String message) {
    super(message);
  }
}
