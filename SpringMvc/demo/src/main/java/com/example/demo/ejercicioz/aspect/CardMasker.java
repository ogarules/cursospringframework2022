package com.example.demo.ejercicioz.aspect;

import com.example.demo.ejercicioz.model.Card;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
public class CardMasker {
    
    @Around("execution(public * com.example.demo.ejercicioz.model.Card.getCardNumber(..))")
    private Object maskCardGetter(ProceedingJoinPoint joinPoint) throws Throwable {

        Integer f = 0;
        long initTime = System.currentTimeMillis();
        log.info("Araund before");
        Object result = joinPoint.proceed();

        result = "XXXX-XXXX-XXXX-XX12";

        long finalTime = System.currentTimeMillis();
        long ejecutionTime = (finalTime - initTime) / 1000;

        log.info("Tiempo de ejecución: {} segundos", ejecutionTime);
        log.info("Araund after");

        return result;
    }

    // @Around("@annotation(com.example.demo.ejercicioz.aspect.MaskCard)")
    // private Object maskCard(ProceedingJoinPoint joinPoint) throws Throwable {

    //     Integer f = 0;
    //     long initTime = System.currentTimeMillis();
    //     log.info("Araund before");
    //     Object result = joinPoint.proceed();

    //     if (result instanceof Card) {
    //         Card cardItem = (Card) result;
    //         cardItem.setCardNumber("XXXX-XXXX-XXXX-XX12");
    //     }

    //     long finalTime = System.currentTimeMillis();
    //     long ejecutionTime = (finalTime - initTime) / 1000;

    //     log.info("Tiempo de ejecución: {} segundos", ejecutionTime);
    //     log.info("Araund after");

    //     return result;
    // }
    
    @Around("execution(Iterable<com.example.demo.ejercicioz.model.Card> com.example.demo.ejercicioz.service.*.*(..))")
    private Object maskCards(ProceedingJoinPoint joinPoint) throws Throwable {

        Integer f = 0;
        long initTime = System.currentTimeMillis();
        log.info("Araund before");
        Object result = joinPoint.proceed();

        Iterable<Card> cardItems = (Iterable<Card>) result;
        for (Card card : cardItems) {
            card.setCardNumber("XXXX-XXXX-XXXX-XX12");
        }

        long finalTime = System.currentTimeMillis();
        long ejecutionTime = (finalTime - initTime) / 1000;

        log.info("Tiempo de ejecución: {} segundos", ejecutionTime);
        log.info("Araund after");

        return result;
    }
    
    @Around("execution(com.example.demo.ejercicioz.model.Card com.example.demo.ejercicioz.service.*.*(..))")
    private Object maskCard(ProceedingJoinPoint joinPoint) throws Throwable {

        Integer f = 0;
        long initTime = System.currentTimeMillis();
        log.info("Araund before");
        Object result = joinPoint.proceed();

        if (result instanceof Card) {
            Card cardItem = (Card) result;
            cardItem.setCardNumber("XXXX-XXXX-XXXX-XX12");
        }

        long finalTime = System.currentTimeMillis();
        long ejecutionTime = (finalTime - initTime) / 1000;

        log.info("Tiempo de ejecución: {} segundos", ejecutionTime);
        log.info("Araund after");

        return result;
    }
}
