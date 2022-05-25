package com.example.demo.ejercicio17;

import com.example.demo.ejercicio17.impl.ComponentClass;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComponentScanTests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio17/beans.xml");
    }

    @Test
    public void componentScanTest() {
        log.info("Testing compoenent Scan...");

        IComponentClass componentClass = applicationContext.getBean(IComponentClass.class);
        IControllerClass controllerClass = applicationContext.getBean(IControllerClass.class);
        IRepositoryClass repositoryClass = applicationContext.getBean(IRepositoryClass.class);
        IRestControllerClass restControllerClass = applicationContext.getBean(IRestControllerClass.class);
        IServiceClass serviceClass = applicationContext.getBean(IServiceClass.class);

        Assert.assertEquals("My component class", componentClass.getComponentClassName());
        Assert.assertEquals("My controller class", controllerClass.getControllerClassName());
        Assert.assertEquals("My repository class", repositoryClass.getRepositoryClassName());
        Assert.assertEquals("My rest controller class", restControllerClass.getRestControllerClassName());
        Assert.assertEquals("My service class", serviceClass.getServiceClassName());
    }
}
