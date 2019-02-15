

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


public class MasterDispatcher {
private MasterDispatcher() {}
	
	// Command and Mediator Design Pattern
	
	//private static final LoginService loginService = new LoginServiceImpl();

	public static Object doget(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		if(request.getRequestURI().contains("")) {
			return null;
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
