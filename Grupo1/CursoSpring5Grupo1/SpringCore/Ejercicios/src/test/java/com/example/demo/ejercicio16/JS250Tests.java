package com.example.demo.ejercicio16;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JS250Tests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio16/beans.xml");
    }

    @Test
    public void js250Test() {
        log.info("Testing annotations js 250...");

        Student student = applicationContext.getBean(Student.class);

        Assert.assertNotNull(student);
        Assert.assertNotNull(student.getEnrollment());
        Assert.assertNotNull(student.getName());
        Assert.assertNotNull(student.getSubject());
        Assert.assertNotNull(student.getMathematics());
    }
}
