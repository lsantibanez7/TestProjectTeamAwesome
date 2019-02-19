package com.proj2.exception;

public class UserNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7390411681290532153L;
	
		public UserNotFoundException(String e) {
			super(e); 
		}
	
		public UserNotFoundException() {
			super(); 
		}
}
