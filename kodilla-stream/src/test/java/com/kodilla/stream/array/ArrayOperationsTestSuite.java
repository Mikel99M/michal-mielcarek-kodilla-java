package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        Operation operation = new Operation();
        int[] numbers = new int[]{1, 2, 2, 4, 15, 26, 72, 18, 9, 10, 2, 1, 1, 2, 3, 12, 6, 7, 98, 23};
        double expectedResult = Arrays.stream(numbers).asDoubleStream()
                .average().orElse(0);
        //When
        double result = operation.getAverage(numbers);
        //Then
        assertEquals(expectedResult, result, 0.0);
    }


}
