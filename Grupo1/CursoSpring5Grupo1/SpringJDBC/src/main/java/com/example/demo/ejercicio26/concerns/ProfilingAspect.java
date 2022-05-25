package com.example.demo.ejercicio26.concerns;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ProfilingAspect implements Ordered {
    private @Getter int order = 99;

    @Around("execution(* com.example.demo.ejercicio26.service.ITransactionalService.*(..))")
    public Object aroundServiceMethods(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch sw = new StopWatch();
        sw.start(pjp.toShortString());

        Object result = pjp.proceed();

        sw.stop();
        
        TaskInfo info = sw.getLastTaskInfo();

        log.info("-----> {}  - > Duration: {}", info.getTaskName(), info.getTimeMillis());

        return result;
    }
}
