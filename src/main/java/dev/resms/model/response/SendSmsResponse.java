package dev.resms.model.response;

import lombok.Getter;

/**
 * Response object returned after sending an SMS
 */
@Getter
public class SendSmsResponse {
    private String messageId;
    private String pinPointMessageId;
}
