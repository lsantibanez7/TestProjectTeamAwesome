package com.proj2.dao;

import java.sql.SQLException;
import java.util.List;

import com.proj2.exception.PrivilegesNotFoundException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.User;


public class DaoImpl implements Dao {

	public int authenticateLogIn(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void logOut(String username) {
		// TODO Auto-generated method stub
		
	}

	public void insertUser(User usr, String password) throws SQLException {
		
	}

	public User getUser(String username) throws SQLException, PrivilegesNotFoundException, UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUserAll() throws SQLException, PrivilegesNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(String username) throws SQLException {
		// TODO Auto-generated method stub
	}

}
