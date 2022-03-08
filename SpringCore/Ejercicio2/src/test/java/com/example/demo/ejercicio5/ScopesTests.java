package com.example.demo.ejercicio5;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScopesTests {
    
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio5/beans.xml");
    }

    @Test
    public void SingletonScopeTest() {
        log.info("Testing sigleton scope");

        Persona persona = (Persona) applicationContext.getBean("personaSingletonBean");
        Persona persona2 = (Persona) applicationContext.getBean("personaSingletonBean");

        persona.setNombre("Oscar");

        Assert.assertEquals(persona2.getNombre(), persona.getNombre());
    }

    @Test
    public void PrototypeScopeTest() {
        log.info("Testing prototype scope");

        Persona persona = (Persona) applicationContext.getBean("personaPtototypeBean");
        Persona persona2 = (Persona) applicationContext.getBean("personaPtototypeBean");

        persona.setNombre("Oscar");
        persona2.setNombre("Juanito");

        Assert.assertNotEquals(persona2.getNombre(), persona.getNombre());
    }

    @Test
    public void CustmScopeTest() {
        log.info("Testing custom scope");

        Persona persona = (Persona) applicationContext.getBean("personaCustomScopeBean");
        Persona persona2 = (Persona) applicationContext.getBean("personaCustomScopeBean");
        Persona persona3 = (Persona) applicationContext.getBean("personaCustomScopeBean");
        Persona persona4 = (Persona) applicationContext.getBean("personaCustomScopeBean");

        persona.setNombre("Oscar");
        persona4.setNombre("Juanito");

        Assert.assertEquals(persona2.getNombre(), persona.getNombre());
        Assert.assertNotEquals(persona4.getNombre(), persona.getNombre());
    }
}
