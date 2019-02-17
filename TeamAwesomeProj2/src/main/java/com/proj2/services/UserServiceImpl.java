package com.proj2.services;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj2.dao.UserDaoImpl;
import com.proj2.exception.PrivilegesNotFoundException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.User;

public class UserServiceImpl implements UserService{

	//private final DataSource dataSource = DataSource.getInstance();
	
	
	public User attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws SQLException, PrivilegesNotFoundException, UserNotFoundException {
		
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		
		System.out.println("LoginServiceImpl works for attemptAuthentication");
		
		int numret = UserDaoImpl.getInstance().authenticateLogIn(username, password);
		
		if(numret == 3) {
			User next = UserDaoImpl.getInstance().getUser(username);
			request.getSession().setAttribute("privileges", next.getPrivileges());
			request.getSession().setAttribute("username", next.getUsername());
			request.getSession().setAttribute("id", next.getId());
			return next;
		}else {
			return null;
		}
	}
	

		
}
