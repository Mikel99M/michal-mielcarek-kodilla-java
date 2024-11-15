package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {

            // adding 1 Celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
    return resultMap;
    }

    public double calculateAverageTemperature() {
        double result = 0;
        for (double value: temperatures.getTemperatures().values()) {
            result += value;
        }
        return result / temperatures.getTemperatures().size();
    }

    public double calculateMedianTemperature() {
        List<Double> list = new LinkedList<Double>(temperatures.getTemperatures().values());
        Collections.sort(list);
        int size = list.size();
        if (size % 2 == 1) {
            return list.get(size / 2);
        } else {
            double num1 = list.get((size / 2) - 1);
            double num2 = list.get((size / 2));
            return (num1 + num2) / 2;
        }

    }


}
