package com.example.demo.ejercicio10;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostProcessorTests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio10/beans.xml");
    }

    @Test
    public void postProcessorsTest() {
        log.info("Testing postprocessors...");

        IWorker worker = (IWorker) applicationContext.getBean("workerBean");


        Assert.assertEquals(WorkerFacade.class, worker.getClass());
        Assert.assertEquals("otro oga fachada mas after", worker.getName());
        
    }
}
