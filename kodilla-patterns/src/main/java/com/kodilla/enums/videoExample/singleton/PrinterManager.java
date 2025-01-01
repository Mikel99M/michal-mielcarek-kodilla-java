package com.kodilla.enums.videoExample.singleton;

enum PrinterManager {
    INSTANCE;

    public void print() {
        System.out.println("test");
    }
}
