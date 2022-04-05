package com.example.demo.ejercicio8;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryTests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio8/beans.xml");
    }

    @Test
    public void FactoryMethodTest() {
        log.info("Testing factory method...");

        Student student = (Student) applicationContext.getBean("studentFactoryMethodBean");

        Assert.assertEquals("Oscar Garcia", student.getSubject().getTeacher().getName());
    }

    @Test
    public void FactoryByBeanTest() {
        log.info("Testing factory method...");

        Student student = (Student) applicationContext.getBean("studentByFactoryBean");

        Assert.assertEquals("Oscar Garcia", student.getSubject().getTeacher().getName());
    }
}
