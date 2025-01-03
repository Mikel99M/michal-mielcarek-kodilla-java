package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    TaskFactory factory;

    @BeforeEach
    void setUp() {
        //Given
        factory = new TaskFactory();
    }

    @Test
    void testFactoryDriving() {
        //When
        Task shopping = factory.makeTask(TaskFactory.SHOPING);

        //Then
        assertEquals("Zakupy w biedrze", shopping.getTaskName());

        assertFalse(shopping.isTaskExecuted());
        shopping.executeTask();
        assertTrue(shopping.isTaskExecuted());
    }

    @Test
    void testFactoryShopping() {
        //When
        Task driving = factory.makeTask(TaskFactory.DRIVING);

        //Then
        assertEquals("Jazda na zakupy", driving.getTaskName());

        assertFalse(driving.isTaskExecuted());
        driving.executeTask();
        assertTrue(driving.isTaskExecuted());
    }

    @Test
    void testFactoryPainting() {
        //When
        Task painting = factory.makeTask(TaskFactory.PAINTING);

        //Then
        assertEquals("Malowanie domu", painting.getTaskName());

        assertFalse(painting.isTaskExecuted());
        painting.executeTask();
        assertTrue(painting.isTaskExecuted());
    }
}
