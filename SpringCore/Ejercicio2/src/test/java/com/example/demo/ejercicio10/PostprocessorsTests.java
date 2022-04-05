package com.example.demo.ejercicio10;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostprocessorsTests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio10/beans.xml");
    }

    @Test
    public void postProcessorTest() {
        log.info("Postprocessor testing...");

        IWorker worker = (IWorker)applicationContext.getBean("workerBean");

        Assert.assertEquals(WorkerFacade.class, worker.getClass());
        
    }

}
