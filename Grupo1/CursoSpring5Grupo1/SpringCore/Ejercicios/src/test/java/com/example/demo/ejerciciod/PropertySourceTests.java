package com.example.demo.ejerciciod;

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
public class PropertySourceTests {
    
    @Autowired
    ValuesClass valuesClass;

    @Autowired
    EnvorinmentClass environmentClass;

    @Test
    public void propertySourceTest() {
        log.info("Testing property source");

        Assert.assertEquals(valuesClass.getName(), environmentClass.getName());
        Assert.assertEquals(valuesClass.getAge(), environmentClass.getAge());
    }
}
