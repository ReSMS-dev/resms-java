package dev.resms.validator;

import dev.resms.exception.validation.ReSMSValidationException;
import dev.resms.model.request.SendSmsRequest;
import lombok.NonNull;

public class SendSmsValidator {
  private static final String PHONE_NUMBER_REGEX = "^\\+?[1-9]\\d{1,14}$";

  public static void validate(@NonNull SendSmsRequest request) throws ReSMSValidationException {
    validatePhoneNumber(request.getTo());
    validateMessage(request.getMessage());
  }

  /**
   * Validates a phone number format
   *
   * @param phoneNumber Phone number to validate
   * @throws ReSMSValidationException if the phone number is invalid
   */
  public static void validatePhoneNumber(@NonNull String phoneNumber)
      throws ReSMSValidationException {
    if (phoneNumber.isBlank()) {
      throw new ReSMSValidationException("Phone number cannot be empty");
    }

    if (!phoneNumber.matches(PHONE_NUMBER_REGEX)) {
      throw new ReSMSValidationException("Invalid phone number format");
    }
  }

  /**
   * Validates message content
   *
   * @param message Message to validate
   * @throws ReSMSValidationException if a message is invalid
   */
  public static void validateMessage(@NonNull String message) throws ReSMSValidationException {
    if (message.isBlank()) {
      throw new ReSMSValidationException("Message cannot be empty");
    }
  }
}
