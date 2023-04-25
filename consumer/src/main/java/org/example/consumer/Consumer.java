package org.example.consumer;

import org.example.service.Calculate;

import java.util.ServiceLoader;

public class Consumer {

    public static void main(String[] args) {

        Calculate calculate;

//        System.out.println(calculate.calculate(1, 2));
        ServiceLoader<Calculate> calculations = ServiceLoader.load(Calculate.class);

        for (var calculation : calculations) {
            System.out.println(calculation.calculate(5, 2));
        }
    }
}
