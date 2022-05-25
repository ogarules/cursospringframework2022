package com.example.ejercicio22;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("jugadorBean")
public class Jugador implements IJugador {
    
    @Value("oga")
    private String nombre;

    @Value("123")
    private String numero;

    public void print(String name) {
        log.info(name);
    }

    public String getDatosJugador() {
        return "[jugador] El jugador " + this.nombre + " [" + this.numero + "] "; 
    }

    @Override
    public void ejecutarPase() {
        print(getDatosJugador() + " pasa el balon");
    }

    @Override
    public void cometerFalta() {
        print(getDatosJugador() + " cometio falta");
        
    }

    @Override
    public void esExpulsado() {
        print(getDatosJugador() + " es expulsado");
        
    }

    @Override
    public void tirarAGol(boolean gol) throws Throwable {
        print(getDatosJugador() + " se prepara para tirar a gol");

        if (gol) {
            print(getDatosJugador() + " anoto un golazo");
        }
        else {
            throw new Exception(getDatosJugador() + " fallo un tiro facilicimo");
        }
        
    }

    @Override
    public void cobrarPenal(boolean gol) throws Throwable {
        print(getDatosJugador() + " se prepara para cobrar penal");

        if (gol) {
            print(getDatosJugador() + " anoto un gol");
        }
        else {
            throw new Exception(getDatosJugador() + " fallo el penal");
        }

        
    }
    
}
