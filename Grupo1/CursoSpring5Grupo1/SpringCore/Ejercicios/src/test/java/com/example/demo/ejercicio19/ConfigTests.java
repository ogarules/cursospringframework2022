package com.example.demo.ejercicio19;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { ApplicationConfig.class, RepositoryConfig.class, ServiceConfig.class })
@ContextConfiguration(classes = {ApplicationConfig.class })
public class ConfigTests {

    @Autowired 
    private ApplicationContext applicationContext;

    @Inject
    private IQuadraticEquationService quadraticService;

    @Inject
    @Qualifier("quadraticEquationServiceBean")
    private IQuadraticEquationService quadraticService2;

    @Inject
    QuadraticEquation quadraticEquation;

    @Resource(name="dummyService")
    DummyService dummyService;

    @Resource
    DummyRepository dummyRepository;

    @Test
    public void injectResourceTest() {
        log.info("Testing inject and Resource");

        Assert.assertNotNull(dummyRepository);
        Assert.assertNotNull(dummyService);
        Assert.assertNotNull(quadraticEquation);
        Assert.assertNotNull(quadraticService2);
        Assert.assertNotNull(quadraticService);
        Assert.assertNotNull(applicationContext);

        String result = quadraticService.quadraticEquationToString(1, 2, 3);

        log.info(result);
        Assert.assertNotNull(result);
        Assert.assertEquals("1.0x^2 + 2.0 +  = 0", result);

        IQuadraticEquationService quadraticServiceFromContext = (IQuadraticEquationService)applicationContext
                .getBean("quadraticService3");

        Assert.assertEquals(result, 
                quadraticServiceFromContext.quadraticEquationToString(1, 2, 3));                
    }

}
