package com.example.demo.ejercicio3;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JugadorTests {
    
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        String path = "spring/ejercicio3/beans.xml";
        context = new ClassPathXmlApplicationContext(path);
    }

    @Test
    public void jugadorTraditionTest() {
        log.info("Traditional test instance...");

        Partido partido = new Partido();
        partido.setNombre("newpi vs furama");
        Evento evento = new Evento("La gran final");
        Torneo torneo = new Torneo("Super campeones", evento);
        JugadorFutbol jugadorFutbol = new JugadorFutbol();
        jugadorFutbol.setNombre("Oliver ato");
        jugadorFutbol.setPartido(partido);
        jugadorFutbol.setTorneo(torneo);

        Assert.assertEquals("Super campeones", jugadorFutbol.getTorneo().getNombre());
    }

    @Test 
    public void jugadorSpringTest() {
        log.info("sprong jugador beans....");

        IJugador jugador = (IJugador) context.getBean("jugadorBean");

        Assert.assertNotNull(jugador);
        Assert.assertEquals("Oliver ato", jugador.getNombre());
        Assert.assertEquals("newpi vs furama", jugador.getPartido().getNombre());
    }

    @Test 
    public void jugadorSpringTennisTest() {
        log.info("sprong jugador beans....");

        IJugador jugador = (IJugador) context.getBean("jugadorTennisBean");

        Assert.assertNotNull(jugador);
        Assert.assertEquals("Tennis Oliver ato", jugador.getNombre());
        Assert.assertEquals("newpi vs furama", jugador.getPartido().getNombre());
    }

    @Test 
    public void jugadorSpringAmericanoTest() {
        log.info("sprong jugador beans....");

        IJugador jugador = (IJugador) context.getBean("jugadorAmericanoBean");

        Assert.assertNotNull(jugador);
        Assert.assertEquals("Americano Oliver ato", jugador.getNombre());
        Assert.assertEquals("newpi vs furama", jugador.getPartido().getNombre());
    }
}
