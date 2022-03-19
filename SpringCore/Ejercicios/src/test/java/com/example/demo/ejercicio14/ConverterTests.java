package com.example.demo.ejercicio14;

import static org.junit.Assert.assertEquals;

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
        log.info("Testing number to string converter...");

        NumericalConverter converter = applicationContext.getBean(NumericalConverter.class);

        String convertedString = converter.convert("999999999,00", true);
        log.info(convertedString);
        Assert.assertNotNull(converter);
        Assert.assertNotNull(convertedString);
        assertEquals("NOVECIENTOS NOVENTA Y NUEVE MILLONES NOVECIENTOS NOVENTA Y NUEVE MIL NOVECIENTOS NOVENTA Y NUEVE PESOS 00/100", converter.convert("999999999,00", true));
    }
}
