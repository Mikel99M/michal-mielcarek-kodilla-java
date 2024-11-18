package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        World world = new World();
        BigDecimal expectedPopulation = new BigDecimal("150000000");
        //When
        BigDecimal result = world.getPeopleQuantity();
        //Then
        assertEquals(expectedPopulation, result);
    }
}
