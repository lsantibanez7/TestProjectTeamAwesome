package com.proj2.dao;

import java.sql.SQLException;
import java.util.List;

import com.proj2.exception.PrivilegesNotFoundException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.User;



public interface UserDao {
	
	// ACCESS methods
	public int authenticateLogIn(String username, String password) throws UserNotFoundException;
	//public User logIn(String username, String password); 

	// CREATE methods
	public boolean insertUser(String username, String password, String email) throws InvalidUsernameException, InvalidPasswordException;

	// READ methods
	public User getUser(String username) throws UserNotFoundException; 
	public List<User> getUserAll();	

	// UPDATE methods
	public boolean updateUser(String username, User user) throws UserNotFoundException, InvalidUsernameException; 
	public boolean updateUsername(String username, String newUsername); 
	public boolean updatePassword(String username, String newPassword) throws UserNotFoundException, InvalidPasswordException;  
	public boolean updatePrivilegesToUser(String username) throws UserNotFoundException;
	public boolean updatePrivilegesToAdmin(String username) throws UserNotFoundException; 
	public boolean updateEmail(String username, String email); 

	// DELETE methods
	public boolean deleteUser(String username) throws SQLException;

}
