package com.example.ejercicio23;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AnnotationAspectsTests {
    @Autowired
    private IVoluntario voluntario;

    @Test
    public void aspectByAnnotationsTest() {
        log.info("Testing aspects by annotations....");

        voluntario.pensarEnAlgo("Quiero una coca...");

        String pensamiento = voluntario.getPensamiento(false);

        Assert.assertEquals("Quiero una coca...", pensamiento);
    }
    
    @Test
    public void aspectByAnnotationsAroundTest() {
        log.info("Testing aspects by annotations....");

        voluntario.pensarEnAlgo("Quiero unas papas...");

        String pensamiento = voluntario.getPensamiento(true);
        
        Assert.assertEquals("Momento me quieres hacer trampa....", pensamiento);
    }
}
