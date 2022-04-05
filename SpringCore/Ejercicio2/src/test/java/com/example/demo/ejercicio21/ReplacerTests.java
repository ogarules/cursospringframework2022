package com.example.demo.ejercicio21;

import com.example.demo.ejercicio21.methodreplacement.SportsCar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ejercicio21/replacer-beans.xml" })
public class ReplacerTests {
    
    @Autowired
    private SportsCar sportsCar;

    @Test
    public void methodReplacementTest() {
        log.info("Tesnting method replacement...");

        Assert.assertEquals(200, sportsCar.run());
    }
}
