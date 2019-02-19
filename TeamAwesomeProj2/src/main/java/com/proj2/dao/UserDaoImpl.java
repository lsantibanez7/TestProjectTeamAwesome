package com.proj2.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.proj2.exception.IncorrectPasswordException;
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
			String sql = "{?=call ta_insert_user(?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql); 
			cs.setString(2, username);
			cs.setString(3, password);
			cs.setString(4, "USER");
			cs.setString(5, email);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.executeUpdate(); 
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
			
			String sql = "SELECT * FROM ta_user WHERE ta_user_username = ?";
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
		throw new UserNotFoundException("Username not found");
	}

	public List<User> getUserAll() {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ta_user";
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

	//////////////////////////// UPDATE METHODS ////////////////////////////////
	
	@Override
	public boolean updateUser(String username, User user) throws UserNotFoundException, InvalidUsernameException {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){ 
			String sql = "call ta_user_update(?,?,?,?)"; 
			CallableStatement cs = conn.prepareCall(sql); 
			cs.setString(1,  username);
			cs.setString(2, user.getUsername());
			cs.setString(3, user.getPrivileges().name());
			cs.setString(4, user.getEmail());
			cs.execute();  
			return true; 
		} catch (SQLException e) {
			return false; 
		}
	}

	@Override
	public boolean updateUsername(String username, String newUsername)
			throws UserNotFoundException, InvalidUsernameException {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){ 
			String sql = "call ta_user_update_username(?,?)"; 
			CallableStatement cs = conn.prepareCall(sql); 
			cs.setString(1,  username);
			cs.setString(2, newUsername);
			cs.execute();  
			return true; 
		} catch (SQLException e) {
			return false; 
		}
	}

	@Override
	public boolean updatePassword(String username, String newPassword)
			throws UserNotFoundException, InvalidPasswordException {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){ 
			String sql = "call ta_user_update_password(?,?)"; 
			CallableStatement cs = conn.prepareCall(sql); 
			cs.setString(1,  username);
			cs.setString(2, newPassword);
			cs.execute();  
			return true; 
		} catch (SQLException e) {
			return false; 
		}
	}
	
	@Override
	public boolean updateVerifyPassword(String username, String oldPassword, String newPassword)
			throws UserNotFoundException, IncorrectPasswordException, InvalidPasswordException{
		try(Connection conn = JDBSCConnectionUtil.getConnection()){ 
			String sql = "{?=call ta_user_verify_update_password(?,?,?)}"; 
			CallableStatement cs = conn.prepareCall(sql); 
			cs.setString(2,  username);
			cs.setString(3, oldPassword);
			cs.setString(4, newPassword);
			cs.registerOutParameter(1,  Types.NUMERIC);
			cs.execute();  
			if(cs.getInt(1) == 0) {
				throw new IncorrectPasswordException("Password Not Found"); 
			}
			return true; 
		} catch (SQLException e) {
			return false; 
		}
	}

	@Override
	public boolean updatePrivilegesToUser(String username) throws UserNotFoundException {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){ 
			String sql = "call ta_user_update_privileges(?,?)"; 
			CallableStatement cs = conn.prepareCall(sql); 
			cs.setString(1,  username);
			cs.setString(2, Privileges.USER.name());
			cs.execute();  
			return true; 
		} catch (SQLException e) {
			return false; 
		}
	}

	@Override
	public boolean updatePrivilegesToAdmin(String username) throws UserNotFoundException {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){ 
			String sql = "call ta_user_update_privileges(?,?)"; 
			CallableStatement cs = conn.prepareCall(sql); 
			cs.setString(1,  username);
			cs.setString(2, Privileges.ADMIN.name());
			cs.execute();  
			return true; 
		} catch (SQLException e) {
			return false; 
		}
	}

	@Override
	public boolean updateEmail(String username, String email) throws UserNotFoundException, InvalidEmailException {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){ 
			String sql = "call ta_user_update_email(?,?)"; 
			CallableStatement cs = conn.prepareCall(sql); 
			cs.setString(1,  username);
			cs.setString(2, email);
			cs.execute();  
			return true; 
		} catch (SQLException e) {
			return false; 
		}
	}

	@Override
	public boolean deleteUser(String username) {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			String sql = "{call ta_user_delete(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, username);
			cs.execute();
			return true; 
		} catch (SQLException e) {
			e.getSQLState();
			e.getErrorCode();
			e.printStackTrace();		
			}
		return false;
	}
}