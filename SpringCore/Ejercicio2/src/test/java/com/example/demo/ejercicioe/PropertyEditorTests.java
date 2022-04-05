package com.example.demo.ejercicioe;

import javax.swing.Spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicioe/beans.xml"})
public class PropertyEditorTests {
    @Autowired
    Client client;

    @Test
    public void propertyEditorTest() {
        log.info("Testing... property editor....");

        Assert.assertNotNull(client);
        Assert.assertEquals("1111-2222-3333-4444", client.getCard().getRawCardNumber());

        
    }
}
