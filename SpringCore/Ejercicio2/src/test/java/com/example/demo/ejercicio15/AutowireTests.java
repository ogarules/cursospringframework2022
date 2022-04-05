package com.example.demo.ejercicio15;

import com.example.demo.ejercicio15.initmethod.Student;
import com.example.demo.ejercicio15.notrequired.Airplane;
import com.example.demo.ejercicio15.properties.Reporter;
import com.example.demo.ejercicio15.required.Cameraman;
import com.example.demo.ejercicio15.setter.Journalist;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowireTests {

    @Test
    public void requiredConstructorTest() {
        log.info("Testing autowiring by required constructor...");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/ejercicio15/beans-required.xml");
        Cameraman cameraman = applicationContext.getBean(Cameraman.class);

        Assert.assertNotNull(cameraman.getName());
        Assert.assertNotNull(cameraman.getRfc());
    }
    
    @Test
    public void setterTest() {
        log.info("Testing autowiring by setter...");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/ejercicio15/beans-setter.xml");
        Journalist journalist = applicationContext.getBean(Journalist.class);

        Assert.assertNotNull(journalist.getName());
        Assert.assertNotNull(journalist.getRfc());
        Assert.assertNotNull(journalist.getAge());
        Assert.assertNotNull(journalist.getNotebook());
        Assert.assertNotNull(journalist.getPen());
    }
    
    @Test
    public void propertiesTest() {
        log.info("Testing autowiring by setter...");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/ejercicio15/beans-property.xml");
        Reporter reporter = applicationContext.getBean(Reporter.class);

        Assert.assertNotNull(reporter.getName());
        Assert.assertNotNull(reporter.getRfc());
        Assert.assertNotNull(reporter.getAge());
        Assert.assertNotNull(reporter.getBooklet());
        Assert.assertNotNull(reporter.getPencil());
    }
    
    @Test
    public void notRequiredTest() {
        log.info("Testing autowiring not required and qualifier...");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/ejercicio15/beans-notrequired.xml");
        Airplane airplane = applicationContext.getBean(Airplane.class);

        Assert.assertNull(airplane.getAirplaneCode());
        Assert.assertEquals("aeromexico", airplane.getAirline().getName());

    }
    
    @Test
    public void initmethodTest() {
        log.info("Testing autowiring init method...");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/ejercicio15/beans-initmethod.xml");
        Student student = applicationContext.getBean(Student.class);

        Assert.assertNotNull(student.getName());
        Assert.assertNotNull(student.getRfc());
        Assert.assertNotNull(student.getAge());
        Assert.assertNotNull(student.getStudentBook());
    }
    
}
