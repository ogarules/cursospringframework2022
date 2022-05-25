package com.example.demo.ejercicio5;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScopeTests {
    
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio5/beans.xml");
    }

    @Test
    public void SingletonScopeTest() {
        log.info("Testing scopes");

        Persona persona = (Persona) applicationContext.getBean("personaSingletonBean");
        Persona persona2 = (Persona) applicationContext.getBean("personaSingletonBean");

        persona.setNombre("test nombre");

        Assert.assertEquals(persona.getNombre(), persona2.getNombre());
    }

    @Test
    public void PrototypeScopeTest() {
        log.info("Testing prototype scopes");

        Persona persona = (Persona) applicationContext.getBean("personaPrototypeBean");
        Persona persona2 = (Persona) applicationContext.getBean("personaPrototypeBean");

        persona.setNombre("test nombre");

        Assert.assertNotEquals(persona.getNombre(), persona2.getNombre());
    }

    @Test
    public void CustomScopeTest() {
        log.info("Testing custom scopes");

        Persona persona = (Persona) applicationContext.getBean("personaCustomBean");
        Persona persona2 = (Persona) applicationContext.getBean("personaCustomBean");
        Persona persona3 = (Persona) applicationContext.getBean("personaCustomBean");
        Persona persona4 = (Persona) applicationContext.getBean("personaCustomBean");
        Persona persona5 = (Persona) applicationContext.getBean("personaCustomBean");
        Persona persona6 = (Persona) applicationContext.getBean("personaCustomBean");

        persona.setNombre("test nombre");
        Assert.assertEquals(persona.getNombre(), persona2.getNombre());
        Assert.assertEquals(persona.getNombre(), persona3.getNombre());

        Assert.assertNotEquals(persona.getNombre(), persona6.getNombre());
    }
}
