package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

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

    }
}
