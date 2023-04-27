package org.example.provider;

import org.example.service.Calculate;
import org.example.service.annotation.Operation;

@Operation("multiply")
public class Multiply implements Calculate {

    public double calculate(double a, double b) {
        return a * b;
    }
}
