package com.example.demo.ejercicioc;

import com.example.demo.ejercicioc.repositories.RepositoryA;
import com.example.demo.ejercicioc.services.ServiceA;
import com.example.demo.ejercicioc.services.other.ServiceB;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcludeFilterTests {
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicioc/beans.xml");
    }
    
    @Test(expected = NoSuchBeanDefinitionException.class)
    public void excludeFiltersTest() {
        log.info("Testing excluded repository decorations ....");

        RepositoryA repository = applicationContext.getBean(RepositoryA.class);

        Assert.fail();
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void excludeFiltersServiceTest() {
        log.info("Testing excluded service decorations ....");

        ServiceA service = applicationContext.getBean(ServiceA.class);

        Assert.fail();
    }

    @Test
    public void getServiceTest() {
        log.info("Testing excluded service decorations ....");

        ServiceB service = applicationContext.getBean(ServiceB.class);

        Assert.assertNotNull(service);
    }
}
