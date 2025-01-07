package com.kodilla.spring.kodillaspring.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSuite {

    @Test
    void testCalculations() {

        //Given
        Calculator calculator = new Calculator();
        double a = 10;
        double b = 30;

        //Then
        assertEquals(a + b, calculator.add(a, b));
        assertEquals(a - b, calculator.sub(a, b));
        assertEquals(a * b, calculator.mul(a, b));
        assertEquals(a / b, calculator.div(a, b));


    }
}
