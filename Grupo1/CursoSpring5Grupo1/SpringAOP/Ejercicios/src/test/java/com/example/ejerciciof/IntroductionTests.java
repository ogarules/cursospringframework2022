package com.example.ejerciciof;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejerciciof/beans.xml"})
public class IntroductionTests {
    @Autowired
    private StudentAdditionalDetails studentAdditionalDetails;

    @Test
    public void introductionTest() {
        log.info("Testing aop introduction....");

        studentAdditionalDetails.showAdditionalDetails();
        ((Student)studentAdditionalDetails).showDetails();
    }
}
