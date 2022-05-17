package com.jss.user.exception;

<<<<<<< HEAD
public class InvalidCredentialsException extends RuntimeException{
private String message;

public InvalidCredentialsException() {

this.message = "";
}
public InvalidCredentialsException(String message) {

this.message = message;
}

@Override
public String toString() {
return "Invalid Credentials :" +this.message;
}



}
=======
public class InvalidCredentialsException extends RuntimeException{	
private String message;
	
	public InvalidCredentialsException() {
		
		this.message = "";
	}
	public InvalidCredentialsException(String message) {
	
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Invalid Credentials :" +this.message;
	}
	

}
>>>>>>> 6f7cb3ab16923e483dc125fe07140f96e5b3e14a
