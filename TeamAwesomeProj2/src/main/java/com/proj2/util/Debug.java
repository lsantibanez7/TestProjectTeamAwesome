package com.proj2.util;


import java.util.List;

import com.proj2.dao.UserDaoImpl;
import com.proj2.exception.InvalidPasswordException;
import com.proj2.exception.InvalidUsernameException;
import com.proj2.model.User;

public class Debug {
	
	
	
	public static void main(String[] args) {
		try {
			User u1 = UserDaoImpl.getInstance().insertUser("test1", "pass1", "test1@test.edu");
			User u2 = UserDaoImpl.getInstance().insertUser("test2", "pass2", "test1@test.edu");
			User u3 = UserDaoImpl.getInstance().insertUser("test3", "pass3", "test1@test.edu");
			
			List<User> uAll = UserDaoImpl.getInstance().getUserAll();
			
			for(User ui : uAll) {
				System.out.println(ui.toStringF()); 
			}
			
			UserDaoImpl.getInstance().deleteUserById(u1.getId()); 
			UserDaoImpl.getInstance().deleteUserById(u2.getId()); 
			UserDaoImpl.getInstance().deleteUserById(u3.getId()); 
			
			
		} catch (InvalidUsernameException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	try {
//		User u = UserDaoImpl.getInstance().insertUser("test1", "test1pass", "username1@uname.edu");
//		int auth1 = UserDaoImpl.getInstance().authenticateLogIn("test1", "test1-altered-password");
//		UserDaoImpl.getInstance().updateVerifyPassword("test1", "test1pass", "test1-altered-password"); 
//		int auth2 = UserDaoImpl.getInstance().authenticateLogIn("test1", "test1-altered-password"); 
//		UserDaoImpl.getInstance().deleteUser("test1"); 
//		System.out.println("Run successfully");
//	} catch (InvalidUsernameException e) {
//		System.err.println("Invalid Username Exception"); 
//	} catch (InvalidPasswordException e) {
//		System.err.println("Invalid Password Exception");
//	} catch (UserNotFoundException e) {
//		System.err.println("User Not Found Exception"); 
//	} catch (IncorrectPasswordException e) {
//		System.err.println("Incorrect Password Exception"); 
//	}
	
	
}
