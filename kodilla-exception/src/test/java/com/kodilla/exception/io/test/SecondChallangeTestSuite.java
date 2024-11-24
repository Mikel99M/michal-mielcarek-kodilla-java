package com.kodilla.exception.io.test;

import com.kodilla.exception.test.SecondChallange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SecondChallangeTestSuite {

    SecondChallange secondChallange = new SecondChallange();

    boolean result = true;


    @Nested
    @DisplayName("Testing ProbablyIWillThrowException")
    class test {
        @Test
        void testNoException() {
            String otherResult = "";
            //When
//            boolean result = true;
            try {
                otherResult = secondChallange.probablyIWillThrowException(1, 3);
            } catch (Exception e) {
                result = false;
            }
            //then
            assertTrue(result);
            assertEquals("Done!", otherResult);
        }

        @Test
        void testWrongX() {
            //when
            try {
                secondChallange.probablyIWillThrowException(5, 3);
            } catch (Exception e) {
                result = false;
            }
            //then
            assertFalse(result);
        }

        @Test
        void testWrongY() {
            try {
                secondChallange.probablyIWillThrowException(2, 1.5);
            } catch (Exception e) {
                result = false;
            }
            assertFalse(result);
        }

        @Test
        void testWrongBothXandY() {
            try {
                secondChallange.probablyIWillThrowException(26, 1.5);
            } catch (Exception e) {
                result = false;
            }

            assertFalse(result);
        }
    }
}
