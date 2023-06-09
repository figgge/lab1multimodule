package org.example.provider;

import org.example.service.Calculate;
import org.example.service.annotation.Operation;

@Operation("add")
public class Add implements Calculate {

    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}
