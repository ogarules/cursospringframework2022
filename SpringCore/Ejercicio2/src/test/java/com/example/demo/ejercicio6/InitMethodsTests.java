package com.example.demo.ejercicio6;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Assert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitMethodsTests {
    
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio6/beans.xml");
    }

    @Test
    public void InitMethodTest() {
        log.info("Testing bean init and destroy methods...");

        DataBaseConnection conn = applicationContext.getBean(DataBaseConnection.class);

        Assert.assertNotNull(conn);

        ((AbstractApplicationContext) applicationContext).close();
    }
}
