package com.example.demo.ejercicio14;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConverterTests {
    
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio14/beans.xml");
    }

    @Test
    public void converterTest() {
        log.info("Testing cnverter...");

        NumericalConverter converter = applicationContext.getBean(NumericalConverter.class);

        String result = converter.convert("999999999,00", true);
        log.info(result);

        Assert.assertNotNull(result);
        Assert.assertEquals("NOVECIENTOS NOVENTA Y NUEVE MILLONES NOVECIENTOS NOVENTA Y NUEVE MIL NOVECIENTOS NOVENTA Y NUEVE PESOS 00/100", result);
    }
    
}
