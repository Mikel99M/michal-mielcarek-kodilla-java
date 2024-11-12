package com.kodilla.testing.shape;

public class Square implements Shape{

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public int getField(int a, int b, int radius, int h) {
        return a * a;
    }

    @Override
    public String toString() {
        return "Square";
    }
}
