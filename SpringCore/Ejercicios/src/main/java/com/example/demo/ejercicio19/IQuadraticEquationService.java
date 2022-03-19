package com.example.demo.ejercicio19;

public interface IQuadraticEquationService {
    
    QuadraticEquationResult solve(double a, double b, double c);

    default String quadraticEquationToString(double a, double b, double c) {
        StringBuilder sb = new StringBuilder();

        sb.append(a).append("x^2");
        sb.append(b > 0 ? " + " : " - ");
        sb.append(b < 0 ? -1 * b : b);
        sb.append(c > 0 ? " + " : " - ");
        sb.append(" = 0");

        return sb.toString();
    }
}
