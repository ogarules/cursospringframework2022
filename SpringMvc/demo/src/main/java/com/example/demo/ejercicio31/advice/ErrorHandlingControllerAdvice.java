package com.example.demo.ejercicio31.advice;

import com.example.demo.ejercicio31.controller.PersonsController;
import com.example.demo.ejercicio31.controller.PersonsRestController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes={PersonsController.class, PersonsRestController.class})
public class ErrorHandlingControllerAdvice {

	// Anotar ExceptionHandler
	@ExceptionHandler(RuntimeException.class)
	// Anotar Response status (internal server error)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	// Anotar ResponseBody
	@ResponseBody
	public RestResponseError onException(RuntimeException re) {
		return new RestResponseError(HttpStatus.INTERNAL_SERVER_ERROR, 
				re.getMessage(), 
				re.getClass().getSimpleName());
	}

}
