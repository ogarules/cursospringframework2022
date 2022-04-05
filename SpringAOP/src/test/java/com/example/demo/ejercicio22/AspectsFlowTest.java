package com.example.demo.ejercicio22;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio22/beans-aop.xml"})
public class AspectsFlowTest {
    @Value("#{jugadorBean}")
    IJugador jugador;

    @Autowired
    private Marcador marcador;

    @Test
    public void flowWithAspectsTest() {
        log.info("Testing aspects....");

        log.info("Testing traditional flow....");
        
        jugador.ejecutarPase();

        log.info("-----------");

        jugador.ejecutarPase();

        log.info("-----------");

        try {
            jugador.cobrarPenal(false);
        }
        catch (Throwable ex) {
            log.info(ex.getMessage());
        }

        try {
            jugador.cobrarPenal(true);
        }
        catch (Throwable ex) {
            log.info(ex.getMessage());
        }

        log.info("-----------");

        jugador.cometerFalta();

        log.info("-----------");

        try {
            jugador.tirarAGol(false);
        }
        catch (Throwable ex) {
            log.info(ex.getMessage());
        }

        log.info("-----------");

        jugador.esExpulsado();

        Assert.assertEquals(new Integer(1), marcador.getGoles());
    }
}
