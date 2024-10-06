package org.example.provider;

import org.example.service.Calculate;
import org.example.service.annotation.Operation;

@Operation("subtract")
public class Subtract implements Calculate {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }

    @Override
    public void printResult(double a, double b) {
        double result = calculate(a,b);
        System.out.println(a + " - " + b + " = " + result);
    }

    @Override
    public String toString() {
        return "Subtract";
    }
}
