package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.exception.PrivilegesNotFoundException;
import com.revature.exception.UserNotFoundException;
import com.revature.model.User;


public interface Dao {
	
	// ACCESS methods
	public int authenticateLogIn(String username, String password); 
	public void logOut(String username);
	
	// CREATE methods
	public void insertUser(User usr, String password) throws SQLException;
	
	// READ methods
	public User getUser(String username) throws SQLException, PrivilegesNotFoundException, UserNotFoundException; 
	public List<User> getUserAll() throws SQLException, PrivilegesNotFoundException;	
		
	// DELETE methods
	public void deleteUser(String username) throws SQLException;
	
}
