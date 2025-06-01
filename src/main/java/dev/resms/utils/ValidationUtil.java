package dev.resms.utils;

import dev.resms.exception.ReSMSException;
import dev.resms.model.request.SendSmsRequest;

public class ValidationUtil {

    /**
     * Validates a phone number format
     *
     * @param phoneNumber Phone number to validate
     * @throws ReSMSException if the phone number is invalid
     */
    public static void validatePhoneNumber(String phoneNumber) throws ReSMSException {
        if (phoneNumber == null) {
            throw new ReSMSException("Phone number is required");
        }

        if (phoneNumber.trim().isEmpty()) {
            throw new ReSMSException("Phone number cannot be empty");
        }

        String cleanNumber = phoneNumber.trim();
        if (!cleanNumber.matches("^\\+?[1-9]\\d{1,14}$")) {
            throw new ReSMSException("Invalid phone number format");
        }
    }

    /**
     * Validates message content
     *
     * @param message Message to validate
     * @throws ReSMSException if a message is invalid
     */
    public static void validateMessage(String message) throws ReSMSException {
        if (message == null) {
            throw new ReSMSException("Message is required");
        }

        if (message.trim().isEmpty()) {
            throw new ReSMSException("Message cannot be empty");
        }
    }

    /**
     * Validates SendSmsRequest object
     *
     * @param request Request to validate
     * @throws ReSMSException if the request is invalid
     */
    public static void validateSendSmsRequest(SendSmsRequest request) throws ReSMSException {
        if (request == null) {
            throw new ReSMSException("SendSmsRequest is required");
        }

        validatePhoneNumber(request.getTo());
        validateMessage(request.getMessage());
    }
}