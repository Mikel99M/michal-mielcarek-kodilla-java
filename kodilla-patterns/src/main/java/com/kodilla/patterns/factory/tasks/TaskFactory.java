package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String SHOPING = "SHOPING";
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";

    public final Task makeTask(final String taskClass) {
        return switch (taskClass) {
            case SHOPING -> new ShoppingTask("Zakupy w biedrze", "farba szara", 5);
            case DRIVING -> new DrivingTask("Jazda na zakupy", "biedra", "renault clio");
            case PAINTING -> new PaintingTask("Malowanie domu", "grey", "wall");
            default -> null;
        };
    }
}
