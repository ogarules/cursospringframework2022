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

    @Autowired
    private IQuadraticEquationService quadraticService;

    private double a;
    private double b;
    private double c;

    public QuadraticEquationResult solve() {
        return this.quadraticService.solve(a, b, c);
    }
}
