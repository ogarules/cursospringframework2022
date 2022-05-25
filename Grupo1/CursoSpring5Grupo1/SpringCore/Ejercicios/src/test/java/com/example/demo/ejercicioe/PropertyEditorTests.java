package com.example.demo.ejercicioe;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertyEditorTests {
    
    private static ApplicationContext applicationContext;

    @BeforeClass
    public static void init() {
        applicationContext = new ClassPathXmlApplicationContext("spring/ejercicioe/beans.xml");

    }

    @Test()
    public void propertyEditorTest() {
        log.info("Testing property editor...");

        Client client = applicationContext.getBean(Client.class);

        Assert.assertNotNull(client.getCard());
        Assert.assertEquals("1111-2222-3333-4444", client.getCard().getRawCardNumber());
        
        CreditCardEditor editor = new CreditCardEditor();
        CreditCard creditCard = applicationContext.getBean(CreditCard.class);
        BeanWrapperImpl wrapper = new BeanWrapperImpl(creditCard);

        wrapper.registerCustomEditor(CreditCard.class, null, editor);
        editor.setAsText("1111-1111-1111-1111");
        ((CreditCard)editor.getValue()).setRawCardNumber("2222-2222-2222-2222");

        String finalCardNumber = editor.getAsText();

        Assert.assertEquals("2222-2222-2222-2222", finalCardNumber);
    }
}
