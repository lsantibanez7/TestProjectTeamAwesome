package com.proj2.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

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
	public boolean saveWorks(String username, int api_id, String comment) {
		try(Connection conn = JDBSCConnectionUtil.getConnection()){
			
			CallableStatement cs = conn.prepareCall("{?=call ta_insert_works(?,?,?)"); 
			cs.setString(2, username);
			cs.setInt(3, api_id);
			cs.setString(4, comment);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false; 
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
						results.getInt("ta_works_api_id"),
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
						results.getInt("ta_works_api_id"),
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
	public boolean updateComment(String comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWorks(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}