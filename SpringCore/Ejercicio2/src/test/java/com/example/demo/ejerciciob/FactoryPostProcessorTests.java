package com.example.demo.ejerciciob;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryPostProcessorTests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejerciciob/beans.xml");
    }

    @Test
    public void beanFactoryTest() {

        log.info("Testing bean factiry...");

        Ant ant = (Ant) applicationContext.getBean("antBean");

        assertNotNull(ant);
        Assert.assertEquals("red", ant.getColor());
    }
}
