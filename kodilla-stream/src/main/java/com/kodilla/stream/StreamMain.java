package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
//        System.out.println("Welcome to module 7 - Stream");
//
//        SaySomething saySomething = new SaySomething();
//        saySomething.say();

//        Processor processor = new Processor();
//        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
//        processor.execute(executeSaySomething);

        Processor processor = new Processor();
//        Executor codeToExecute = () -> System.out.println("Hello World!");
//        processor.execute(codeToExecute);
        processor.execute(() -> System.out.println("Hello World"));


        System.out.println("Calculating expressions with lambdas");
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(20, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(20, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(20, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(20, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(20, 5, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(20, 5, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(20, 5, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(20, 5, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println(poemBeautifier.beautify("Litwo, ojczyzno moja.", (text) -> text.toUpperCase()));
        System.out.println(poemBeautifier.beautify("Litwo, ojczyzno moja.", (text) -> "ABC " + text));
        System.out.println(poemBeautifier.beautify("Litwo, ojczyzno moja.", (text) -> text.replace("o", "a").replace("y", "u")));
        System.out.println(poemBeautifier.beautify("Litwo, ojczyzno moja.", (text) -> text.replaceAll("a", "!").replaceAll("o", "!").replaceAll("y", "!")));

        //STREAM
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

//        People.getList().stream()
//                .map(s -> s.toUpperCase())
//                .forEach(System.out::println);

//        People.getList().stream()
//                .map(String::toUpperCase)
//                .forEach(s -> System.out.println(s));

        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);


        //KASKADOWE ŁĄCZENIE OPERACJI NA STREAM
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);



        // STREAM NA KOLEKCJACH Z DOWOLNYMI OBIEKTAMI
        System.out.println("\nSTREAM NA KOLEKCJACH Z DOWOLNYMI OBIEKTAMI");
        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

        // OPERACJE TERMMINALNE - KOLEKTORY
        System.out.println("OPERACJE TERMMINALNE - KOLEKTORY");
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        // KOLEKTOR COLLECTORS.toMap()
        System.out.println("KOLEKTOR COLLECTORS.toMap()");
        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        // KOLEKTOR COLLECTORS.joining()
        System.out.println("KOLEKTOR COLLECTORS.joining()");
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n", "<<", ">>"));

        System.out.println(theResultStringOfBooks);



        //  ZADANIE 7.3

        System.out.println("\n!!!!!!!!!!!!!! ZADANIE 7.3 !!!!!!!!!!\n\n\n");

        Forum forum = new Forum();
        Map<Integer, String> theZadanieList = forum.getList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getDateOfBirth().getYear() <= 2004)
                .filter(user -> user.getNumOfPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, ForumUser::getName));

        theZadanieList.entrySet().stream()
                .map(entry -> "ID - " + entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
