package com.example.demo.ejerciciob;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BFPPTests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejerciciob/beans.xml");
    }

    @Test
    public void factoryPPTest() {
        log.info("Testing bean factory post processor....");

        Ant ant = (Ant) applicationContext.getBean("antBean");

        Assert.assertNotNull(ant);
        Assert.assertEquals("red", ant.getColor());
    }

}
