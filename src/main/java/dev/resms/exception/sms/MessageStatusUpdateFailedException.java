package dev.resms.exception.sms;

import dev.resms.exception.ReSMSException;

public class MessageStatusUpdateFailedException extends ReSMSException {
    public MessageStatusUpdateFailedException(String message) {
        super(message);
    }
}