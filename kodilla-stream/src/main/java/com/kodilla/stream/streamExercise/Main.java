package com.kodilla.stream.streamExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java Programming", "Adam Smith", 1990));
        books.add(new Book("Java asd", "John Smith", 2000));
        books.add(new Book("10920", "Jan kowalski", 1998));
        books.add(new Book("Javajs9723a", "Kamila łopatka", 2022));
        books.add(new Book("asioh121", "asjduc", 2015));

        List<Book> result = books.stream()
                .filter(b -> b.getYear() > 2010)
                .map(b -> new Book(b.getAuthor().toUpperCase(), b.getTitle(), b.getYear()))
                .collect(Collectors.toList());

        System.out.println(result);

        String x = "5";
        System.out.println(Integer.parseInt(x));

    }
}
