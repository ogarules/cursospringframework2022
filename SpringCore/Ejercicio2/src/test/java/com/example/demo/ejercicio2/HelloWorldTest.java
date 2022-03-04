package com.example.demo.ejercicio2;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloWorldTest {
    
    @Test
    public void HelloWordlTraditionalTest() {
        log.info("Testing traditional instance...");

        HelloWorld helloWorld = new HelloWorld("hola");

        Assert.assertEquals("hola", helloWorld.getMensaje());
    }

    @Test
    public void HelloWorldSpringPropsTest() {
        log.info("Testing spring properties injection...");

        String path = "spring/ejercicio2/beans.xml";
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource(path));

        HelloWorld helloWorld1 = (HelloWorld) factory.getBean("helloWorldProps");
        HelloWorld helloWorld2 = (HelloWorld) factory.getBean("helloWorldProps");

        Assert.assertEquals("hello", helloWorld1.getMensaje());
    
        log.info("Changing property");

        helloWorld1.setMensaje("hola en español");
        Assert.assertEquals("hola en español", helloWorld2.getMensaje());

        log.info("Getting second bean");

        HelloWorld helloWorld3 = (HelloWorld) factory.getBean("helloWorldConst");
        Assert.assertNotSame(helloWorld2.getMensaje(), helloWorld3.getMensaje());
    }

}
