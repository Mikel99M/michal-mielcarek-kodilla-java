package com.kodilla.patterns.enums.videoExample.singleton;

enum PrinterManager {
    INSTANCE;

    public void print() {
        System.out.println("test");
    }
}
