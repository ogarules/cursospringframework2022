package com.example.demo.ejercicio23;

import org.aspectj.lang.JoinPoint;

public interface IAdivinidaor {
    void interceptarPensamiento(JoinPoint jp, String pensamiento);
}
