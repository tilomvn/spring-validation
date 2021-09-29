package com.spring.validation.config;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	ResponseEntity<?> handleValidationExceptions(ConstraintViolationException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getConstraintViolations().forEach(error -> {
	    	ConstraintViolationImpl violation = (ConstraintViolationImpl) error;
	    	errors.put(violation.getPropertyPath().toString(), violation.getMessage());
	    });
	    return ResponseEntity.badRequest().body(errors);
	}
}
