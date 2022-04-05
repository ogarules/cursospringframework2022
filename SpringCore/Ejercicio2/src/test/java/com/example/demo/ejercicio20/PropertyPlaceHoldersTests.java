package com.example.demo.ejercicio20;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio20/beans.xml"})
public class PropertyPlaceHoldersTests {
    
    @Autowired
    private FavouriteRockBands rockBands;

    @Value("${service.name}")
    private String serviceName;

    @Value("${service.description}")
    private String serviceDescription;

    @Value("${datasource.name}")
    private String dataSourceName;

    @Value("${datasource.description}")
    private String dataSourceDescription;

    @Value("${app.name}")
    private String appName;

    @Value("${app.description}")
    private String appDescription;

    @Test
    public void favouriteRockBandsTest() {
        log.info("Testing favourite band names...");

        Assert.assertEquals("Bon jovi", rockBands.getFirstRockBand());
        Assert.assertEquals("Foo fighters", rockBands.getSecondRockBand());
    }

    @Test
    public void placeHolderTest() {
        Assert.assertEquals("My service", serviceName);
        Assert.assertEquals("My fantastic service", serviceDescription);
    }
}
