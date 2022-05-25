package com.example.ejercicio22;

import org.aspectj.lang.ProceedingJoinPoint;

public interface IAudiencia {
    public void aplaudir();

    public void abuchear();

    public void sePonedePie();

    public void seSienta();

    public void gritaGol();

    public void gritaOle();
    
    public Object sePonedeNervios(ProceedingJoinPoint pjp) throws Throwable;
}
