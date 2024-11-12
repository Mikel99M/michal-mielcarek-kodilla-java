package com.kodilla.testing.shape;

public class Circle implements Shape {

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public int getField(int a, int b, int radius, int h) {
        return (int) Math.round(Math.PI * radius * radius);
    }

    @Override
    public String toString() {
        return "Circle";
    }
}
