package com.example.demo.ejercicio20;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ejercicio20/beans.xml" })
public class PlaceHoldersTests {
    
    @Autowired
    private FavouriteRockBands rockBands;

    @Value("${service.name}")
    private String serviceName;

    @Value("${service.description}")
    private String serviceDescription;

    @Test
    public void favouriteRockBandsTest() {
        log.info("Testing plaeholders favourite rockbands...");

        Assert.assertEquals("Bon jovi", rockBands.getFirstRockBand());
    }

    @SneakyThrows
    @Test
    public void txtFileResourceLoadTests() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext();
        
        log.info("Resource loading txt file");

        Resource resource = applicationContext
                .getResource("src/main/resources/spring/ejercicio20/certificatic-resources/my-textfile.txt");

        ResourceLoaderUtils.loadTesxtResourceTest(resource);
        
        ((AbstractApplicationContext) applicationContext).close();
    }
}
