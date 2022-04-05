package com.example.demo.ejercicio23;

import com.example.demo.util.Color;
import com.example.demo.util.IColorWriter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class Mago implements IAdivinidaor {

    @Autowired
    IColorWriter colorWriter;

    @Pointcut("execution(* com.example.demo.ejercicio23..IVoluntario.pensar*(String)) " +
              "&& args(pensamiento)")
    private void cuandoUnVoluntarioPiensaEnAlgo(String pensamiento) {
    }

    @Pointcut(value="execution(* com.example.demo.ejercicio23..IVoluntario.getP*(boolean)) " +
              "&& args(x)", argNames="x")
    private void cuandoUnVoluntarioQuiereHacerTrampa(boolean hacerTrampa) {
    }
    
    @Override
    @Before("cuandoUnVoluntarioPiensaEnAlgo(pensamiento)")
    public void interceptarPensamiento(JoinPoint jp, String pensamiento) {
        log.info(colorWriter.getColoredMessage(Color.YELLOW,
                "[Mago] El voluntario esta por pensar en ...." + pensamiento));
    }
    
    @Around("cuandoUnVoluntarioQuiereHacerTrampa(hacerTrampa)")
    public Object hacerMagia(ProceedingJoinPoint pjp, boolean hacerTrampa) throws Throwable
    {
        if (hacerTrampa) {
            return "No te has bañado en 5 dias....";
        }

        return pjp.proceed();
    }

}
