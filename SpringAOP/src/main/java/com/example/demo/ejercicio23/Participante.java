package com.example.demo.ejercicio23;

import com.example.demo.util.Color;
import com.example.demo.util.IColorWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Scope("prototype")
public class Participante implements IVoluntario {
    @Autowired
    IColorWriter colorWriter;

    private String pensamiento;

    @Override
    public void pensarEnAlgo(String pensamiento) {
        this.pensamiento = pensamiento;
        
        log.info(colorWriter.getColoredMessage(Color.MAGENTA,
                "[Participante] penso en: " + pensamiento + "... shhhh, es escreto"));
    }

    @Override
    public void pensarEnOtraCosa(String pensamiento) {
        this.pensamiento = pensamiento;
        
        log.info(colorWriter.getColoredMessage(Color.MAGENTA,
                "[Participante] penso en otra cosa: " + pensamiento + "... shhhh, es escreto"));
    }

    @Override
    public String getPensamiento(boolean hacerTrampa) {
        return hacerTrampa ? "Quiero un vaso de agua" : this.pensamiento;
    }
    
}
