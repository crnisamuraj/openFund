package com.merkaba.samurai.util.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions (Exception ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse =
				new ExceptionResponse(new Date(), ex.getMessage(),
						request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.I_AM_A_TEAPOT);
	}
	
	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<Object> handleCustomException (CustomException ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse =
				new ExceptionResponse(new Date(), ex.getMessage(),
						request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, ex.gethStatus());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){
		ExceptionResponse exceptionResponse =
				new ExceptionResponse(new Date(), "Data Validation failed.",
						ex.getBindingResult().getFieldErrors().toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	
}
