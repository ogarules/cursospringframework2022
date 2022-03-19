package com.example.demo.ejercicio19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class QuadraticEquation {
    public enum QuadraticEquationValue {
        Ax2, Bx, C
    }

    private double a;
    private double b;
    private double c;

    @Autowired
    private IQuadraticEquationService quadraticService;

    public QuadraticEquationResult solve() {
        return this.quadraticService.solve(a, b, c);
    }
}
