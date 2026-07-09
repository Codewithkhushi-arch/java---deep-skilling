package com.company.springtest.service;

import com.company.springtest.Application;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Application.class)
public class ParameterizedSpringTest {

    @Autowired
    private CalculatorService calculatorService;

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 5, 10",
            "10, -3, 7",
            "0, 0, 0"
    })
    public void testAddWithVariousInputs(int a, int b, int expected) {
        assertEquals(expected, calculatorService.add(a, b));
    }
}
