package com.example.ejercicio23;

import org.aspectj.lang.JoinPoint;

public interface IAdivinador {
    void interceptarPensamiento(JoinPoint jp, String pensamiento);
}
