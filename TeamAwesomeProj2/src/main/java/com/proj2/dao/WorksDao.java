package com.proj2.dao;

import com.proj2.model.Works;

public interface WorksDao {

	// CREATE methods
	public void saveWorks(String username, int api_id, String comment); 
	
	// READ methods
	public Works getWorks(int id);
	
	// UPDATE methods
	public void updateComment(String comment); 
	
	// DELETE methods
	public void deleteWorks(int id); 
}
