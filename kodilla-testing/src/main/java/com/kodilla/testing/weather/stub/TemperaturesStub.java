package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;

public class TemperaturesStub implements Temperatures {

    @Override
    public Map<String, Double> getTemperatures() {
        Map<String, Double> stubResult = new HashMap<>();

        // dummy data
        stubResult.put("Rzeszow", 25.5);
        stubResult.put("Krakow", 32.0);
        stubResult.put("Warszawa", 29.0);
        stubResult.put("Poznan", 28.0);
        stubResult.put("Wroclaw", 27.0);

        return stubResult;
    }
}
