package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("TheForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("TheForumUser")) {
            System.out.println("test ok");
        } else {
            System.out.println("Error");
        }

        System.out.println("Test - pierwszy test jednostkowy:");

        Calculator kalkulator = new Calculator();

        int a = 5;
        int b = 10;

        int resultOfSum = kalkulator.add(a, b);
        int resultOfSubtract = kalkulator.subtract(a, b);

        if (4 == resultOfSum) {
            System.out.println("test ok");
        } else {
            System.out.println("Error");
        }

        if (a - b == resultOfSubtract) {
            System.out.println("test ok");
        } else {
            System.out.println("Error");
        }
    }
}
