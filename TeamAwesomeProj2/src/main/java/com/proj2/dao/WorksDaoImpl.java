package com.proj2.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.proj2.exception.UserNotFoundException;
import com.proj2.model.Works;
import com.proj2.util.JDBSCConnectionUtil;

public class WorksDaoImpl implements WorksDao{

	private static WorksDaoImpl getWo; 
	
	public static WorksDaoImpl getWoDa() {
		if(getWo == null) {
			getWo = new WorksDaoImpl(); 
		}
		return getWo; 
	}
	
	@Override
	public boolean saveWorksB(String api_id, String comment, int userId) {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			
			CallableStatement cs = conn.prepareCall("{?=call ta_insert_works(?,?,?)"); 
			cs.setString(2, api_id);
			cs.setString(3, comment);
			cs.setInt(4, userId);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false; 
		}
	}
	
	@Override
	public Works saveWorks(String api_id, String comment, int userId) {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			
			CallableStatement cs = conn.prepareCall("{?=call ta_insert_works(?,?,?)"); 
			cs.setString(2, api_id);
			cs.setString(3, comment);
			cs.setInt(4, userId);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.executeUpdate();
			return new Works(
					cs.getInt(1), 
					api_id, 
					comment, 
					userId 
					);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null; 
		}
	}

	@Override
	public Works getWorks(int id) {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ta_works WHERE ta_works_id = ?"); 
			ps.setInt(1, id);
			
			ResultSet results = ps.executeQuery();
			while(results.next()) {
				return new Works(
						results.getInt("ta_works_id"),
						results.getString("ta_works_api_id"),
						results.getString("ta_works_comment"),
						results.getInt("ta_works_user_id")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return null; 
	}

	@Override
	public List<Works> getWorksAll() {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ta_works";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet results = ps.executeQuery();
			
			List<Works> allWorks = new ArrayList<>();
			while(results.next()) {
				allWorks.add(new Works(
						results.getInt("ta_works_id"),
						results.getString("ta_works_api_id"),
						results.getString("ta_works_comment"),
						results.getInt("ta_works_user_id"))
						); 
			}
			return allWorks;
			
		}catch(SQLException e) {
			e.getSQLState();
			e.getErrorCode();
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
	@Override
	public List<Works> getWorksUserByUsername(String username) throws UserNotFoundException{
		System.out.println("WARNING: getWorksAllByUser is more efficient when passing userID as a parameter instead"); 
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			String sqlUser = "SELECT ta_user_id FROM ta_user WHERE ta_user_username = ?"; 
			PreparedStatement psUser = conn.prepareStatement(sqlUser); 
			psUser.setString(1, username);
			ResultSet resultsUser = psUser.executeQuery();
			int userId = 0; 
			while(resultsUser.next()) userId = resultsUser.getInt("ta_user_id"); 
			if(userId == 0) throw new UserNotFoundException("User " + username + " not found.");  
			
			String sql = "SELECT * FROM ta_works WHERE ta_works_user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet results = ps.executeQuery();
			
			List<Works> allWorks = new ArrayList<>();
			while(results.next()) {
				allWorks.add(new Works(
						results.getInt("ta_works_id"),
						results.getString("ta_works_api_id"),
						results.getString("ta_works_comment"),
						results.getInt("ta_works_user_id"))
						); 
			}
			return allWorks;
			
		}catch(SQLException e) {
			e.getSQLState();
			e.getErrorCode();
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public List<Works> getWorksUserById(int userId) throws UserNotFoundException{
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ta_works WHERE ta_works_user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1,userId);


			ResultSet results = ps.executeQuery();
			
			List<Works> allWorks = new ArrayList<>();
			while(results.next()) {
				allWorks.add(new Works(
						results.getInt("ta_works_id"),
						results.getString("ta_works_api_id"),
						results.getString("ta_works_comment"),
						results.getInt("ta_works_user_id"))
						); 
			}
			return allWorks;
			
		}catch(SQLException e) {
			e.getSQLState();
			e.getErrorCode();
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	
	@Override
	public boolean updateComment(int id, String comment) {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			String sql = "call ta_works_update_comment(?)"; 
			CallableStatement cs = conn.prepareCall(sql); 
			cs.execute(); 
			return true; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteWorks(int id) {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			String sql = "call ta_works_delete(?)"; 
			CallableStatement cs = conn.prepareCall(sql); 
			cs.execute(); 
			return true; 
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false; 
	}

	@Override
	public int getWorksCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<Integer, Integer> getCountOfWorksSavedByEachUser() {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			String sql = "SELECT ta_user_id, COUNT(*) " +  
				    "FROM ta_works JOIN ta_user ON ta_works_user_id = ta_user_id " + 
				    "GROUP BY ta_user_id";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet results = stmt.executeQuery();
			Map<Integer, Integer> worksCount = new HashMap<>();
			while(results.next()) {
				worksCount.put(results.getInt(1), results.getInt(2)); 
			}
			return worksCount;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	//use this one
	@Override
	public Map<String, Integer> getCountOfWorksSavedByEachUserReturnsUsername() {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			String sql = "SELECT ta_user_username, COUNT(*) " +  
				    "FROM ta_works JOIN ta_user ON ta_works_user_id = ta_user_id " + 
				    "GROUP BY ta_user_username";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet results = stmt.executeQuery();
			Map<String, Integer> worksCount = new HashMap<>();
			while(results.next()) {
				worksCount.put(results.getString(1), results.getInt(2)); 
			}
			return worksCount;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	
	//popularity
	@Override
	public Map<Integer, Integer> getCountOfUsersWhoSavedWorks() {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			String sql = "SELECT ta_works_api_id, COUNT(*) " + 
				    "FROM ta_works JOIN ta_user ON ta_works_user_id = ta_user_id " +
				    "GROUP BY ta_works_api_id "; 
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet results = stmt.executeQuery();
			Map<Integer, Integer> userCount = new HashMap<>();
			while(results.next()) {
				userCount.put(results.getInt(1), results.getInt(2)); 
			}
			return userCount;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}