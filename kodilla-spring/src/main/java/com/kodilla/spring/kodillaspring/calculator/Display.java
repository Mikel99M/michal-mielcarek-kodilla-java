package com.kodilla.spring.kodillaspring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Display {

    public void displayValue(double val) {
        System.out.println("The result is: " + val);
    }

}
