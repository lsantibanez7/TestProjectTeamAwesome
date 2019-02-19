package com.proj2.services;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj2.dao.UserDaoImpl;
import com.proj2.dao.WorksDaoImpl;
import com.proj2.exception.InvalidEmailException;
import com.proj2.exception.InvalidPasswordException;
import com.proj2.exception.InvalidUsernameException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.User;

public class UserServiceImpl implements UserService{

	
	
	public Object attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws SQLException, UserNotFoundException {
		
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

	@Override
	public Object register(HttpServletRequest request, HttpServletResponse response) {
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final String email = request.getParameter("email");
		
		request.getSession().setAttribute("username", username);
		
		boolean outcome;
		try {
			outcome = UserDaoImpl.getInstance().insertUserB(username, password, email);
			if(outcome == true) {
				User setUser;
				try {
					
					setUser = UserDaoImpl.getInstance().getUser(username);
					request.getSession().setAttribute("id", setUser.getId());
					return true;
				} catch (UserNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (InvalidUsernameException | InvalidPasswordException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public Object viewSavedWork(HttpServletRequest request, HttpServletResponse response) {
		String obj = (String)request.getSession().getAttribute("username");
		
		try {
			User view = UserDaoImpl.getInstance().getUser(obj);
			return WorksDaoImpl.getWoDa().getWorks(view.getId());
		} catch (UserNotFoundException e) {

			e.printStackTrace();
		}
		
		System.out.println("returned null for viewSavedWork in UserServiceImpl");
		return null;
	}

	@Override
	public Object saveArtwork(HttpServletRequest request, HttpServletResponse response) {
		String obj = (String)request.getSession().getAttribute("username");
		final int api_id = Integer.parseInt(request.getParameter("api_id"));
		final String comment = request.getParameter("comment");
		
		
		return WorksDaoImpl.getWoDa().saveWorks(obj, api_id, comment);
	}

	@Override
	public Object updateEmail(HttpServletRequest request, HttpServletResponse response) {
		String obj = (String)request.getSession().getAttribute("username");
		final String newEmail = request.getParameter("email");
		
		try {
			return UserDaoImpl.getInstance().updateEmail(obj, newEmail);
		} catch (UserNotFoundException | InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("null was returned for update email");
		return null;
	}

	@Override
	public Object updateUsername(HttpServletRequest request, HttpServletResponse response) {
		String obj = (String)request.getSession().getAttribute("username");
		final String newUsername = request.getParameter("newUsername");
		
		try {
			return UserDaoImpl.getInstance().updateUsername(obj, newUsername);
		} catch (UserNotFoundException | InvalidUsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("null was returned for updateusername");
		return null;
	}

	@Override
	public Object updatePassword(HttpServletRequest request, HttpServletResponse response) {
		String obj = (String)request.getSession().getAttribute("username");		
		final String newPassword = request.getParameter("newPassword");
		
		try {
			return UserDaoImpl.getInstance().updatePassword(obj, newPassword);
		} catch (UserNotFoundException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("returned null for updatePassword");
		return null;

	}

	@Override
	public Object updatePrivilegesToAdmin(HttpServletRequest request, HttpServletResponse response) {
		String obj = request.getParameter("username");
		try {
		
			return UserDaoImpl.getInstance().updatePrivilegesToAdmin(obj);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Object deleteUser(HttpServletRequest request, HttpServletResponse response) {
		String obj = request.getParameter("username");
		
		return UserDaoImpl.getInstance().deleteUser(obj);
	}

	@Override
	public Object updatePrivilegesToUser(HttpServletRequest request, HttpServletResponse response) {
		String obj = request.getParameter("username");
		
		try {
			return UserDaoImpl.getInstance().updatePrivilegesToUser(obj);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

		
}
