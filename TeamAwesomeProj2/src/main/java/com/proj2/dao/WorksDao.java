package com.proj2.dao;

import java.util.List;

import com.proj2.exception.UserNotFoundException;
import com.proj2.model.Works;

public interface WorksDao {

	// CREATE methods
		public boolean saveWorksB(String apiId, String comment, int userId); // 100% untested
		public Works saveWorks(String apiId, String comment, int userId); // 100% untested
		
		// READ methods
		public Works getWorks(int id); // 100% untested
		public List<Works> getWorksAll(); // 100% untested
		public List<Works> getWorksUserByUsername(String username) throws UserNotFoundException; // 100% untested
		public List<Works> getWorksUserById(int userId) throws UserNotFoundException; // 100% untested
		
		// UPDATE methods
		public boolean updateComment(int id, String comment); // 100% untested
		
		// DELETE methods
		public boolean deleteWorks(int id); //100% untested 
}
