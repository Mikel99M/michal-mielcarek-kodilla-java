package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    public void setUp() {
        //Given
        user1 = new YGeneration("Sam Kowalski");
        user2 = new Millenials("Adam Sandlerowski");
        user3 = new ZGeneration("Leon Dikaprio");

        //When
        user1.sharePost();
        user2.sharePost();
        user3.sharePost();
    }

    @Test
    public void testDefaultSharingStrategies() {
        //Then
        assertEquals("Facebook", user1.predict());
        assertEquals("Twitter", user2.predict());
        assertEquals("Snapchat", user3.predict());
    }

    @Test
    public void testIndividualSharingStrategy() {
        //When
        user1.setSocialPublisher(new SnapchatPublisher());

        //Then
        assertEquals("Snapchat", user1.predict());
        assertEquals("Twitter", user2.predict());
        assertEquals("Snapchat", user3.predict());
        assertEquals(user1.predict(), user3.predict());
    }

}
