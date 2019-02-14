package com.proj2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proj2.exception.PrivilegesNotFoundException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.User;
import com.proj2.util.JDBSCConnectionUtil;


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
		System.out.println("getAllUsers is called properly");
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			
			String sql = "select * from ta_user";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			
			ResultSet results = stmt.executeQuery();
			
			List<User> allUsers = new ArrayList<>();
			while(results.next()) {
				allUsers.add(new User(
						results.getInt("TA_USER_ID"),
						results.getString("TA_USER_USERNAME"),
						results.getString("TA_USER_PRIVILEGES"),
						results.getString("TA_USER_EMAIL"))
						);
			}
			return allUsers;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public void deleteUser(String username) throws SQLException {
		// TODO Auto-generated method stub
	}

}
