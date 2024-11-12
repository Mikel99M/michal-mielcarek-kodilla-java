package com.kodilla.testing.shape;

public class Rectangle implements Shape {

    @Override
    public String getShapeName() {
        return "Rectangle";
    }

    @Override
    public int getField(int a, int b, int radius, int h) {
        return a * b;
    }

    @Override
    public String toString() {
        return "Rectangle";
    }
}
