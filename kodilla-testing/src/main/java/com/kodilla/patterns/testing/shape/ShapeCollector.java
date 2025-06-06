package com.kodilla.patterns.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        return shapes.get(n);
    }

    public String showFigures() {
        List<String> list = new ArrayList<>();
        for (Shape shape : shapes) {
            list.add(shape.toString());
        }
        return String.join(", ", list);
    }

    public List getShapes() {
        return shapes;
    }
}
