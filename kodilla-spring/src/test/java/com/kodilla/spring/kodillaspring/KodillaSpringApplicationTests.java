package com.kodilla.spring.kodillaspring;

import com.kodilla.spring.kodillaspring.forum.ForumUser;
import com.kodilla.spring.kodillaspring.shape.Shape;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KodillaSpringApplicationTests {

    @Test
    void testCircleLoadedIntoContainer() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape)context.getBean("circle");

        //When
        String name = shape.getShapeName();

        //Then
        assertEquals("This is a circle.", name);
    }

    @Test
    void testTriangleLoadedIntoContainer() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape)context.getBean("triangle");

        //When
        String name = shape.getShapeName();

        //Then
        assertEquals("This is a triangle.", name);
    }

    @Test
    void testSquareLoadedIntoContainer() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape)context.getBean("createSquare");
        //When
        String name = shape.getShapeName();
        //Then
        assertEquals("This is a square.", name);
    }

    @Test
    void testShapeLoadedIntoContainer() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape)context.getBean("chosenShape");

        //When
        String name = shape.getShapeName();

        //Then
        System.out.println("Chosen shape says: " + name);
    }

    @Test
    void testGetUserName() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        ForumUser forumUser = (ForumUser)context.getBean("forumUser");

        //When
        String result = forumUser.getUserName();

        //Then
        assertEquals("John Smith", result);
    }

    @Test
    void contextLoads() {
    }

}