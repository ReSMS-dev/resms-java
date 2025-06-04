package dev.resms.services.sms.validator;

import dev.resms.core.exception.ReSMSException;
import dev.resms.services.sms.model.SendSmsOptions;

public class SendSmsOptionsValidator {
  private static final String PHONE_NUMBER_REGEX = "^\\+?[1-9]\\d{1,14}$";

  public static void validate(SendSmsOptions sendSmsOptions) {
    validatePhoneNumber(sendSmsOptions.getTo());
    validateMessage(sendSmsOptions.getMessage());
  }

  /**
   * Validates a phone number format
   *
   * @param phoneNumber Phone number to validate
   * @throws ReSMSException if the phone number is invalid
   */
  private static void validatePhoneNumber(String phoneNumber) throws ReSMSException {
    if (phoneNumber.isBlank()) {
      throw new ReSMSException("Phone number cannot be empty");
    }

    if (!phoneNumber.matches(PHONE_NUMBER_REGEX)) {
      throw new ReSMSException("Invalid phone number format");
    }
  }

  /**
   * Validates message content
   *
   * @param message Message to validate
   * @throws ReSMSException if a message is invalid
   */
  private static void validateMessage(String message) throws ReSMSException {
    if (message.isBlank()) {
      throw new ReSMSException("Message cannot be empty");
    }
  }
}
