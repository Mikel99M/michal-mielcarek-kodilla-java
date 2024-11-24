package com.kodilla.exception.test;

public class ThirdExcerciseRunner {
    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        Flight MyFlight = new Flight("Poznan-Lawica Airport", "Wroclaw Airport");

        try {
            System.out.println(flightFinder.findFilight(MyFlight));
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Thank you for using our service.");
        }
    }
}
