package com.kodilla.patterns.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Case: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Case: end");
    }

    @DisplayName("when we input empty list then oddNumbersExterminator should give us back an empty list")

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        oddNumbersExterminator exterminator = new oddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();
        //When
        List result = exterminator.exterminate(emptyList);
        //Then
        Assertions.assertTrue(result.isEmpty());

    }

    @DisplayName("when we input the integer list it should give us back list containing only even numbers")

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        oddNumbersExterminator exterminator = new oddNumbersExterminator();
        List<Integer> normalList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 4, 5, 6, 6, 6, 6, 7, 8, 9, 12, 13));
        //When
        List result = exterminator.exterminate(normalList);
        //Then
        List<Integer> testArrayList = new ArrayList<>();
        for (int number : normalList) {
            if (number % 2 == 0) {
                testArrayList.add(number);
            }
        }
        Assertions.assertArrayEquals(testArrayList.toArray(), result.toArray());
    }
}
