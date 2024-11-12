package com.kodilla.testing.shape;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ShapeCollector collector = new ShapeCollector();
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        collector.addFigure(circle);
        collector.addFigure(rectangle);

        System.out.println(collector.showFigures());
        System.out.println(collector.getShapes());
    }
}
