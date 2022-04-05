package com.example.demo.ejercicioa;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LifecycleTests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicioa/beans.xml");
    }

    @Test
    public void LifeCycleTest() {
        log.info("Testing lifecycle bean...");

        ((AbstractApplicationContext) applicationContext).start();
        ((AbstractApplicationContext) applicationContext).close();
    }
}
