package com.example.demo.ejercicio3;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class JugadorAmericano implements IJugador {
    private String nombre;
    private Torneo torneo;
    private Partido partido;

    @Override
    public void saludar() {
        log.info("Saluds amantes del Americano");
        
    }
}
