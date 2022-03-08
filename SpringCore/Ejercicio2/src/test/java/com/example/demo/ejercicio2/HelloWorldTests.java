package com.example.demo.ejercicio2;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloWorldTests {
    
    @Test
    public void helloWorldTraditionalTest() {
        log.info("Testing traditional instance...");

        HelloWorld helloWorld = new HelloWorld("hola");

        Assert.assertEquals("hola", helloWorld.getMensaje());
    }

    @Test
    public void helloWorldFactoryTest() {
        log.info("Testing spring factory...");

        var path = "spring/ejercicio2/beans.xml";
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource(path));

        var helloProps = (HelloWorld) factory.getBean("helloWorldProps");
        var helloConst = (HelloWorld) factory.getBean("helloWorldConst");

        Assert.assertEquals("hello by property", helloProps.getMensaje());
        Assert.assertEquals("hello by constructor", helloConst.getMensaje());

        var helloProps2 = (HelloWorld) factory.getBean("helloWorldProps");
        helloProps2.setMensaje("hola 2");

        Assert.assertEquals("hola 2", helloProps.getMensaje());
    }
}
