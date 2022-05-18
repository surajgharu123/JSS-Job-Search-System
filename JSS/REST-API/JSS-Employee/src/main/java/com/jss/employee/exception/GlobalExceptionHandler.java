package com.jss.employee.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = DataNotFoundException.class)
	public ResponseEntity<Object> handleConflictDataNotFoundException(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\":" + exception.toString() + " \"}";
		ResponseEntity<Object> response = handleExceptionInternal(exception, errorMessage, new HttpHeaders(),
				HttpStatus.CONFLICT, request);
		return response;
	}
	
	
	
	@ExceptionHandler(value = InvalidIdException.class)
	public ResponseEntity<Object> handleConflictInvalidIdException(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\":" + exception.toString() + " \"}";
		ResponseEntity<Object> response = handleExceptionInternal(exception, errorMessage, new HttpHeaders(),
				HttpStatus.CONFLICT, request);
		return response;
	}
	
	@ExceptionHandler(value = InvalidAuthTokenException.class)
	public ResponseEntity<Object> handleInvalidAuthTokenException(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\":" + exception.toString() + " \"}";
		ResponseEntity<Object> response = handleExceptionInternal(exception, errorMessage, new HttpHeaders(),
				HttpStatus.CONFLICT, request);
		return response;
	}
	

}
