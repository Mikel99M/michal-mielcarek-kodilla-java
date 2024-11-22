package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        double result = 0;
        try {
            if (b == 0) {
                throw new ArithmeticException();
            } else if (a == 0) {
                throw new ArithmeticException();
            }
            result = a / b;
        } catch (ArithmeticException e) {
            System.out.println("You can't divide by zero");
        } finally {
            return result;
        }
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        double result = firstChallenge.divide(1000, 50);

        System.out.println(result);
    }
}
