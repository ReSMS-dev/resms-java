package dev.resms.util;

import dev.resms.exception.ReSMSException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidationUtilTest {
    @Test
    void testValidatePhoneNumber_validNumber() {
        assertDoesNotThrow(() -> ValidationUtil.validatePhoneNumber("+1234567890"));
    }

    @Test
    void testValidatePhoneNumber_emptyNumber() {
        ReSMSException ex = assertThrows(ReSMSException.class, () -> ValidationUtil.validatePhoneNumber("  "));
        assertEquals("Phone number is required", ex.getMessage());
    }

    @Test
    void testValidatePhoneNumber_invalidFormat() {
        ReSMSException ex = assertThrows(ReSMSException.class,
                () -> ValidationUtil.validatePhoneNumber("123abc"));
        assertEquals("Invalid phone number format", ex.getMessage());
    }

    @Test
    void testValidateMessage_validMessage() {
        assertDoesNotThrow(() -> ValidationUtil.validateMessage("Hello!"));
    }

    @Test
    void testValidateMessage_empty() {
        ReSMSException ex = assertThrows(ReSMSException.class,
                () -> ValidationUtil.validateMessage("   "));
        assertEquals("Message cannot be empty", ex.getMessage());
    }
}
