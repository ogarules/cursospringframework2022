package com.example.demo.ejercicioa.aspect;

import com.example.demo.ejercicioa.domain.Card;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
public class CardMaskerAspect {
    
    @Around("execution(Iterable<com.example.demo.ejercicioa.domain.Card> com.example.demo.ejercicioa.service.*.*(..))")
    private Object maskCards(ProceedingJoinPoint joinPoint) throws Throwable {

        Integer f = 0;
        long initTime = System.currentTimeMillis();
        log.info("Araund before");
        Object result = joinPoint.proceed();

        Iterable<Card> cardItems = (Iterable<Card>) result;
        for (Card card : cardItems) {
            card.setCardNumber("XXXX-XXXX-XXXX-XX" + card.getCardNumber().substring(card.getCardNumber().length() - 2, card.getCardNumber().length()));
        }

        long finalTime = System.currentTimeMillis();
        long ejecutionTime = (finalTime - initTime) / 1000;

        log.info("Tiempo de ejecución: {} segundos", ejecutionTime);
        log.info("Araund after");

        return result;
    }
    
    @Around("execution(com.example.demo.ejercicioa.domain.Card com.example.demo.ejercicioa.service.*.*(..))")
    private Object maskCard(ProceedingJoinPoint joinPoint) throws Throwable {

        Integer f = 0;
        long initTime = System.currentTimeMillis();
        log.info("Araund before");
        Object result = joinPoint.proceed();

        if (result instanceof Card) {
            Card cardItem = (Card) result;
            cardItem.setCardNumber("XXXX-XXXX-XXXX-XX" + cardItem.getCardNumber().substring(cardItem.getCardNumber().length() - 2, cardItem.getCardNumber().length()));
        }

        long finalTime = System.currentTimeMillis();
        long ejecutionTime = (finalTime - initTime) / 1000;

        log.info("Tiempo de ejecución: {} segundos", ejecutionTime);
        log.info("Araund after");

        return result;
    }
}
