package com.kodilla.spring.kodillaspring.library;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


public final class Library {

    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    public Library(final LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }


    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}