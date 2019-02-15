

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proj2.exception.PrivilegesNotFoundException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.services.UserService;
import com.proj2.services.UserServiceImpl;


public class MasterDispatcher {
private MasterDispatcher() {}
	
	// Command and Mediator Design Pattern
	
	//private static final LoginService loginService = new LoginServiceImpl();
	private static final UserService userservice = new UserServiceImpl();

	public static Object doget(HttpServletRequest request, HttpServletResponse response) throws SQLException, PrivilegesNotFoundException, UserNotFoundException {
		
		
		
		if(request.getRequestURI().contains("Authorize")) {
			return userservice.attemptAuthentication(request, response);
		}
		else {
			return "Not yet Implented";
		}
		
		
		
//		if(request.getRequestURI().contains("users")) {
//			System.out.println("entering users");
//			return loginService.attemptAuthentication(request, response);
	}
	
	public static Object doput(HttpServletRequest request, HttpServletResponse response) {
		
			if(request.getRequestURI().contains("")) {
				return null;
			}
			else {
				return "Not yet Implented";
			}
	}
	
	public static Object dopost(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getRequestURI().contains("")) {
			return null;
		}
		else {
			return "Not yet Implented";
		}
	}
	
	public static Object dodelete(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getRequestURI().contains("")) {
			return null;
		}
		else {
			return "Not yet Implented";
		}
	}
}
