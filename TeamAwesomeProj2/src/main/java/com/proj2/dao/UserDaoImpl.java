package com.proj2.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.proj2.exception.InvalidEmailException;
import com.proj2.exception.InvalidPasswordException;
import com.proj2.exception.InvalidUsernameException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.Privileges;
import com.proj2.model.User;
import com.proj2.util.JDBSCConnectionUtil;


public class UserDaoImpl implements UserDao {
	
	private static UserDaoImpl mInstance;
	
	private UserDaoImpl() {
		super(); 
	}
	
	public static UserDaoImpl getInstance() {
		if(mInstance == null) {
			mInstance = new UserDaoImpl();
		}
		
		return mInstance;
	}

	
	// ACCESS METHODS
	public int authenticateLogIn(String username, String password) {
		// Returns 3 for successful login; 2 for password missing, 1 for user not found, 0 for error
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			String sql = "{? = call authenticate_login(?,?)}";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.registerOutParameter(1, Types.NUMERIC);
			ps.executeUpdate();

			return ps.getInt(1);			
			
		} catch (SQLException e) {
			e.getSQLState();
			e.getErrorCode();
			e.printStackTrace();
		}
		return 0;
	}
	
	// CREATE METHODS 
	@Override
	public boolean insertUserB(String username, String password, String email)
			throws InvalidUsernameException, InvalidPasswordException {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			
			CallableStatement cs = conn.prepareCall("{?=call ta_insert_user(?,?,?,?)"); 
			cs.setString(2, username);
			cs.setString(3, password);
			cs.setString(4, Privileges.USER.name());
			cs.setString(5, email);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false; 
		}
	}

	@Override
	public User insertUser(String username, String password, String email)
			throws InvalidUsernameException, InvalidPasswordException {

		long tic = System.currentTimeMillis();
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			System.out.println("Time to connect: " + (System.currentTimeMillis()-tic) + "ms");
			CallableStatement cs = conn.prepareCall("{?=call ta_insert_user(?,?,?,?)}"); 
			System.out.println("Time to prepare call: " + (System.currentTimeMillis()-tic) + "ms");
			cs.setString(2, username);
			cs.setString(3, password);
			cs.setString(4, "USER");
			cs.setString(5, email);
			cs.registerOutParameter(1, Types.NUMERIC);
			System.out.println("Time to set up parameters " + (System.currentTimeMillis()-tic) + "ms");
			cs.executeUpdate();
			System.out.println("Time to execute update: " + (System.currentTimeMillis()-tic) + "ms");
			return new User(
					cs.getInt(1), 
					username, 
					Privileges.USER, 
					email 
					);
		} catch (SQLException e) {
			e.printStackTrace();
			return null; 
		}
	}
	
	public User getUser(String username) throws UserNotFoundException {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			
			String sql = "Select * from ta_user WHERE ta_user_username = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet results = stmt.executeQuery();
			while(results.next()) {
				
				return new User(
						results.getInt("TA_USER_ID"),
						results.getString("TA_USER_USERNAME"),
						Privileges.valueOf(results.getString("TA_USER_PRIVILEGES")),
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

	public List<User> getUserAll() {
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
						Privileges.valueOf(results.getString("TA_USER_PRIVILEGES")),
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

	@Override
	public boolean updateUser(String username, User user) throws UserNotFoundException, InvalidUsernameException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUsername(String username, String newUsername)
			throws UserNotFoundException, InvalidUsernameException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePassword(String username, String newPassword)
			throws UserNotFoundException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePrivilegesToUser(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePrivilegesToAdmin(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmail(String username, String email) throws UserNotFoundException, InvalidEmailException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(String username) {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			System.out.println("Preparing to delete..");
			String sql = "{call ta_user_delete(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, username);
			cs.execute();
			System.out.println("Deleted successfully");
			return true; 
		} catch (SQLException e) {
			e.getSQLState();
			e.getErrorCode();
			e.printStackTrace();		
			}
		return false;
	}
}
