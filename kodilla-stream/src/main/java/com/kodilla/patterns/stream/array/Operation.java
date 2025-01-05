package com.kodilla.patterns.stream.array;


import java.util.stream.IntStream;

public final class Operation implements ArrayOperations{

    @Override
    public double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .forEach(System.out::println);

        return IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .average().getAsDouble();
    }
}
