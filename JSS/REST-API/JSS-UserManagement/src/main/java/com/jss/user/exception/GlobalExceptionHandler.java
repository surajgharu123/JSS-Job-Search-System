package com.jss.user.exception;
<<<<<<< HEAD
=======

>>>>>>> 6f7cb3ab16923e483dc125fe07140f96e5b3e14a
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

<<<<<<< HEAD


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

@ExceptionHandler(value = InvalidCredentialsException.class)
public ResponseEntity<Object> handleConflict(RuntimeException exception , WebRequest request){
String errorMessage="{\"error\":"+exception.toString() + " \"}";
ResponseEntity<Object> response=
handleExceptionInternal(exception,errorMessage,new HttpHeaders(),HttpStatus.CONFLICT, request);
return response;
}
}
=======
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = InvalidCredentialsException.class)
	public ResponseEntity<Object> handleConflict(RuntimeException exception , WebRequest request){
		String errorMessage="{\"error\":"+exception.toString() + " \"}";
		ResponseEntity<Object> response=
				handleExceptionInternal(exception,errorMessage,new HttpHeaders(),HttpStatus.CONFLICT, request);
		return response;
	}
}
>>>>>>> 6f7cb3ab16923e483dc125fe07140f96e5b3e14a
