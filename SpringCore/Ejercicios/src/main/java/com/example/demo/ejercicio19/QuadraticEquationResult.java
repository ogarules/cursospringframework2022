package com.example.demo.ejercicio19;

import org.apache.commons.math3.complex.Complex;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuadraticEquationResult {
    private Complex x1;
    private Complex x2;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x1 = ")
          .append(x1)
          .append("x2 = ")
                .append(x2);
        
        return sb.toString();
    }
}
