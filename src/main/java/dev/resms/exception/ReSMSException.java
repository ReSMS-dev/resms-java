package dev.resms.exception;

public class ReSMSException extends RuntimeException {
    public ReSMSException(String message) {
        super(message);
    }

    public ReSMSException(String message, Throwable cause) {
        super(message, cause);
    }
}
