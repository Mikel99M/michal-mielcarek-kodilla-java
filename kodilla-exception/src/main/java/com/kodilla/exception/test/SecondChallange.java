package com.kodilla.exception.test;

public class SecondChallange {

    public String probablyIWillThrowException(double x, double y) throws Exception {
        if (x >= 2 || x < 1 || y == 1.5) {
            throw new Exception();
        }
        return "Done!";
    }

    public static void main(String[] args) {

        SecondChallange s = new SecondChallange();

        try {
            System.out.println(s.probablyIWillThrowException(1, 3));
        } catch (Exception e) {
            System.out.println("EXCEPTION");
        }

    }
}
