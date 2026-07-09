package com.company.junitadvanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    final ExceptionThrower thrower = new ExceptionThrower();

    @Test
    public void testThrowExceptionWithNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(null);
        });
        assertEquals("Message cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testThrowExceptionWithEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException("   ");
        });
        assertEquals("Message cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testNoExceptionThrown() {
        assertDoesNotThrow(() -> {
            thrower.throwException("Valid message");
        });
    }
}
