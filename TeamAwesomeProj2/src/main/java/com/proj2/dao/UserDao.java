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
	public void insertUser(String username, String password) throws InvalidUsernameException, InvalidPasswordException;
	
	// READ methods
	public User getUser(String username) throws UserNotFoundException; 
	public List<User> getUserAll();	
	
	// UPDATE methods
	public void updateUser(String username, User user) throws UserNotFoundException, InvalidUsernameException; 
	public void updateUsername(String username, String newUsername) throws UserNotFoundException, InvalidUsernameException; 
	public void updatePassword(String username, String newPassword) throws UserNotFoundException, InvalidPasswordException;  
	public void updatePrivilegesToUser(String username) throws UserNotFoundException;
	public void updatePrivilegesToAdmin(String username) throws UserNotFoundException; 
	public void updateEmail(String username, String email) throws UserNotFoundException, InvalidEmailException; 
	
	// DELETE methods
	public void deleteUser(String username) throws SQLException;
	
}
