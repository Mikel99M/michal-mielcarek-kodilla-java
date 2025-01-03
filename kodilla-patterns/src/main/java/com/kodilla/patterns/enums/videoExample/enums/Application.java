package com.kodilla.patterns.enums.videoExample.enums;

public class Application {
    public static void main(String[] args) {
        UserSelection userSelection = UserDialogs.getUserSelection();
        System.out.println(userSelection);
        if (userSelection == UserSelection.SCISSORS) {
            System.out.println("your selection is Scissors");
        } else if (userSelection == UserSelection.ROCK) {
            System.out.println("your selection is Rock");
        } else if (userSelection == UserSelection.PAPER) {
            System.out.println("your selection is Paper");
        }
    }
}
