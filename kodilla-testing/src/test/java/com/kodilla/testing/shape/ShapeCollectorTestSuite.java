package com.kodilla.testing.shape;
import org.junit.jupiter.api.*;

import java.util.List;

@DisplayName("TDD: Shape Collector testing")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of the test");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }


    @Nested
    @DisplayName("Testing edition of the shapeCollection")
    class TestEditing {
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            //When
            collector.addFigure(new Circle());
            //Then
            Assertions.assertEquals(1, collector.getShapes().size());
        }

        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            Circle circle = new Circle();
            collector.addFigure(circle);
            boolean result = true;
            //When
            collector.removeFigure(circle);
            if (collector.getShapes().contains(circle)) {
                result = false;
            }
            //Then
            Assertions.assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Testing getting elements")

    class TestGetting {
        @Test
        void TestGetFigure() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            Circle circle = new Circle();
            collector.addFigure(circle);
            //When
            Shape result = collector.getFigure(0);
            //Then
            Assertions.assertEquals(result, circle);
        }

        @Test
        void TestGetShapes() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            Circle circle = new Circle();
            Rectangle rectangle = new Rectangle();
            Square square = new Square();
            collector.addFigure(circle);
            collector.addFigure(rectangle);
            collector.addFigure(square);
            //When
            List<Shape> theShapes = collector.getShapes();
            //Then
            Assertions.assertEquals(3, theShapes.size());
            Assertions.assertEquals(theShapes.get(0), circle);
            Assertions.assertEquals(theShapes.get(2), square);
        }
    }
}
