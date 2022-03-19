package com.example.demo.ejercicio15;

import com.example.demo.ejercicio15.initmethod.Student;
import com.example.demo.ejercicio15.notrequired.Airplane;
import com.example.demo.ejercicio15.property.Reporter;
import com.example.demo.ejercicio15.required.Cameraman;
import com.example.demo.ejercicio15.setter.Journalist;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiringTests {
    
    @Test
    public void requiredConstructorTest() {
        log.info("Testing autoiring by constructor with requiered properties ...");

        var applicationContext = new ClassPathXmlApplicationContext(
                "spring/ejercicio15/beans-required.xml");

        Cameraman cameraman = applicationContext.getBean(Cameraman.class);

        Assert.assertNotNull(cameraman);
        Assert.assertNotNull(cameraman.getName());
        Assert.assertNotNull(cameraman.getRfc());
    }
    
    @Test
    public void propertyTest() {
        log.info("Testing autoiring by properties ...");

        var applicationContext = new ClassPathXmlApplicationContext(
                "spring/ejercicio15/beans-property.xml");

        Reporter reporter = applicationContext.getBean(Reporter.class);

        Assert.assertNotNull(reporter);
        Assert.assertNotNull(reporter.getName());
        Assert.assertNotNull(reporter.getAge());
        Assert.assertNotNull(reporter.getBooklet());
        Assert.assertNotNull(reporter.getPencil());
    }
    
    @Test
    public void notrequiredTest() {
        log.info("Testing autoiring not required and qualifier ...");

        var applicationContext = new ClassPathXmlApplicationContext(
                "spring/ejercicio15/beans-notrequired.xml");

        Airplane airplane = applicationContext.getBean(Airplane.class);

        Assert.assertNotNull(airplane);
        Assert.assertNotNull(airplane.getAirline());
        Assert.assertNull(airplane.getAirplaneCode());
        Assert.assertEquals("airline2", airplane.getAirline().getName());

    }
    
    @Test
    public void initMethodTest() {
        log.info("Testing autoiring by properties ...");

        var applicationContext = new ClassPathXmlApplicationContext(
                "spring/ejercicio15/beans-initmethod.xml");

        Student reporter = applicationContext.getBean(Student.class);

        Assert.assertNotNull(reporter);
        Assert.assertNotNull(reporter.getName());
        Assert.assertNotNull(reporter.getAge());
        Assert.assertNotNull(reporter.getRfc());
        Assert.assertNotNull(reporter.getStudentBook());
    }

    @Test
    public void setterTest() {
        log.info("Testing autoiring by setter ...");

        var applicationContext = new ClassPathXmlApplicationContext(
                "spring/ejercicio15/beans-setter.xml");

        Journalist journalist = applicationContext.getBean(Journalist.class);

        Assert.assertNotNull(journalist);
        Assert.assertNotNull(journalist.getName());
        Assert.assertNotNull(journalist.getAge());
        Assert.assertNotNull(journalist.getRfc());
        Assert.assertNotNull(journalist.getNotebook());
        Assert.assertNotNull(journalist.getPen());
    }
}
