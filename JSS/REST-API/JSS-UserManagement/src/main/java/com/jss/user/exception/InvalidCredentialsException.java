package com.jss.user.exception;

public class InvalidCredentialsException extends RuntimeException {
	private String message;

	public InvalidCredentialsException() {

		this.message = "";
	}

	public InvalidCredentialsException(String message) {

		this.message = message;
	}

	@Override
	public String toString() {
		return "Invalid Credentials :" + this.message;
	}

}
