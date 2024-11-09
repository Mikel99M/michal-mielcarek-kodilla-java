package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;


import com.kodilla.testing.collection.oddNumbersExterminator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("TheForumUser", "John Smith");

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

        if (a + b == resultOfSum) {
            System.out.println("test ok");
        } else {
            System.out.println("Error");
        }

        if (a - b == resultOfSubtract) {
            System.out.println("test ok");
        } else {
            System.out.println("Error");
        }

        oddNumbersExterminator exterminator = new oddNumbersExterminator();
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 8, 100));
        List<Integer> list1 = new LinkedList<Integer>();
        System.out.println(exterminator.exterminate(list1));



    }
}
