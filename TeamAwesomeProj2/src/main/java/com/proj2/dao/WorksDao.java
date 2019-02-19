package com.proj2.dao;

import java.util.List;

import com.proj2.model.Works;

public interface WorksDao {

	// CREATE methods
	public boolean saveWorks(String username, int api_id, String comment); 
	
	// READ methods
	public Works getWorks(int id);
	public List<Works> getWorksAll(); 
	
	// UPDATE methods
	public boolean updateComment(String comment); 
	
	// DELETE methods
	public boolean deleteWorks(int id); 
}
