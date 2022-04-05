package com.example.demo.ejercicioc;

import com.example.demo.ejercicioc.repository.RepositoryA;
import com.example.demo.ejercicioc.services.other.ServiceB;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcludeFilterConfigurationBeanTests {
    
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new AnnotationConfigApplicationContext(FilteringComponentsConfig.class);
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void repositryTest() {
        log.info("Testing filtered repository...");

        RepositoryA repository = applicationContext.getBean(RepositoryA.class);

        Assert.fail();
    }
    
    @Test(expected = NoSuchBeanDefinitionException.class)
    public void serviceaTest() {
        log.info("Testing filtered service...");

        ServiceA service = applicationContext.getBean(ServiceA.class);

        Assert.fail();
    }
    
    @Test
    public void servicebTest() {
        log.info("Testing filtered repository...");
        
        ServiceB service = applicationContext.getBean(ServiceB.class);

        Assert.assertNotNull(service);
    }
}
