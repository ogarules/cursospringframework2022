package com.example.demo.ejercicio23;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AnnotationAspects {
    
    @Autowired
    IVoluntario volunterio;

    @Test
    public void annotationAspectsTest() {
        log.info("Testing annotation aspects....");

        volunterio.pensarEnAlgo("Quiero una coca");
        String penssamiento = volunterio.getPensamiento(false);

        Assert.assertEquals("Quiero una coca", penssamiento);

        String penssamientoTrampa = volunterio.getPensamiento(true);
        Assert.assertEquals("No te has bañado en 5 dias....", penssamientoTrampa);
    }
}
