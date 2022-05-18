package com.jss.jobseeker.exception;

public class InvalidJobSeekerException extends RuntimeException {
	private String message;

	public InvalidJobSeekerException() {
		this.message = "";
	}

	public InvalidJobSeekerException(String message) {

		this.message = message;
	}

	@Override
	public String toString() {
		return " : " + this.message;
	}
}
