package com.example.demo.ejercicio18;

import javax.inject.Inject;

import com.example.demo.ejercicio18.beans.Corporation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio18/beans.xml"})
public class Jsr330Tests {
    
    @Inject
    private Corporation corporation;

    @Test
    public void annotationsTest(){
        log.info("Testing jsr330 annotations...");

        Assert.assertNotNull(corporation);
    }
}
