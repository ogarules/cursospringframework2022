package com.example.ejercicio23;

import com.example.util.Color;
import com.example.util.IColorWriter;

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
public class Mago implements IAdivinador {
    @Autowired
    IColorWriter colorWriter;

    @Pointcut("execution(* com.example.ejercicio23.IVoluntario.pensar*(String)) " +
              "&& args(pensamiento)")
    private void cuandoUnParticipantePiensaEnAlgo(String pensamiento) {
    }
    
    @Pointcut(value = "execution(* com.example.ejercicio23.IVoluntario.getP*(boolean)) " +
              "&& args(x)", argNames="x")
    private void cuandoUnPArticipanteQuieraHacerTrampa(boolean hacerTrampa) {
    }

    @Before("cuandoUnParticipantePiensaEnAlgo(pensamiento)")
    @Override
    public void interceptarPensamiento(JoinPoint jp, String pensamiento) {
        log.info(colorWriter.getColoredMessage(Color.YELLOW,
                "[Mago] El voluntario se prepara para pensar en algo... Pensando en " + pensamiento));
    }
  
    @Around("cuandoUnPArticipanteQuieraHacerTrampa(hacerTrampa)")
    public Object hacerMagia(ProceedingJoinPoint pjp, boolean hacerTrampa) throws Throwable {
        if (hacerTrampa) {
            return "Momento me quieres hacer trampa....";
        }
        
        return pjp.proceed();
    }

    
}
