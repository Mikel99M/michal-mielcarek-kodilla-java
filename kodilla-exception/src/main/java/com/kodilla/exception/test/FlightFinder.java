package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public boolean findFilight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Heathrow Airport", false);
        airports.put("Charles de Gaulle Airport", false);
        airports.put("Madrid Airport", true);
        airports.put("Munich Airport", false);
        airports.put("Warsaw Chopin Airport", true);
        airports.put("Poznan-Lawica Airport", true);

        String airport = flight.getArrivalAirport();

        if (airports.containsKey(airport)) {
            return airports.get(airport);
        } else {
            throw new RouteNotFoundException("No such airport as \"" + airport + "\" found");
        }
    }
}
