package com.example.demo.ejercicio22;

import org.aspectj.lang.ProceedingJoinPoint;

public interface IAudiencia {
    public void aplaudir();

    public void abuchear();

    public void sePondeDePie();

    public void seSienta();

    public void gritarGol();

    public void gritarOle();

    public Object ponerseDeNervios(ProceedingJoinPoint pjp) throws Throwable;
}
