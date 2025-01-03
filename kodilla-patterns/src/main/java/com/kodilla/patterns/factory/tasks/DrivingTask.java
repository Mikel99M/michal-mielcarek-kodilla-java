package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {

    private boolean isExecuted = false;
    private final String taskName;
    private final String where;
    private final String using;

    public DrivingTask(String TaskName, String where, String using) {
        this.taskName = TaskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        System.out.println("driwing in " + using + " to " + where);
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
