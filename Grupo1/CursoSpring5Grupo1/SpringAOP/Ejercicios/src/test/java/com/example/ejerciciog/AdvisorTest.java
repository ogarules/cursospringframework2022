package com.example.ejerciciog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejerciciog/beans.xml"})
public class AdvisorTest {
    @Autowired
    BussinessService service;

    @Test
    public void advisorTest() {
        log.info("Testing advisor ....");
        service.execute();
    }
    
}
