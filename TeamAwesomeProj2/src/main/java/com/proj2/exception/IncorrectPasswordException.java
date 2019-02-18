package com.proj2.exception;

public class IncorrectPasswordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3660613892836110554L;

	public IncorrectPasswordException(String e) {
		super(e); 
	}
	
	public IncorrectPasswordException() {
		super(); 
	}
	
}
