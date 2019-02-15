package com.proj2.dao;

import java.sql.SQLException;
import java.util.List;

import com.proj2.exception.PrivilegesNotFoundException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.User;



public interface UserDao {
	
	// ACCESS methods
	public int authenticateLogIn(String username, String password);
	//public User logIn(String username, String password); 
	
	// CREATE methods
	public void insertUser(String usr, String password, String privalages) throws SQLException;
	
	// READ methods
	public User getUser(String username) throws SQLException, PrivilegesNotFoundException, UserNotFoundException; 
	public List<User> getUserAll() throws SQLException, PrivilegesNotFoundException;	
		
	// DELETE methods
	public void deleteUser(String username) throws SQLException;

}
