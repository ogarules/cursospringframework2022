package com.example.demo.ejercicio22;

import org.aspectj.lang.annotation.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio22/beans.xml"})
public class TraditionalFlowTests {

    @Value("#{jugadorBean}")
    IJugador jugador;

    @Value("#{audienciaBean}")
    IAudiencia audiencia;
    
    @Test
    public void TraditionalFlowTest() {
        log.info("Testing traditional flow....");
        
        audiencia.gritarOle();
        jugador.ejecutarPase();
        audiencia.gritarOle();

        log.info("-----------");

        audiencia.gritarOle();
        jugador.ejecutarPase();
        audiencia.gritarOle();

        log.info("-----------");

        audiencia.sePondeDePie();
        try {
            jugador.cobrarPenal(false);
            audiencia.gritarGol();
        }
        catch (Throwable ex) {
            log.info(ex.getMessage());
            audiencia.abuchear();
            audiencia.abuchear();
        }
        audiencia.seSienta();

        log.info("-----------");

        jugador.cometerFalta();
        audiencia.abuchear();

        log.info("-----------");

        try {
            jugador.tirarAGol(false);
            audiencia.gritarGol();
            audiencia.gritarGol();
            audiencia.aplaudir();
            audiencia.aplaudir();
        }
        catch (Throwable ex) {
            log.info(ex.getMessage());
        }

        log.info("-----------");

        jugador.esExpulsado();
        audiencia.abuchear();
        audiencia.abuchear();
        audiencia.aplaudir();
        audiencia.aplaudir();
    }
}
