package com.example.ejercicio22;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio22/beans-aop.xml"})
public class FlowWithAspects {
    @Value("#{jugadorBean}")
    private IJugador jugador;

    @Test
    public void flowWithAspectsTest() {
        log.info("Testing flow using aspects....");

        log.info("Testing traditional flow with no aspects...");

        jugador.ejecutarPase();

        log.info("-----------");

        jugador.ejecutarPase();

        log.info("-----------");

        try{
            jugador.cobrarPenal(false);
        }
        catch (Throwable ex) {
            log.error(ex.getMessage());
        }

        log.info("-----------");

        jugador.cometerFalta();

        log.info("-----------");

        try{
            jugador.tirarAGol(false);
        }
        catch (Throwable ex) {
            log.error(ex.getMessage());
        }

        log.info("-----------");
        try{
            jugador.tirarAGol(true);
        }
        catch (Throwable ex) {
            log.error(ex.getMessage());
        }

        log.info("-----------");

        jugador.esExpulsado();
    }
}
