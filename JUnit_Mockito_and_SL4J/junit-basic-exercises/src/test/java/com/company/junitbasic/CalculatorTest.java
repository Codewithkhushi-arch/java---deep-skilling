package com.company.junitbasic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private SimpleCalculator calculator;

    @BeforeEach
    public void setUp() {
        System.out.println("Setting up the calculator instance...");
        calculator = new SimpleCalculator();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tearing down after the test execution...");
        calculator = null;
    }

    @Test
    public void testAddAAA() {
        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result, "10 + 20 should be 30");
    }

    @Test
    public void testSubtractAAA() {
        // Arrange
        int a = 20;
        int b = 10;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(10, result, "20 - 10 should be 10");
    }
}
