package com.example.demo.ejercicio26;

import com.example.demo.ejercicio26.springtx.BusinessObject;
import com.example.demo.ejercicio26.springtx.service.ITransactionalService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("h2-in-memory")
@ContextConfiguration(locations = "classpath:spring/ejercicio26/spring-tx-application-context.xml")
@TestPropertySource(properties = {"logging.level.ROOT=INFO","logging.level.org.springframework.orm.jpa=DEBUG",
        "logging.level.org.springframework.transaction=DEBUG" })

        public class DeclarativeXMLTransactionManagerTest {

            @Autowired
            private ITransactionalService transactionalService;
        
            @Before
            public void setUp() {
                Assert.assertNotNull(transactionalService);
            }
        
            @Test
            public void declarativeXMLTransactionManagerTest() {
                log.info("declarativeXMLTransactionManagerTest -------------------");
        
                log.info("calling: transactionalService.getBusinessObject(5L)");
                BusinessObject bo = null;
                try {
                    bo = transactionalService.getBusinessObject(5L);
                } catch (Exception ex) {
                    log.info(
                            "transactionalService.getBusinessObject(5L) throws Exception {}",
                            ex.getMessage());
                }
                log.info("getBusinessObject(5L): {}", bo);
        
                log.info("\n----------------------------------------------");
        
                log.info("calling: transactionalService.insertBusinessObject(null)");
                try {
                    transactionalService.insertBusinessObject(null);
                } catch (Exception ex) {
                    log.info(
                            "transactionalService.insertBusinessObject(null) throws Exception {}",
                            ex.getMessage());
                }
        
                log.info("\n----------------------------------------------");
        
                log.info("calling: transactionalService.updateBusinessObject(bo)");
                try {
                    transactionalService.updateBusinessObject(bo);
                } catch (Exception ex) {
                    log.info(
                            "transactionalService.updateBusinessObject(bo) throws Exception {}",
                            ex.getMessage());
                }
        
                log.info("\n----------------------------------------------");
        
                log.info("calling: transactionalService.deleteBusinessObject(5L)");
                try {
                    transactionalService.deleteBusinessObject(5L);
                } catch (Exception ex) {
                    log.info(
                            "transactionalService.deleteBusinessObject(5L) throws Exception {}",
                            ex.getMessage());
                }
        
                log.info("\n----------------------------------------------");
            }
        }
        