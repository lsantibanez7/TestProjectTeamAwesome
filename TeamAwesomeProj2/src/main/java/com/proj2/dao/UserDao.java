package com.proj2.dao;

import java.util.List;

import com.proj2.exception.IncorrectPasswordException;
import com.proj2.exception.InvalidEmailException;
import com.proj2.exception.InvalidPasswordException;
import com.proj2.exception.InvalidUsernameException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.User;



public interface UserDao {
	
	// ACCESS methods
	public int authenticateLogIn(String username, String password) throws UserNotFoundException, IncorrectPasswordException; // 100%; tested
	//public User logIn(String username, String password); // 0%

	// CREATE methods
	public boolean insertUserB(String username, String password, String email) throws InvalidUsernameException, InvalidPasswordException; // 100%; untested 
	public User insertUser(String username, String password, String email) throws InvalidUsernameException, InvalidPasswordException; // 100%; tested
	
	// READ methods
	public User getUser(String username) throws UserNotFoundException; // 100%, tested
	public List<User> getUserAll();	// 100%, untested

	// UPDATE methods
	public boolean updateUser(String username, User user) throws UserNotFoundException, InvalidUsernameException; // 100% untested 
	public boolean updateUsername(String username, String newUsername) throws UserNotFoundException, InvalidUsernameException; // 100% untested 
	public boolean updatePassword(String username, String newPassword) throws UserNotFoundException, InvalidPasswordException; // 100% untested
	public boolean updateVerifyPassword(String username, String oldPassword, String newPassword) throws UserNotFoundException, IncorrectPasswordException, InvalidPasswordException; // 100% tested
	public boolean updatePrivilegesToUser(String username) throws UserNotFoundException; // 100% untested
	public boolean updatePrivilegesToAdmin(String username) throws UserNotFoundException; // 100% untested
	public boolean updateEmail(String username, String email) throws UserNotFoundException, InvalidEmailException; // 100% untested 

	// DELETE methods
	public boolean deleteUser(String username); // 100% untested

}
