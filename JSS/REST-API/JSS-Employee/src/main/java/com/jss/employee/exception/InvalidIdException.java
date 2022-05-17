package com.jss.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidIdException extends RuntimeException {
	private String message;

	public InvalidIdException() {

		this.message = "";
	}

	public InvalidIdException(String message) {

		this.message = message;
	}

	@Override
	public String toString() {
		return "Invalid Credentials :" + this.message;
	}

}
