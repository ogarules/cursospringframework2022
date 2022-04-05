package com.example.demo.ejercicio22;

import com.example.demo.util.Color;
import com.example.demo.util.IColorWriter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("audienciaBean")
public class Audiencia implements IAudiencia {
    @Autowired
    private IColorWriter colorWriter;

    public void print(String name) {
        log.info(name);
    }

    public String getInfo() {
        return "[Audiencia] La audiencia ";
    }

    @Override
    public void aplaudir() {
        print(colorWriter.getColoredMessage(Color.BLUE, getInfo() + "aplaude CLAP CLaP !!!"));        
    }

    @Override
    public void abuchear() {
        print(colorWriter.getColoredMessage(Color.RED, getInfo() + "abuchea BUUUUU !!!"));        
    }

    @Override
    public void sePondeDePie() {
        print(colorWriter.getColoredMessage(Color.YELLOW, getInfo() + "se pone de pie !!!"));

    }

    @Override
    public void seSienta() {
        print(colorWriter.getColoredMessage(Color.YELLOW, getInfo() + "se sienta !!!"));
        
    }

    @Override
    public void gritarGol() {
        print(colorWriter.getColoredMessage(Color.GREEN, getInfo() + "GOOOOOOL !!!"));
        
    }

    @Override
    public void gritarOle() {
        print(colorWriter.getColoredMessage(Color.MAGENTA, getInfo() + "OOOOLEEEEEE !!!"));        
    }

    @Override
    public Object ponerseDeNervios(ProceedingJoinPoint pjp) throws Throwable {
        print(colorWriter.getColoredMessage(Color.YELLOW, getInfo() + "se pone de nervios !!!"));
        
        Object result = pjp.proceed();

        this.abuchear();
        this.abuchear();
        this.aplaudir();
        this.aplaudir();

        print(colorWriter.getColoredMessage(Color.YELLOW, getInfo() + "se dejo de poner de nervios !!!"));
       
        return result;
    }
    
}
