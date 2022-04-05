package com.example.demo.ejercicio9;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParentBeanTemplateTests {
    
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio9/beans.xml");
    }

    @Test
    public void ParentBeanTest() {
        log.info("Testing bean parent...");

        DataBaseConnection dbConParent = (DataBaseConnection) applicationContext.getBean("connectionParentBean");
        DataBaseConnection dbConChild = (DataBaseConnection) applicationContext.getBean("connectionChilBean");

        Assert.assertEquals("localhost", dbConParent.getDatabase());
        Assert.assertEquals("UATdatabase", dbConChild.getDatabase());
    }

    @Test
    public void TemplateBeanTest() {
        log.info("Testing bean parent...");

        DataBaseConnection dbConChild = (DataBaseConnection) applicationContext.getBean("connectionChilTemplateBean");

        Assert.assertEquals("Proddatabase", dbConChild.getDatabase());
    }
}
