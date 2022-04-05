package com.example.demo.ejercicio17;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SterotypesTests {

    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio17/beans.xml");
    }

    @Test
    public void stereotypeTest() {
        log.info("Testing bean injection....");

        IComponentClass component = applicationContext.getBean(IComponentClass.class);
        IControllerClass controller = applicationContext.getBean(IControllerClass.class);
        IRepositoryClass repository = applicationContext.getBean(IRepositoryClass.class);
        IRestControllerClass restController = applicationContext.getBean(IRestControllerClass.class);
        IServiceClass service = applicationContext.getBean(IServiceClass.class);

        Assert.assertEquals("Fabulous component", component.getComponentClassName());
        Assert.assertEquals("Fabulous controller", controller.getControllerClassName());
        Assert.assertEquals("Fabulous repository", repository.getRepositoryClassName());
        Assert.assertEquals("Fabulous rest controller", restController.getRestControllerClassName());
        Assert.assertEquals("Fabulous service", service.getServiceClassName());
    }
}
