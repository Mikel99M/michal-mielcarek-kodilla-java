package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmac() {
        //Given
        Bigmac myBigmac = new Bigmac.BigmacBuilder()
                .bun("brioche")
                .burgers(2)
                .sauce("mayo")
                .ingredient("bacon")
                .ingredient("onion")
                .build();
        System.out.println(myBigmac);

        //When
        String theBun = myBigmac.getBun();
        String theSauce = myBigmac.getSauce();
        int numOfPatties = myBigmac.getBurgers();
        List<String> theIngredients = myBigmac.getIngredients();

        //Then
        assertEquals("brioche", theBun);
        assertNotEquals("z sezamkiem", theBun);

        assertEquals("mayo", theSauce);

        assertEquals(numOfPatties, theIngredients.size());
        assertEquals(2, numOfPatties);

        assertTrue(theIngredients.contains("bacon"));
        assertFalse(theIngredients.contains("buraki"));
    }
}
