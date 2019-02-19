package com.proj2.dao;

import java.util.List;

import com.proj2.exception.UserNotFoundException;
import com.proj2.model.Works;

public interface WorksDao {

	// CREATE methods
	public boolean saveWorks(String username, int apiId, String comment); // 100% untested
	
	// READ methods
	public Works getWorks(int id); // 100% untested
	public List<Works> getWorksAll(); // 100% untested
	public List<Works> getWorksAllByUser(String username) throws UserNotFoundException; // 100% untested
	public List<Works> getWorksAllByUser(int userId) throws UserNotFoundException; // 100% untested
	
	// UPDATE methods
	public boolean updateComment(int id, String comment); // 100% untested
	
	// DELETE methods
	public boolean deleteWorks(int id); //100% untested

}
