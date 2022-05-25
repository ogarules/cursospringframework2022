package com.example.demo.ejercicio11;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InternalBeansTests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio11/beans.xml");
    }

    @Test
    public void internalBeanTest(){
        log.info("Testing intenral beans...");

        Person person= applicationContext.getBean(Person.class);

        Assert.assertEquals("el que me cae bien", person.getAddress().getNeighbor());
    }
}
