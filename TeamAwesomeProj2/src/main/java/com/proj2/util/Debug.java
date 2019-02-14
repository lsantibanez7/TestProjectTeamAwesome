package com.proj2.util;

import java.sql.SQLException;

import com.proj2.dao.Dao;
import com.proj2.dao.DaoImpl;
import com.proj2.model.Privileges;
import com.proj2.model.User;

public class Debug {
	
	
	public static void main(String[] args) {
		Dao myDao = new DaoImpl(); 
		User user1 = new User(0, "test-user-java4", "GUEST", null);
		User user2 = new User(0, "test-user-java5", "GUEST", null);
		User user3 = new User(0, "test-user-java6", "GUEST", null);
//		
//		System.out.println("tryna make users");
//		try {
//			myDao.insertUser(user1.getUsername(), "java1pass", user1.getPrivileges());
//			myDao.insertUser(user2.getUsername(), "java2pass", user2.getPrivileges());
//			myDao.insertUser(user3.getUsername(), "java3pass", user3.getPrivileges());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("This equals 3... " + myDao.authenticateLogIn("test-user-java4", "java1pass"));
		System.out.println("This equals 2... " + myDao.authenticateLogIn("test-user-java5", "java10pass"));
		System.out.println("This equals 1... " + myDao.authenticateLogIn("test-user-bjslka;jb", "java3pass"));
		
	}
	
}
