package com.example.ejercicio22;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio22/beans.xml"})
public class FlowNoAspects {
    
    @Value("#{jugadorBean}")
    private IJugador jugador;

    @Value("#{audienciaBean}")
    private IAudiencia audiencia;

    @Test
    public void traditionalFlowTest(){
        log.info("Testing traditional flow with no aspects...");

        audiencia.gritaOle();
        jugador.ejecutarPase();
        audiencia.gritaOle();

        log.info("-----------");

        audiencia.gritaOle();
        jugador.ejecutarPase();
        audiencia.gritaOle();

        log.info("-----------");

        audiencia.sePonedePie();
        try{
            jugador.cobrarPenal(false);
            audiencia.gritaGol();
        }
        catch (Throwable ex) {
            log.error(ex.getMessage());
            audiencia.abuchear();
            audiencia.abuchear();
        }

        audiencia.seSienta();

        log.info("-----------");

        jugador.cometerFalta();
        audiencia.abuchear();

        log.info("-----------");

        try{
            jugador.tirarAGol(false);
            audiencia.gritaGol();
            audiencia.gritaGol();
            audiencia.aplaudir();
            audiencia.aplaudir();
        }
        catch (Throwable ex) {
            log.error(ex.getMessage());
        }

        log.info("-----------");
        try{
            jugador.tirarAGol(true);
            audiencia.gritaGol();
            audiencia.gritaGol();
            audiencia.aplaudir();
            audiencia.aplaudir();
        }
        catch (Throwable ex) {
            log.error(ex.getMessage());
        }

        log.info("-----------");

        jugador.esExpulsado();
        audiencia.abuchear();
        audiencia.abuchear();
        audiencia.aplaudir();
        audiencia.aplaudir();
    }
}
