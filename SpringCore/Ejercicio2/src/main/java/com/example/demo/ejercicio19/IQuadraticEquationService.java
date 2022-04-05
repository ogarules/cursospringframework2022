package com.example.demo.ejercicio19;

public interface IQuadraticEquationService {
    QuadraticEquationResult solve(double a, double b, double c);

    default String quadraticEquationToString(double a, double b, double c) {
        StringBuilder builder = new StringBuilder();

        builder.append(a).append("x^2");
        builder.append(b > 0 ? " + " : " - ");
        builder.append(b < 0 ? -1 * b : b);
        builder.append(c > 0 ? " + " : " - ");
        builder.append(" = 0");

        return builder.toString();
    }
}
