package dev.resms.exception.sms;

import dev.resms.exception.ReSMSException;

public class PhoneNumberParsingFailedException extends ReSMSException {
    public PhoneNumberParsingFailedException(String message) {
        super(message);
    }
}