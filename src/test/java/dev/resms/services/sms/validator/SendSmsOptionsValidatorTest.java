package dev.resms.services.sms.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import dev.resms.core.exception.ReSMSException;
import dev.resms.services.sms.model.SendSmsOptions;
import org.junit.jupiter.api.Test;

class SendSmsOptionsValidatorTest {
  @Test
  void testValidate_validOptions() {
    SendSmsOptions options = SendSmsOptions.builder().to("+1234567890").message("test").build();
    assertDoesNotThrow(() -> SendSmsOptionsValidator.validate(options));
  }

  @Test
  void testValidate_emptyPhoneNumber() {
    SendSmsOptions options = SendSmsOptions.builder().to(" ").message("test").build();
    ReSMSException ex =
        assertThrows(ReSMSException.class, () -> SendSmsOptionsValidator.validate(options));
    assertEquals("Phone number cannot be empty", ex.getMessage());
  }

  @Test
  void testValidate_invalidPhoneNumberFormat() {
    SendSmsOptions options = SendSmsOptions.builder().to("123abc").message("test").build();
    ReSMSException ex =
        assertThrows(ReSMSException.class, () -> SendSmsOptionsValidator.validate(options));
    assertEquals("Invalid phone number format", ex.getMessage());
  }

  @Test
  void testValidate_emptyMessage() {
    SendSmsOptions options = SendSmsOptions.builder().to("+1234567890").message(" ").build();
    ReSMSException ex =
        assertThrows(ReSMSException.class, () -> SendSmsOptionsValidator.validate(options));
    assertEquals("Message cannot be empty", ex.getMessage());
  }
}
