package com.example.demo.ejercicio6;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitDestroyTests {
    
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio6/beans.xml");
    }

    @Test
    public void initDestroyTest() {
        log.info("Testing bean init and destroy methods...");

        DataBaseConnection dbConn = applicationContext.getBean(DataBaseConnection.class);

        Assert.assertNotNull(dbConn);

        ((AbstractApplicationContext)applicationContext).close();
    }
}
