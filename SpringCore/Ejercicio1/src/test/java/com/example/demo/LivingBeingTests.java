package com.example.demo;

import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LivingBeingTests {
    //private static final Logger lof = LoggerFactory.getLogger(LivingBeingTests.class);

    @Test
    public void LivingBaingTest() {
        log.info("Testing living being");

        Aadvark aadvark = new Aadvark();
        VenusFlyTrap venusFlyTrap = new VenusFlyTrap();

        BugEater bugEaterAadvark = aadvark;
        BugEater bugEaterVenusFlyTrap = venusFlyTrap;

        LivingBeing livingBeingAadvark = aadvark;
        LivingBeing livingBeingVenusFlyTrap = venusFlyTrap;

        Assert.assertEquals("Aadvark consumed bug", bugEaterAadvark.consume(new Bug()));
        Assert.assertEquals("VenusFlyTrap consumed bug", bugEaterVenusFlyTrap.consume(new Bug()));
    }
}
