package com.proj2.exception;

public class InvalidPasswordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3515580491712157457L;

	public InvalidPasswordException() {
		super(); 
	}
	
	public InvalidPasswordException(String error){
		super(error); 
	}
	
}
