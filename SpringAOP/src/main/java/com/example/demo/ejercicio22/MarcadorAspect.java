package com.example.demo.ejercicio22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("marcadorBean")
public class MarcadorAspect {
    
    @Autowired
    private Marcador marcador;

    public void contarGol() {
        log.info("Se cuanta nuevo gol anotado!!!!");
        marcador.setGoles(marcador.getGoles() + 1);
    }
}
