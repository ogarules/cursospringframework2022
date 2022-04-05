package com.example.demo.ejercicio20;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio20/beans.xml"})
public class BeanLoaderAwareTests {
    @Autowired
    BeanResourceLoaderAware beanResourceLoaderAware;
    
    @Test
    public void textFileLoadTest() throws Exception {
        Resource resource = beanResourceLoaderAware.getResourceLoader()
                .getResource("file:src/main/resources/spring/ejercicio20/certificatic-resources/my-text-file.txt");

        ResourceLoaderUtils.loadTextFileTest(resource);
    }
}
