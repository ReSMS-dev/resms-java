package dev.resms.util;

import dev.resms.model.request.SendSmsRequest;

public class ValidationUtil {

    /**
     * Validates a phone number format
     *
     * @param phoneNumber Phone number to validate
     * @throws Exception if the phone number is invalid
     */
    public static void validatePhoneNumber(String phoneNumber) throws Exception {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new Exception("Phone number is required");
        }

        String cleanNumber = phoneNumber.trim();
        if (!cleanNumber.matches("^\\+?[1-9]\\d{1,14}$")) {
            throw new Exception("Invalid phone number format");
        }
    }

    /**
     * Validates message content
     *
     * @param message Message to validate
     * @throws Exception if a message is invalid
     */
    public static void validateMessage(String message) throws Exception {
        if (message == null) {
            throw new Exception("Message is required");
        }

        if (message.trim().isEmpty()) {
            throw new Exception("Message cannot be empty");
        }
    }

    /**
     * Validates SendSmsRequest object
     *
     * @param request Request to validate
     * @throws Exception if the request is invalid
     */
    public static void validateSendSmsRequest(SendSmsRequest request) throws Exception {
        if (request == null) {
            throw new Exception("SendSmsRequest is required");
        }

        validatePhoneNumber(request.getTo());
        validateMessage(request.getMessage());
    }
}