package com.example.demo.ejercicio3;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JugadorSpringTests {
    private static ApplicationContext applicationContext;

    @BeforeClass
    public static void beforeClass() {
        String path = "spring/ejercicio3/beans.xml";
        applicationContext = new ClassPathXmlApplicationContext(path);
    }

    @Test
    public void testInterfaceInyectionTest() {
        IJugador jugador = (IJugador) applicationContext.getBean("jugadorBean");

        Assert.assertNotNull(jugador);
        Assert.assertEquals("Oliver ato", jugador.getNombre());
        Assert.assertEquals("La gran final", jugador.getTorneo().getNombre());
        Assert.assertEquals("newpi vs furama", jugador.getPartido().getNombre());
        Assert.assertEquals("Super campeones", jugador.getTorneo().getEvento().getNombre());

        jugador = (IJugador) applicationContext.getBean("jugadorTennisBean");
        Assert.assertEquals("Tennis Oliver ato", jugador.getNombre());

        jugador = (IJugador) applicationContext.getBean("jugadorAmaericanoBean");
        Assert.assertEquals("Americano Oliver ato", jugador.getNombre());
    }

    @Test
    public void getPartidoBeanTest() {
        Partido partidoBean = (Partido) applicationContext.getBean("partidoBean");

        Assert.assertNotNull(partidoBean);
        Assert.assertEquals("newpi vs furama", partidoBean.getNombre());
    }

    @Test
    public void getEventoBeanTest() {
        Evento eventoBean = (Evento) applicationContext.getBean("eventoBean");

        Assert.assertNotNull(eventoBean);
        Assert.assertEquals("Super campeones", eventoBean.getNombre());

    }
    
    @Test
    public void getTorneoBeanTest() {
        Torneo torneoBean = (Torneo) applicationContext.getBean("torneoBean");

        Assert.assertNotNull(torneoBean);
        Assert.assertEquals("La gran final", torneoBean.getNombre());
        Assert.assertEquals("Super campeones", torneoBean.getEvento().getNombre());
    }

}
