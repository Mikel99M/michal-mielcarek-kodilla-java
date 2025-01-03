package com.kodilla.patterns.enums.videoExample.singleton;

public class Application {
    public static void main(String[] args) {
        PrinterManager printerManager1 = PrinterManager.INSTANCE;
        PrinterManager printerManager2 = PrinterManager.INSTANCE;
        System.out.println(printerManager1 == printerManager2);
        printerManager1.print();
        printerManager2.print();
    }
}
