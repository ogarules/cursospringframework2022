package com.example.demo.ejercicio13;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowireTests {
    
    @Test
    public void constructorAutowireTest() {
        log.info("Testing constructor autowirng...");

        var applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio13/beans-constructor.xml");

        Car car = applicationContext.getBean(Car.class);

        Assert.assertNotNull(car);
        Assert.assertNotNull(car.getEngine());
        Assert.assertNotNull(car.getWheelGroup());
    }

    @Test
    public void typeAutowireTest() {
        log.info("Testing constructor autowirng...");

        var applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio13/beans-type.xml");

        Car car = applicationContext.getBean(Car.class);

        Assert.assertNotNull(car);
        Assert.assertNotNull(car.getEngine());
        Assert.assertNotNull(car.getWheelGroup());
    }

    @Test
    public void nameAutowireTest() {
        log.info("Testing constructor autowirng...");

        var applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio13/beans-name.xml");

        Car car = applicationContext.getBean(Car.class);

        Assert.assertNotNull(car);
        Assert.assertNotNull(car.getEngine());
        Assert.assertNotNull(car.getWheelGroup());
    }
}
