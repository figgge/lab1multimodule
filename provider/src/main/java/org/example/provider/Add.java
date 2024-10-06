package org.example.provider;

import org.example.service.Calculate;
import org.example.service.annotation.Operation;

@Operation("add")
public class Add implements Calculate {

    @Override
    public String toString() {
        return "Add";
    }

    @Override
    public double calculate(double a, double b) {
        return a + b;
    }

    @Override
    public void printResult(double a, double b) {
        double result = calculate(a,b);
        System.out.println(a + " + " + b + " = " + result);
    }
}
