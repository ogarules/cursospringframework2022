package com.example.demo.ejercicio20;

import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourcesFileAppContext {
    private static ApplicationContext applicationContext = new FileSystemXmlApplicationContext();

    @AfterClass
    public static void closeAppContext() {
        ((AbstractApplicationContext) applicationContext).close();
    }

    @Test
    public void txtFileResourceTest() throws Exception {
        log.info("Testing txt file resource load...");

        Resource resource = applicationContext
                .getResource("src/main/resources/spring/ejercicio20/certificatic-resources/my-text-file.txt");

        ResourceLoaderUtils.loadTextFileTest(resource);
    }
}
