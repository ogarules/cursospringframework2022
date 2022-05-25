package com.example.ejercicio22;

import com.example.util.Color;
import com.example.util.IColorWriter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("audienciaBean")
public class Audiencia implements IAudiencia {
    
    @Autowired
    private IColorWriter colorWriter;

    @Override
    public void aplaudir() {
        print(colorWriter.getColoredMessage(Color.BLUE, getDatosAudiencia() + " aplaude CLAP CLAP!!!"));

    }

    public void print(String name) {
        log.info(name);
    }

    public String getDatosAudiencia() {
        return "[audiencia] La audiencia "; 
    }

    @Override
    public void abuchear() {
        print(colorWriter.getColoredMessage(Color.RED, getDatosAudiencia() + " abuchea BUUUUU!!!"));
        
    }

    @Override
    public void sePonedePie() {
        print(colorWriter.getColoredMessage(Color.YELLOW, getDatosAudiencia() + " se pone de pie!!!"));        
    }

    @Override
    public void seSienta() {
        print(colorWriter.getColoredMessage(Color.YELLOW, getDatosAudiencia() + " se sienta!!!"));                
    }

    @Override
    public void gritaGol() {
        print(colorWriter.getColoredMessage(Color.GREEN, getDatosAudiencia() + " grita GOOOOOOL!!!"));        
        
    }

    @Override
    public void gritaOle() {
        print(colorWriter.getColoredMessage(Color.MAGENTA, getDatosAudiencia() + " grit OLEEEEEE!!!"));        
        
    }

    @Override
    public Object sePonedeNervios(ProceedingJoinPoint pjp) throws Throwable {
        print(colorWriter.getColoredMessage(Color.YELLOW, getDatosAudiencia() + " se pone de nervios!!!"));
        
        Object result = pjp.proceed();

        this.abuchear();
        this.abuchear();
        this.aplaudir();
        this.aplaudir();

        print(colorWriter.getColoredMessage(Color.GREEN, getDatosAudiencia() + " se dejo de poner de nervios!!!"));

        return result;
    }
    
}
