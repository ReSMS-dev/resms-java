package dev.resms.exception.user;

import dev.resms.exception.ReSMSException;

public class InvalidApiKeyException extends ReSMSException {
    public InvalidApiKeyException(String message) {
        super(message);
    }
}
