package com.example.demo.ejercicio17;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/ejercicio17/beans.xml")
public class StereotypesWithRunnerTests {
    
    @Autowired
    IComponentClass componentClass;

    @Autowired
    IControllerClass controllerClass;

    @Autowired
    IRepositoryClass repositoryClass;

    @Autowired
    IRestControllerClass restControllerClass;

    @Autowired
    IServiceClass serviceClass;

    @Test
    public void stereotypesTest() {
        log.info("Testing stereotypes autowired with runner...");

        Assert.assertEquals("Fabulous component", componentClass.getComponentClassName());
        Assert.assertEquals("Fabulous controller", controllerClass.getControllerClassName());
        Assert.assertEquals("Fabulous repository", repositoryClass.getRepositoryClassName());
        Assert.assertEquals("Fabulous rest controller", restControllerClass.getRestControllerClassName());
        Assert.assertEquals("Fabulous service", serviceClass.getServiceClassName());
    }
}
