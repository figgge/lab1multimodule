package org.example.consumer;

import org.example.service.Calculate;
import org.example.service.annotation.Operation;

import java.util.*;
import java.util.stream.Collectors;

public class Consumer {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Calculate> calculateMap = new HashMap<>();
    static ServiceLoader<Calculate> calculations = ServiceLoader.load(Calculate.class);

    public static void main(String[] args) {

        calculateMap = loadCalculateMap();

        menu();
    }


    private static Map<String, Calculate> loadCalculateMap() {
        return calculations.stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toMap(
                        calculation -> calculation.getClass().getAnnotation(Operation.class).value(),
                        calculation -> calculation
                ));
    }

    private static void displayMenu() {
                System.out.print("""
                Menu
                ====================
                """);
                for (var calculation : calculations) {
                    System.out.println(calculation.toString());
                }
        System.out.println("Exit\n");
        System.out.print("Choose an operator: ");
    }

    private static void menu() {
        displayMenu();

        String choice = scanner.next().toLowerCase();
        if (calculateMap.containsKey(choice)) {
            if(choice.equals("exit")) {
                System.out.println("Avslutar...");
                System.exit(0);
            } else {
                calculateMap.get(choice).printResult(getDouble(),getDouble());
            }
        } else {
            System.out.println("Invalid operation");
        }

        menu();
    }

    private static double getDouble() {
        System.out.print("Enter a number: ");
        while   (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }


}
