package com.jss.employee.exception;

public class DataNotFoundException extends RuntimeException{
	
	private String message;

	public DataNotFoundException() {

		this.message = "";
	}

	public DataNotFoundException(String message) {

		this.message = message;
	}

	@Override
	public String toString() {
		return "Data Not Found :" + this.message;
	}

}
