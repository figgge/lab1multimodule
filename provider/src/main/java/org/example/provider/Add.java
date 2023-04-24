package org.example.provider;

import org.example.service.Calculate;

public class Add implements Calculate {

    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}
