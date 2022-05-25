package com.example.demo.ejercicio20;

import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceFileAppContextTests {
    private static ApplicationContext applicationContext = new FileSystemXmlApplicationContext();

    @AfterClass
    public static void closeContext() {
        ((AbstractApplicationContext) applicationContext).close();
    }
    
    @SneakyThrows
    @Test
    public void txtFileResourceLoadTests() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext();
        
        log.info("Resource loading txt file");

        Resource resource = applicationContext
                .getResource("src/main/resources/spring/ejercicio20/certificatic-resources/my-textfile.txt");

        ResourceLoaderUtils.loadTesxtResourceTest(resource);
        
        ((AbstractApplicationContext) applicationContext).close();
    }
}
