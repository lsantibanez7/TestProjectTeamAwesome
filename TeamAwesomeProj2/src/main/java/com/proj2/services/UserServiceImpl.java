package com.proj2.services;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proj2.dao.UserDaoImpl;
import com.proj2.dao.WorksDaoImpl;
import com.proj2.exception.InvalidEmailException;
import com.proj2.exception.InvalidPasswordException;
import com.proj2.exception.InvalidUsernameException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.User;
import com.proj2.model.Works;

public class UserServiceImpl implements UserService{

	private final ObjectMapper mapper = new ObjectMapper();
	
	
	public Object attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws SQLException, UserNotFoundException {
		
		 String username = "";
		 String password = "";
		
		try {
			User user = mapper.readValue(request.getReader(), User.class);
			username = user.getUsername();
			password = user.getPassword();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		
		System.out.println("LoginServiceImpl works for attemptAuthentication");
		
		System.out.println(username + " " + password);
		
		int numret = UserDaoImpl.getInstance().authenticateLogIn(username, password);
		
		System.out.println(numret);
		
		if(numret == 3) {
			User next = UserDaoImpl.getInstance().getUser(username);
			request.getSession().setAttribute("privileges", next.getPrivileges());
			request.getSession().setAttribute("username", next.getUsername());
			request.getSession().setAttribute("id", next.getId());
			System.out.println(next.toString());
			return next;
		}else {
			return null;
		}
	}

	@Override
	public Object register(HttpServletRequest request, HttpServletResponse response) {
		String username = "";
		String password = "";
		String email = "";
		
		try {
			User user = mapper.readValue(request.getReader(), User.class);
			username = user.getUsername();
			password = user.getPassword();
			email = user.getEmail();
			} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("username", username);
		
		boolean outcome;
		try {
			outcome = UserDaoImpl.getInstance().insertUserReturnsBoolean(username, password, email);
			if(outcome == true) {
				User setUser;
				try {
					
					setUser = UserDaoImpl.getInstance().getUser(username);
					request.getSession().setAttribute("id", setUser.getId());
					return setUser;
				} catch (UserNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (InvalidUsernameException | InvalidPasswordException e1) {
			
			e1.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public Object viewSavedWork(HttpServletRequest request, HttpServletResponse response) {
		//String obj = (String)request.getSession().getAttribute("username");
		String username = "";
		
		
		try {

			Works work = mapper.readValue(request.getReader(), Works.class);
			username = work.getUsername();
			return WorksDaoImpl.getWoDa().getWorksUserByUsername(username);
		} catch (UserNotFoundException e) {

			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("returned null for viewSavedWork in UserServiceImpl");
		return null;
	}

	@Override
	public Object saveArtwork(HttpServletRequest request, HttpServletResponse response) {
		
		String username = "";
		String apiId = "";
		String comment = "";
		
		User view = null;
		
		try {
			Works work = mapper.readValue(request.getReader(), Works.class);
			//User user = mapper.readValue(request.getReader(), User.class);
			
			apiId = work.getApiId();
			comment = work.getComment();
			username = work.getUsername();
			view = UserDaoImpl.getInstance().getUser(username);
		
			} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return WorksDaoImpl.getWoDa().saveWorks(apiId, comment, view.getId());
	}

	@Override
	public Object updateEmail(HttpServletRequest request, HttpServletResponse response) {
		String obj = (String)request.getSession().getAttribute("username");
		String newEmail = "";
		
		try {
			User user = mapper.readValue(request.getReader(), User.class);
			newEmail = user.getEmail();
			
			} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			return UserDaoImpl.getInstance().updateEmail(obj, newEmail);
		} catch (UserNotFoundException | InvalidEmailException e) {
		
			e.printStackTrace();
		}
		System.out.println("null was returned for update email");
		return null;
	}

	@Override
	public Object updateUsername(HttpServletRequest request, HttpServletResponse response) {
		String obj = (String)request.getSession().getAttribute("username");
		String newUsername = "";
		
		try {
			User user = mapper.readValue(request.getReader(), User.class);
			newUsername = user.getNewUsername();
			
			} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			return UserDaoImpl.getInstance().updateUsername(obj, newUsername);
		} catch (UserNotFoundException | InvalidUsernameException e) {
		
			e.printStackTrace();
		}
	
		System.out.println("null was returned for updateusername");
		return null;
	}

	@Override
	public Object updatePassword(HttpServletRequest request, HttpServletResponse response) {
		String obj = (String)request.getSession().getAttribute("username");		
		String newPassword = "";
		
		try {
			User user = mapper.readValue(request.getReader(), User.class);
			newPassword = user.getNewPassword();
		
			} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			return UserDaoImpl.getInstance().updatePassword(obj, newPassword);
		} catch (UserNotFoundException | InvalidPasswordException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("returned null for updatePassword");
		return null;

	}

	@Override
	public Object updatePrivilegesToAdmin(HttpServletRequest request, HttpServletResponse response) {
		String username = "";
		
		try {
			User user = mapper.readValue(request.getReader(), User.class);
			username = user.getUsername();
			} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
		
			return UserDaoImpl.getInstance().updatePrivilegesToAdmin(username);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Object deleteUser(HttpServletRequest request, HttpServletResponse response) {
		String username = "";
		
		try {
			User user = mapper.readValue(request.getReader(), User.class);
			username = user.getUsername();
			
			} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return UserDaoImpl.getInstance().deleteUser(username);
	}

	@Override
	public Object updatePrivilegesToUser(HttpServletRequest request, HttpServletResponse response) {
		String username = "";
		
		try {
			User user = mapper.readValue(request.getReader(), User.class);
			username = user.getUsername();
			
			} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		try {
			return UserDaoImpl.getInstance().updatePrivilegesToUser(username);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Object popularImages(HttpServletRequest request, HttpServletResponse response) {
		
		return WorksDaoImpl.getWoDa().getCountOfUsersWhoSavedWorks();
	}

	@Override
	public Object imagesSavedByUser(HttpServletRequest request, HttpServletResponse response) {
		
		return WorksDaoImpl.getWoDa().getCountOfWorksSavedByEachUserReturnsUsername();
	}

		
}
