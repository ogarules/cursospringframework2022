package com.example.demo.ejercicio7;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LazyInitiTests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio7/beans.xml");
    }

    @Test
    public void lazyInitTest() {
        log.info("Testing lazy init....");

        Car car = applicationContext.getBean(Car.class);

        Assert.assertNotNull(car);

        car.getWheel1().setBrand("pirelli");

        Assert.assertNotEquals(car.getWheel1().getBrand(), car.getWheel2().getBrand());
    }
}
