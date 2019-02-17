package com.proj2.util;

import com.proj2.dao.UserDaoImpl;
import com.proj2.exception.InvalidPasswordException;
import com.proj2.exception.InvalidUsernameException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.User;

public class Debug {
	
	
	
	public static void main(String[] args) {

		try {
			User u = UserDaoImpl.getInstance().insertUser("test1", "test1pass", "username@uname.edu");
			System.out.println(u.toStringF());
			UserDaoImpl.getInstance().deleteUser("test1"); 
			User u2 = UserDaoImpl.getInstance().getUser(u.getUsername()); 
			System.out.println(u2 == null); 
		} catch (InvalidUsernameException | InvalidPasswordException | UserNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
