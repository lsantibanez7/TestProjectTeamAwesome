package com.proj2.services;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj2.exception.UserNotFoundException;

public interface UserService {
	
	//Authentification and creating a new user
	Object attemptAuthentication(HttpServletRequest request, HttpServletResponse response)throws SQLException, UserNotFoundException;
	Object register(HttpServletRequest request, HttpServletResponse response);
	
	//Artwork saving, viewing, deleting and updating comments
	Object viewSavedWork(HttpServletRequest request, HttpServletResponse response);
	Object saveArtwork(HttpServletRequest request, HttpServletResponse response);
	
	
	//Updating/deleting users
	Object updateEmail(HttpServletRequest request, HttpServletResponse response);
	Object updateUsername(HttpServletRequest request, HttpServletResponse response);
	Object updatePassword(HttpServletRequest request, HttpServletResponse response);
	Object updatePrivilegesToUser(HttpServletRequest request, HttpServletResponse response);
	Object updatePrivilegesToAdmin(HttpServletRequest request, HttpServletResponse response);
	Object deleteUser(HttpServletRequest request, HttpServletResponse response);
}
