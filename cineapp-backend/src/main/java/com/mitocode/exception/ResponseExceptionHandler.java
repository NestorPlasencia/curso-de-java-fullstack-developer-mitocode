package com.mitocode.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ModeloNotFoundException.class)
	public final ResponseEntity<Object> manejarModeloExcepciones(ModeloNotFoundException ex, WebRequest request) {
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(er, HttpStatus.NOT_FOUND);
	}

}
