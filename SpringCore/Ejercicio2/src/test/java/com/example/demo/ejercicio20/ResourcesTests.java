package com.example.demo.ejercicio20;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio20/beans.xml"})
public class ResourcesTests {
    
    @Autowired
    Resources resources;

    @Test
    public void loadTextFileTest() throws Exception {
        ResourceLoaderUtils.loadTextFileTest(resources.getTxtFile());
    }
}
