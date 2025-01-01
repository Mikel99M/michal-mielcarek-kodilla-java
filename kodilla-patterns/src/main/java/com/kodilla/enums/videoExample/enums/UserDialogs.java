package com.kodilla.enums.videoExample.enums;

import java.util.Scanner;

public class UserDialogs {
    public static UserSelection getUserSelection() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice S, R, P: ");
            String s = scanner.nextLine().toUpperCase();
            switch (s) {
                case "S":
                    return UserSelection.SCISSORS;
                case "P":
                    return UserSelection.PAPER;
                case "R":
                    return UserSelection.ROCK;
                default:
                    System.out.println("Your selection is wrong. Choose again.");
            }
        }
    }
}
