package org.example.consumer;

import org.example.service.Calculate;
import org.example.service.annotation.Operation;

import java.util.*;
import java.util.stream.Collectors;

public class Consumer {
    static Scanner scanner = new Scanner(System.in);
    static ServiceLoader<Calculate> calculations = ServiceLoader.load(Calculate.class);

    public static void main(String[] args) {

        menu();

    }

    private static Set<Calculate> getCalculations(String operation) {
        return calculations.stream()
                .filter(c -> c.type().isAnnotationPresent(Operation.class)
                        && c.type().getAnnotation(Operation.class).value().equals(operation))
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toSet());
    }

    private static void displayMenu() {
        System.out.print("""
                Menu
                ====================
                1. Add
                2. Subtract
                3. Multiply
                4. Divide
                5. Exit
                                        
                Choose an operation:
                """);
    }

    private static void menu() {
        displayMenu();

        switch (scanner.next()) {
            case "1", "add", "+" -> add(getDouble(), getDouble());
            case "2", "subtract", "-" -> subtract(getDouble(), getDouble());
            case "3", "multiply", "*" -> multiply(getDouble(), getDouble());
            case "4", "divide", "/" -> divide(getDouble(), getDouble());
            case "5", "exit" -> System.exit(0);
            default -> System.out.println("Invalid operation");
        }
        System.out.println();
        menu();
    }


    private static void add(double a, double b) {
        var additions = getCalculations("add");
        for (var calculation : additions) {
            System.out.println(a + " + " + b + " = " + calculation.calculate(a, b));
        }
    }

    private static void subtract(double a, double b) {
        var subtractions = getCalculations("subtract");
        for (var calculation : subtractions) {
            System.out.println(a + " - " + b + " = " + calculation.calculate(a, b));
        }

    }

    private static void multiply(double a, double b) {
        var multiplications = getCalculations("multiply");
        for (var calculation : multiplications) {
            System.out.println(a + " * " + b + " = " + calculation.calculate(a, b));
        }

    }

    private static void divide(double a, double b) {
        var divisions = getCalculations("divide");
        for (var calculation : divisions) {
            System.out.println(a + " / " + b + " = " + calculation.calculate(a, b));
        }
    }

    private static double getDouble() {
        System.out.print("Enter a number: ");
        return scanner.nextDouble();
    }


}
