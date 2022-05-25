package com.example.demo.tarea3;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class NumericalConverterTest {
    
    @Autowired
    NumericalConverter converter;

    @Test
    public void numericalConverterTest() {
        log.info("Testing number to string converter...");

        String convertedString = converter.convert("999999999,00", true, "esp");
        log.info(convertedString);
        Assert.assertNotNull(converter);
        Assert.assertNotNull(convertedString);
        assertEquals(
                "NOVECIENTOS NOVENTA Y NUEVE MILLONES NOVECIENTOS NOVENTA Y NUEVE MIL NOVECIENTOS NOVENTA Y NUEVE PESOS 00/100",
                converter.convert("999999999,00", true, "esp"));
        
        convertedString = converter.convert("999999999,00", true, "eng");

        log.info(convertedString);

        assertEquals(
                "NINE HUNDRED NINETY  NINE MILLIONS NINE HUNDRED NINETY  NINE THOUSENF NINE HUNDRED NINETY  NINE DOLLARS 00/100",
                convertedString);
    }
}
