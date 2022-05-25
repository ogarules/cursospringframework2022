package com.example.demo.ejercicio26;

import com.example.demo.ejercicio26.domain.BusinessObject;
import com.example.demo.ejercicio26.service.ITransactionalService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ejercicio26/spring-jdbc.xml" })
@ActiveProfiles("h2-in-memory")
public class XmlTransactionsTests {
    @Autowired
    ITransactionalService service;

    @Test
    public void testingTransactionConfiguration() {
        log.info("Testing transactional configuration...");

        BusinessObject bo = null;

        bo = service.getBusinessObject(5L);

        log.info("---------------------------------------------");

        log.info("Inserting businessObject...");

        try {
            service.insertBusinessObject(bo);    
        } catch (Exception e) {
            log.info("Insert Error {}", e.getMessage());
        }

        log.info("---------------------------------------------");

        log.info("Updating businessObject...");

        try {
            service.updateBusinessObject(bo);    
        } catch (Exception e) {
            log.info("Update Error {}", e.getMessage());
        }

        log.info("---------------------------------------------");

        log.info("Deleting businessObject...");
        service.deleteBusinessObject(5L); 
    }
}
