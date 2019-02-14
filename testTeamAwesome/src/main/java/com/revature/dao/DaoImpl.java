package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.exception.PrivilegesNotFoundException;
import com.revature.exception.UserNotFoundException;
import com.revature.model.User;

public class DaoImpl implements Dao {

	public int authenticateLogIn(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void logOut(String username) {
		// TODO Auto-generated method stub
		
	}

	public void insertUser(User usr, String password) throws SQLException {
		
		return false;
	}

	public User getUser(String username) throws SQLException, PrivilegesNotFoundException, UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUserAll() throws SQLException, PrivilegesNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteUser(String username) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
