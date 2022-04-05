package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LivingBeingTests {
    //private static final Logger log = LoggerFactory.getLogger(LivingBeingTests.class);

    @Test
    public void LivingBeingTest() {
        log.info("Testing living beings");
        
        Aadvark aadvark = new Aadvark();
        VenusFlyTrap venusFlyTrap = new VenusFlyTrap();

        BugEater bugEaterAadvark = aadvark;
        BugEater bugEatervenusFlyTrap = venusFlyTrap;

        LivingBeing livingBeingAadvark = aadvark;
        LivingBeing livingBeingvenusFlyTrap = venusFlyTrap;

        Assert.assertEquals("Aadvark consuming bug", bugEaterAadvark.consume(new Bug()));
        Assert.assertEquals("Venus Fly trap consumed bug", bugEatervenusFlyTrap.consume(new Bug()));

        Assert.assertEquals("Animal consuming water", livingBeingAadvark.consume(new Water()));
        Assert.assertEquals("Plant consuming water", livingBeingvenusFlyTrap.consume(new Water()));
    }
}
