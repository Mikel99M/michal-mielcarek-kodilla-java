package com.kodilla.patterns.testing.shape;

public class Triangle implements Shape{

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public int getField(int a, int b, int radius, int h) {
        return (int) (Math.round(0.5 * a * h));
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}
