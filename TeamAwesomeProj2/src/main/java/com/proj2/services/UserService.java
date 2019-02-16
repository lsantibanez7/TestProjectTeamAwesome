package com.proj2.services;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj2.exception.PrivilegesNotFoundException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.User;
import com.proj2.model.Works;

public interface UserService {
	
	Object attemptAuthentication(HttpServletRequest request, HttpServletResponse response)throws SQLException, PrivilegesNotFoundException, UserNotFoundException;
	Object register(HttpServletRequest request, HttpServletResponse response);
	Object viewSavedWork(HttpServletRequest request, HttpServletResponse response);
	Object saveArtwork(HttpServletRequest request, HttpServletResponse response);
	

}
