package com.example.demo.ejercicio9;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplatesTests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio9/beans.xml");
    }

    @Test
    public void ChildPropertyInheritanceTest() {
        log.info("Testing child bean definition ...");

        DatabaseConnection dbConnParent = (DatabaseConnection) applicationContext.getBean("connectionParentBean");
        DatabaseConnection dbConnChild = (DatabaseConnection) applicationContext.getBean("connectionChildBean");

        Assert.assertEquals("localhost", dbConnParent.getDatabase());
        Assert.assertEquals("UATdb", dbConnChild.getDatabase());
        Assert.assertEquals("oga", dbConnChild.getUser());
    }

}
