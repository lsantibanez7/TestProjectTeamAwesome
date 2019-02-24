package com.proj2.util;


import java.util.HashMap;
import java.util.Map;

import com.proj2.dao.UserDaoImpl;
import com.proj2.dao.WorksDaoImpl;

public class Debug {
	
	
	
	public static void main(String[] args) {
 
		int i = UserDaoImpl.getInstance().getUserCount(); 
		System.out.println(i + " users total");

		Map<Integer, Integer> userCountData = WorksDaoImpl.getWoDa().getCountOfWorksSavedByEachUser();		
		for(Integer key : userCountData.keySet()) {
			System.out.println("User id: " + key + " saved " + userCountData.get(key) + " images.");
		}
		
		Map<String, Integer> userCountDataU = WorksDaoImpl.getWoDa().getCountOfWorksSavedByEachUserReturnsUsername();		
		for(String key : userCountDataU.keySet()) {
			System.out.println("User id: " + key + " saved " + userCountDataU.get(key) + " images.");
		}
		
		Map<Integer, Integer> worksCountData = WorksDaoImpl.getWoDa().getCountOfUsersWhoSavedWorks();		
		for(Integer key : worksCountData.keySet()) {
			System.out.println("Works id: " + key + " was saved by " + worksCountData.get(key) + " users.");
		}

		
		
//		try {
//			User u1 = UserDaoImpl.getInstance().insertUser("test1", "pass1", "test1@test.edu");
//			User u2 = UserDaoImpl.getInstance().insertUser("test2", "pass2", "test1@test.edu");
//			User u3 = UserDaoImpl.getInstance().insertUser("test3", "pass3", "test1@test.edu");
//			UserDaoImpl.getInstance().updateEmail("test2", "test2@test.edu");
//			UserDaoImpl.getInstance().updateEmail("test3", "test3@test.edu");
//			
//			
//		} catch (UserNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidEmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidUsernameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
