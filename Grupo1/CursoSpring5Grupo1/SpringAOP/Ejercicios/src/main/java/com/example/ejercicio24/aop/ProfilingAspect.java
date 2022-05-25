package com.example.ejercicio24.aop;

import com.example.util.Color;
import com.example.util.IColorWriter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
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

	private @Getter int order = 1;

	@Autowired
	private IColorWriter colorWriter;

	@Around(value="within(com.example.ejercicio24..*) and args(x,..)", argNames="x")
	public Object beforeAccountMethodExecutionAccount(ProceedingJoinPoint pjp,
			Object obj) throws Throwable {

		StopWatch stopWatch = new StopWatch();
        stopWatch.start(pjp.toShortString());
        
        String nm = pjp.getSignature().getName();

		boolean isExceptionThrown = false;

		try {

			return pjp.proceed(); 

		} catch (RuntimeException e) {
			isExceptionThrown = true;
			throw e;
		} finally {
			stopWatch.stop();
			TaskInfo taskInfo = stopWatch.getLastTaskInfo();

			String profileMessage = taskInfo.getTaskName() + ": "
					+ taskInfo.getTimeMillis() + " ms"
					+ (isExceptionThrown ? " (thrown Exception)" : "");

			log.info("{}, object intercepted: {}",
					colorWriter.getColoredMessage(Color.GREEN, profileMessage),
					colorWriter.getColoredMessage(Color.GREEN,
							obj.getClass().getSimpleName()));
		}
	}
}

