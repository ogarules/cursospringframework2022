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
    public void internalDefinitionTest() {
        log.info("Teting internal definition");

        Person person = (Person) applicationContext.getBean(Person.class);

        Assert.assertEquals("Eje central", person.getAddress().getStreet());
    }

}
