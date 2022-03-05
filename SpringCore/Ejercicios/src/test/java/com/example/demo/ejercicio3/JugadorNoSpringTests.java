package com.example.demo.ejercicio3;

import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JugadorNoSpringTests {
    @Test
    public void jugadorNoSpringTest() {
        log.info("Prueba no spring de construccion de jugadores");

        Evento evento = new Evento("La final");
        Torneo torneo = new Torneo("Super campeones", evento);
        Partido partido = new Partido();
        partido.setNombre("nombre");

        JugadorFutbol jugador = new JugadorFutbol();
        jugador.setNombre("oliver ato");
        jugador.setPartido(partido);
        jugador.setTorneo(torneo);

        Assert.assertEquals("Super campeones", jugador.getTorneo().getNombre());

    }
}
