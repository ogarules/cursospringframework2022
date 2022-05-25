package com.example.ejercicio24.aop;

import com.example.ejercicio24.model.Account;
import com.example.util.Color;
import com.example.util.IColorWriter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component("daoAccountLoggingAspect")
@Slf4j
public class DAOAccountLoggingAspect implements Ordered {

	private @Getter int order = 3;

	@Autowired
	private IColorWriter colorWriter;

	@Before("within(com.example.ejercicio24.dao..*) and args(yy, ..)")
	public void beforeDAOAccountMethodExecutionAccount(JoinPoint jp, Account yy) {

		Object[] args = jp.getArgs();

        log.info("{}",
                colorWriter.getColoredMessage(Color.RED,
                        String.format("Logging DAO Account access. Account: %s",
                                yy.getAccountNumber())));
    }
    
	@Before("within(com.example.ejercicio24.dao..*) and args(bb, ..)")
	public void beforeDAOAccountMethodExecutionLong(Long bb) {

		log.info("{}",
				colorWriter.getColoredMessage(Color.RED,
						String.format(
								"Logging DAO Account access. Customer Id: %s",
								bb)));
	}

}
