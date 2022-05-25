package com.example.demo.ejercicio2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloWorldAppContextTest {
    
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        var path = "spring/ejercicio2/beans.xml";
        context = new ClassPathXmlApplicationContext(path);
    }

    @Test
    public void HelloworldTest() {
        log.info("Testing bean injection by application context");

        var helloWorld = (HelloWorld) context.getBean("helloWorldProps");

        Assert.assertEquals("hello", helloWorld.getMensaje());
    }
}
