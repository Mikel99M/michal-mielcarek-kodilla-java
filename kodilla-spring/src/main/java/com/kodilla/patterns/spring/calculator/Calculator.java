package com.kodilla.patterns.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    private Display display;

    public Calculator() {
        display = new Display();
    }

    public double add(double a, double b) {
        double result = a + b;
        display.displayValue(result);
        return result;
    }
    public double sub(double a, double b) {
        double result = a - b;
        display.displayValue(result);
        return result;
    }
    public double mul(double a, double b) {
        double result = a * b;
        display.displayValue(result);
        return result;
    }
    public double div(double a, double b) {
        double result = a / b;
        display.displayValue(result);
        return result;
    }
}
