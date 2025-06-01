package dev.resms.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Request object for sending SMS
 */
@Getter
@AllArgsConstructor
public class SendSmsRequest {
    private final String to;
    private final String message;
}
