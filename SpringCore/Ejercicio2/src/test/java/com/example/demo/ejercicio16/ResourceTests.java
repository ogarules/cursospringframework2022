package com.example.demo.ejercicio16;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceTests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio16/beans.xml");
    }

    @Test
    public void resourcesTest() {
        log.info("Testing resources an postconstruct and predestroy...");

        Student student = applicationContext.getBean(Student.class);

        Assert.assertNotNull(student);

        ((AbstractApplicationContext) applicationContext).close();
    }
}
