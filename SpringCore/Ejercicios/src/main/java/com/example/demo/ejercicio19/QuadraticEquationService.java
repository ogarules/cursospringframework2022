package com.example.demo.ejercicio19;

import java.text.DecimalFormat;

import org.apache.commons.math3.complex.Complex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuadraticEquationService implements IQuadraticEquationService {
    
    private DecimalFormat decimalFormater = new DecimalFormat("###,###,##0.00##");

    @Override
    public QuadraticEquationResult solve(double a, double b, double c) {
        double minusB = -1 * b;
        double BQuadraticMinusFourAC = Math.pow(b, 2) - (4 * a * c);
        double twoA = 2 * a;

        double sqrtOperation = 0;

        if (BQuadraticMinusFourAC > 0) {
            sqrtOperation = Math.sqrt(BQuadraticMinusFourAC);

            return QuadraticEquationResult.builder()
                    .x1(new Complex(Double.valueOf(decimalFormater
                            .format((minusB + sqrtOperation) / twoA))))
                    .x2(new Complex(Double.valueOf(decimalFormater
                            .format((minusB - sqrtOperation) / twoA))))
                    .build();

        } else {
            sqrtOperation = Math.sqrt(-1 * BQuadraticMinusFourAC);

            return QuadraticEquationResult.builder().x1(new Complex(
                    Double.valueOf(decimalFormater.format(minusB / twoA)),
                    Double.valueOf(
                            decimalFormater.format(sqrtOperation / twoA))))
                    .x2(new Complex(
                            Double.valueOf(
                                    decimalFormater.format(minusB / twoA)),
                            Double.valueOf(decimalFormater
                                    .format(-sqrtOperation / twoA))))
                    .build();
        }
    }
    
    public void init() {
        log.info("Initializong quadratic solver...");
    }

    public void destroy() {
        log.info("Destroying quadratic solver...");
    }
}
