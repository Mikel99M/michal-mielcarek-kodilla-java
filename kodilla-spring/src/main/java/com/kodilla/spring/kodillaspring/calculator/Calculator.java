package com.kodilla.spring.kodillaspring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    private Display display;

    public Calculator(Display display) {
        this.display = display;
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
