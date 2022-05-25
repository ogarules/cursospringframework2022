package com.example.ejercicio23;

import com.example.util.Color;
import com.example.util.IColorWriter;

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
        log.info(colorWriter.getColoredMessage(Color.MAGENTA, "[participante] pienso en "
        + pensamiento + ".... no le digas a nadie...."));
        
    }

    @Override
    public void pensarEnOtraCosa(String otroPensamiento) {
        this.pensamiento = otroPensamiento;
        log.info(colorWriter.getColoredMessage(Color.MAGENTA, "[participante] pienso en otro pensamiento "
        + pensamiento + ".... no le digas a nadie...."));
        
    }

    @Override
    public String getPensamiento(boolean hacerTrampa) {
        return hacerTrampa ? "Un vaso con agua" : this.pensamiento;
    }
    
}
