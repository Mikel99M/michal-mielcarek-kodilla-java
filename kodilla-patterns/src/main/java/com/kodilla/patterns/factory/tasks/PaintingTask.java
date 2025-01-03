package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {

    private boolean isExecuted = false;
    private final String taskName;
    private final String color;
    private final String whatToPaint;

    public PaintingTask(String TaskName, String color, String whatToPaint) {
        this.taskName = TaskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        System.out.println(whatToPaint + " is painted with color " + taskName);
        isExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }
}
