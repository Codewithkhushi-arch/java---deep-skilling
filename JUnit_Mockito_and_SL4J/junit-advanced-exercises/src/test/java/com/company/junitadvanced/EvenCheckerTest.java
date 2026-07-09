package com.company.junitadvanced;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {

    private final EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 10, -8, 100})
    public void testIsEvenWithEvenNumbers(int number) {
        assertTrue(checker.isEven(number), () -> number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 15, -7, 101})
    public void testIsEvenWithOddNumbers(int number) {
        assertFalse(checker.isEven(number), () -> number + " should not be even");
    }
}
