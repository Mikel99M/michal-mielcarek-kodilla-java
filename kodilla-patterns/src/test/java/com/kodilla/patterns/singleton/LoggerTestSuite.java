package com.kodilla.patterns.singleton;

import com.kodilla.singleton.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        Logger logger = Logger.INSTANCE;
        String text = "hello";

        //When
        logger.log(text);
        String result = logger.getLastLog();

        //Then
        assertEquals(result, text);
    }
}
