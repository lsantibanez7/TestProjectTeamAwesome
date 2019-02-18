package com.proj2.util;


import com.proj2.dao.UserDaoImpl;
import com.proj2.exception.IncorrectPasswordException;
import com.proj2.exception.InvalidPasswordException;
import com.proj2.exception.InvalidUsernameException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.User;

public class Debug {
	
	
	
	public static void main(String[] args) {
		try {
			User u = UserDaoImpl.getInstance().insertUser("test1", "test1pass", "username1@uname.edu");
			int auth1 = UserDaoImpl.getInstance().authenticateLogIn("test1", "test1-altered-password");
			UserDaoImpl.getInstance().updateVerifyPassword("test1", "test1pass", "test1-altered-password"); 
			int auth2 = UserDaoImpl.getInstance().authenticateLogIn("test1", "test1-altered-password"); 
			UserDaoImpl.getInstance().deleteUser("test1"); 
			System.out.println("Run successfully");
		} catch (InvalidUsernameException e) {
			System.err.println("Invalid Username Exception"); 
		} catch (InvalidPasswordException e) {
			System.err.println("Invalid Password Exception");
		} catch (UserNotFoundException e) {
			System.err.println("User Not Found Exception"); 
		} catch (IncorrectPasswordException e) {
			System.err.println("Incorrect Password Exception"); 
		}
	}
	
	
}
