package dev.resms.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import dev.resms.exception.validation.ReSMSValidationException;
import org.junit.jupiter.api.Test;

class SendSmsValidatorTest {
  @Test
  void testValidatePhoneNumber_validNumber() {
    assertDoesNotThrow(() -> SendSmsValidator.validatePhoneNumber("+1234567890"));
  }

  @Test
  void testValidatePhoneNumber_emptyNumber() {
    ReSMSValidationException ex =
        assertThrows(
            ReSMSValidationException.class, () -> SendSmsValidator.validatePhoneNumber("  "));
    assertEquals("Phone number cannot be empty", ex.getMessage());
  }

  @Test
  void testValidatePhoneNumber_invalidFormat() {
    ReSMSValidationException ex =
        assertThrows(
            ReSMSValidationException.class, () -> SendSmsValidator.validatePhoneNumber("123abc"));
    assertEquals("Invalid phone number format", ex.getMessage());
  }

  @Test
  void testValidateMessage_validMessage() {
    assertDoesNotThrow(() -> SendSmsValidator.validateMessage("Hello!"));
  }

  @Test
  void testValidateMessage_empty() {
    ReSMSValidationException ex =
        assertThrows(ReSMSValidationException.class, () -> SendSmsValidator.validateMessage("   "));
    assertEquals("Message cannot be empty", ex.getMessage());
  }
}
