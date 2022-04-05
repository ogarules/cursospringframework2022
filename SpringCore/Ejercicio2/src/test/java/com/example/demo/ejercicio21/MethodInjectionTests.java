package com.example.demo.ejercicio21;

import com.example.demo.ejercicio21.methodinjection.SingletonBean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ejercicio21/methodinjection-beans.xml" })
public class MethodInjectionTests {
    
    @Autowired
    SingletonBean bean1;

    @Autowired
    SingletonBean bean2;

    @Test
    public void methodInjectionTest() {
        Assert.assertSame(bean1, bean2);

        Assert.assertNotSame(bean1.getProcessor(), bean2.getProcessor());

        String result = bean1.process("<my-data>Data, more data, more data ...</my-data>");

        String dataExpected = ">atad-ym/<... atad erom ,atad erom ,ataD>atad-ym<\n"
				+ ">atad-ym/<... atad erom ,atad erom ,ataD>atad-ym<\n"
                + ">atad-ym/<... atad erom ,atad erom ,ataD>atad-ym<";
        
        Assert.assertEquals(result, dataExpected);
    }
}
