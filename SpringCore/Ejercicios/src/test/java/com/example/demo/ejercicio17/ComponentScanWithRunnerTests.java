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
@ContextConfiguration(locations = {"classpath:spring/ejercicio17/beans.xml"})
public class ComponentScanWithRunnerTests {
    
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
    public void componentScanTest() {
        log.info("Testing conponent scan with runner...");

        Assert.assertEquals("My component class", componentClass.getComponentClassName());
        Assert.assertEquals("My controller class", controllerClass.getControllerClassName());
        Assert.assertEquals("My repository class", repositoryClass.getRepositoryClassName());
        Assert.assertEquals("My rest controller class", restControllerClass.getRestControllerClassName());
        Assert.assertEquals("My service class", serviceClass.getServiceClassName());
    }
}
