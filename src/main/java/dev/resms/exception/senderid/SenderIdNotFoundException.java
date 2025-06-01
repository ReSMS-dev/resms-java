package dev.resms.exception.senderid;

import dev.resms.exception.ReSMSException;

public class SenderIdNotFoundException extends ReSMSException {
    public SenderIdNotFoundException(String message) {
        super(message);
    }
}
