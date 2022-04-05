package com.example.demo.ejercicio22;

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

    public String getInfo() {
        return "[jugador] El jugador " + this.nombre + " [numero: " + this.numero + "] ";
    }

    @Override
    public void ejecutarPase() {
        print(getInfo() + " pasa el balon");        
    }

    @Override
    public void cometerFalta() {
        print(getInfo() + " comete falta");
        
    }

    @Override
    public void esExpulsado() {
        print(getInfo() + " es expulsado");        
    }

    @Override
    public void tirarAGol(boolean gol) throws Throwable {
        print(getInfo() + " se prepara para tirar a gol");

        if (gol) {
            print(getInfo() + " anoto golazo");
        }
        else {
            throw new Exception(getInfo() + " la rego y fallo...");
        }
        
    }

    @Override
    public void cobrarPenal(boolean gol) throws Throwable {
        print(getInfo() + " se prepara para cobrar penal");

        if (gol) {
            print(getInfo() + " anoto penal");
        }
        else {
            throw new Exception(getInfo() + " la rego y fallo el penal...");
        }
    }
    
}
