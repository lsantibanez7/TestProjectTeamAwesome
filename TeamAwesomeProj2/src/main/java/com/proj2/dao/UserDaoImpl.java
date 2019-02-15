package com.proj2.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.proj2.exception.PrivilegesNotFoundException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.User;
import com.proj2.util.JDBSCConnectionUtil;


public class UserDaoImpl implements UserDao {
<<<<<<< HEAD:TeamAwesomeProj2/src/main/java/com/proj2/dao/UserDaoImpl.java
=======
	
	private static UserDaoImpl usDa;
	
	public static UserDaoImpl getUsDa() {
		if(usDa == null) {
			usDa = new UserDaoImpl();
		}
		
		return usDa;
	}
>>>>>>> 60f649db49e09bc717f1272084f902345bfdff29:TeamAwesomeProj2/src/main/java/com/proj2/dao/UserDaoImpl.java

	public int authenticateLogIn(String username, String password) {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			String sql = "{? = call authenticate_login(?,?)}";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.registerOutParameter(1, Types.NUMERIC);
			ps.executeUpdate();
<<<<<<< HEAD:TeamAwesomeProj2/src/main/java/com/proj2/dao/UserDaoImpl.java
			return ps.getInt(1);			
=======
			
			return ps.getInt(1);
			

>>>>>>> 60f649db49e09bc717f1272084f902345bfdff29:TeamAwesomeProj2/src/main/java/com/proj2/dao/UserDaoImpl.java
		} catch (SQLException e) {
			e.getSQLState();
			e.getErrorCode();
			e.printStackTrace();
		}
		return 0;
	}


	public void logOut(String username) {
		// TODO Auto-generated method stub
		
	}

	//changed to String instead of User object.
	public void insertUser(String usr, String password, String privaleges) throws SQLException {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			String sql = "{? = call ta_insert_user(?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(2, usr);
			cs.setString(3, password);
			cs.setString(4, privaleges);
			
			cs.registerOutParameter(1, Types.NUMERIC);
			
			cs.executeUpdate();
			
		} catch (SQLException e) {
			e.getSQLState();
			e.getErrorCode();
			e.printStackTrace();		}
	}
	

	public User getUser(String username) throws SQLException, PrivilegesNotFoundException, UserNotFoundException {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			
			String sql = "Select * from ta_user WHERE ta_user_username = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet results = stmt.executeQuery();
			while(results.next()) {
				
				return new User(
						results.getInt("TA_USER_ID"),
						results.getString("TA_USER_USERNAME"),
						results.getString("TA_USER_PRIVILEGES"),
						results.getString("TA_USER_EMAIL"));
			}	
		} catch (SQLException e) {
			e.getSQLState();
			e.getErrorCode();
			e.printStackTrace();
		}
		System.out.println("returned null in getUser call");
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
			e.getSQLState();
			e.getErrorCode();
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public void deleteUser(String username) throws SQLException {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			String sql = "EXEC ta_user_delete(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.getSQLState();
			e.getErrorCode();
			e.printStackTrace();		}
	}

}
