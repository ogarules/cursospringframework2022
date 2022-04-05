package com.example.demo.tarea2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CPUtilsTests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/tarea2/beans.xml");

    }

    @Test
    public void namespacesTest() {
        log.info("Testing namespaces C P UTILS...");

        Agenda agenda = (Agenda) applicationContext.getBean(Agenda.class);

        Assert.assertEquals("oga papa", agenda.getPapa().getNombre());

    }

}
