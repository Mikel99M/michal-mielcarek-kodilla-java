package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {

    private boolean isExecuted = false;
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;

    public ShoppingTask(String TaskName, String whatToBuy, double quantity) {
        this.taskName = TaskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        System.out.println("buying " + quantity + " of " + whatToBuy);
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
