package com.example.demo.ejercicio21;

import java.util.List;

import com.example.demo.ejercicio21.beans.Magician;
import com.example.demo.ejercicio21.beans.MyBeanResolver;
import com.example.demo.ejercicio21.models.Inventor;
import com.example.demo.ejercicio21.models.PlaceOfBirth;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeansXmlTest {
    private static ApplicationContext applicationContext;
    private static ExpressionParser spelParser = new SpelExpressionParser();
    private static StandardEvaluationContext springContext;
    
    @BeforeClass
    public static void initializeBeans() {
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        springContext = new StandardEvaluationContext();

        MyBeanResolver beanResolver = applicationContext.getBean(MyBeanResolver.class);
        springContext.setBeanResolver(beanResolver);
    }

    @Test
    public void beanResolverTest() {
        log.info("Testing bean resolver expression....");

        Magician magician = applicationContext.getBean(Magician.class);
        springContext.setVariable("magicNumber", magician.getInitialNumber());

        Integer randomNumber = spelParser.parseExpression("@guessNumberBean.randomNumber")
                .getValue(springContext, Integer.class);
        springContext.setVariable("randomNumber", randomNumber);

        Boolean numberGuessed = spelParser.parseExpression("#magicNumber == #randomNumber")
                .getValue(springContext, Boolean.class);

        Assert.assertTrue(numberGuessed);
    }

    @Test
    public void factoryBeanInventorsTest() {
        log.info("Testing factory beans....");

        Integer inventions = spelParser.parseExpression("@teslaBean.inventions.length")
                .getValue(springContext, Integer.class);

        Assert.assertEquals(new Integer(3), inventions);

        List<String> inventionsList = spelParser.parseExpression("@teslaBean.inventions")
                .getValue(springContext, List.class);

        Assert.assertEquals(3, inventionsList.size());
    }

    @Test
    public void elvisOperationTest() {
        log.info("Testing elvis operator....");

        springContext.setVariable("name", "Oga");

        Assert.assertEquals("Oga", spelParser.parseExpression("#name").getValue(springContext, String.class));

        spelParser.parseExpression("#name").setValue(springContext, null);

        Assert.assertNull(spelParser.parseExpression("#name").getValue(springContext, String.class));

        Assert.assertEquals("otro oga",
                spelParser.parseExpression("#name?:'otro oga'").getValue(springContext, String.class));
    }
    
    @Test
    public void templatedExpression() {
        springContext.setVariable("name", "Oga");

        String greeting = spelParser.parseExpression("Aloja #{#name + ' you are'} awesome", new TemplateParserContext())
                .getValue(springContext, String.class);

        Assert.assertEquals("Aloja Oga you are awesome", greeting);
    }

    @Test
    public void arraysPropertiesTest() {
        Inventor teslaBean = SocietyStub.createTesla();
        var teslaContext = new StandardEvaluationContext(teslaBean);

        String name = spelParser.parseExpression("name").getValue(teslaContext, String.class);
        Assert.assertEquals("Nikola Tesla", name);

        PlaceOfBirth placeOfBirth = spelParser.parseExpression("placeOfBirth").getValue(teslaContext,
                PlaceOfBirth.class);
        Assert.assertEquals("Serbia", placeOfBirth.getCountry());

        String thirdInvention = spelParser.parseExpression("inventions[2]").getValue(teslaContext, String.class);
        Assert.assertEquals("the transmission of electrical power", thirdInvention);

        var societyContext = new StandardEvaluationContext(SocietyStub.createSociety("IEEE"));

        Inventor teslaFromSociety = spelParser.parseExpression("members[2]").getValue(societyContext, Inventor.class);
        Assert.assertEquals("Nikola Tesla", teslaFromSociety.getName());

        String teslaNameFormSciety = spelParser.parseExpression("members[2].name").getValue(societyContext,
                String.class);

        Assert.assertEquals("Nikola Tesla", teslaNameFormSciety);

        Inventor bruceAmes = spelParser.parseExpression("getMember('Bruce Ames')").getValue(societyContext,
                Inventor.class);
        Assert.assertEquals("Bruce Ames", bruceAmes.getName());
    }
    
    @Test
    public void inlineDeclarations() {
        log.info("Testing inline declarations...");

        List<Integer> numbers = spelParser.parseExpression("{1,2,3,4}")
                .getValue(springContext, List.class);
        
        Integer sum = numbers.stream().reduce(0, (i, j) -> i + j);

        Assert.assertEquals(new Integer(10), sum);
    }
}
