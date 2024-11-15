package com.kodilla.testing.weather.mock;

import java.util.*;
import com.kodilla.testing.weather.stub.Temperatures;                         // [2]
import com.kodilla.testing.weather.stub.WeatherForecast;                      // [3]
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    Map<String, Double> temperaturesMap = new HashMap<>();
    @BeforeEach
    void setUp() {
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 32.0);
        temperaturesMap.put("Warszawa", 29.0);
        temperaturesMap.put("Poznan", 28.0);
        temperaturesMap.put("Wroclaw", 27.0);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    }

    @Mock
    private Temperatures temperaturesMock;

    @DisplayName("Getting the tempetures data")
    @Test
    void testCalculateForecastWithMock() {
        //Given
//        Temperatures temperaturesMock = mock(Temperatures.class);

        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);

    }

    @DisplayName("Calculating the average of temps")
    @Test
    void testCalculateAverage() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double result = weatherForecast.calculateAverageTemperature();

        //Then
        Assertions.assertEquals(28.3, result);
    }

    @DisplayName("Calculating the median of temps")
    @Test
    void testCalculateMedian() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double result = weatherForecast.calculateMedianTemperature();

        //Then
        Assertions.assertEquals(28.0, result);


    }

}
