

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.proj2.exception.UserNotFoundException;
import com.proj2.services.UserService;
import com.proj2.services.UserServiceImpl;
import com.proj2.util.JDBSCConnectionUtil;


public class MasterDispatcher {
private MasterDispatcher() {}
	
	// Command and Mediator Design Pattern
	
	//private static final LoginService loginService = new LoginServiceImpl();
	private static final UserService userservice = new UserServiceImpl();
	//final static Logger log = Logger.getLogger(JDBSCConnectionUtil.class);


	public static Object doget(HttpServletRequest request, HttpServletResponse response) throws SQLException, UserNotFoundException {
		
		
		
		if(request.getRequestURI().contains("login")) {
			//log.info("login");
			return userservice.attemptAuthentication(request, response);
		}else if(request.getRequestURI().contains("Register")) {
			return userservice.register(request, response);
		}else if(request.getRequestURI().contains("ViewSavedWork")) {
			return userservice.viewSavedWork(request, response);
		}else if(request.getRequestURI().contains("SaveArtwork")) {
			return userservice.saveArtwork(request, response);
		}else if(request.getRequestURI().contains("UpdateEmail")) {
			return userservice.updateEmail(request, response);
		}else if(request.getRequestURI().contains("UpdateUsername")) {
			return userservice.updateUsername(request, response);
		}else if(request.getRequestURI().contains("UpdatePassword")) {
			return userservice.updatePassword(request, response);
		}else if(request.getRequestURI().contains("UpdatePrivilegesToUser")) {
			return userservice.updatePrivilegesToUser(request, response);
		}else if(request.getRequestURI().contains("UpdatePrivilegesToAdmin")) {
			return userservice.updatePrivilegesToAdmin(request, response);
		}else if(request.getRequestURI().contains("DeleteUser")) {
			return userservice.deleteUser(request, response);
		}else if(request.getRequestURI().contains("Popularity")) {
			return userservice.popularImages(request, response);
		}else if(request.getRequestURI().contains("PupularityByUsername")) {
			return userservice.imagesSavedByUser(request, response);
		}
		else {
			return "Not yet Implented";
		}
		
		
		

	}
	
	public static Object doput(HttpServletRequest request, HttpServletResponse response) throws SQLException, UserNotFoundException {
		
		if(request.getRequestURI().contains("login")) {
			return userservice.attemptAuthentication(request, response);
		}else if(request.getRequestURI().contains("Register")) {
			return userservice.register(request, response);
		}else if(request.getRequestURI().contains("ViewSavedWork")) {
			return userservice.viewSavedWork(request, response);
		}else if(request.getRequestURI().contains("SaveArtwork")) {
			return userservice.saveArtwork(request, response);
		}else if(request.getRequestURI().contains("UpdateEmail")) {
			return userservice.updateEmail(request, response);
		}else if(request.getRequestURI().contains("UpdateUsername")) {
			return userservice.updateUsername(request, response);
		}else if(request.getRequestURI().contains("UpdatePassword")) {
			return userservice.updatePassword(request, response);
		}else if(request.getRequestURI().contains("UpdatePrivilegesToUser")) {
			return userservice.updatePrivilegesToUser(request, response);
		}else if(request.getRequestURI().contains("UpdatePrivilegesToAdmin")) {
			return userservice.updatePrivilegesToAdmin(request, response);
		}else if(request.getRequestURI().contains("DeleteUser")) {
			return userservice.deleteUser(request, response);
		}
		else {
			return "Not yet Implented";
		}
		
	}
	
	public static Object dopost(HttpServletRequest request, HttpServletResponse response) throws SQLException, UserNotFoundException {
		
		if(request.getRequestURI().contains("login")) {
			return userservice.attemptAuthentication(request, response);
		}else if(request.getRequestURI().contains("Register")) {
			return userservice.register(request, response);
		}else if(request.getRequestURI().contains("ViewSavedWork")) {
			return userservice.viewSavedWork(request, response);
		}else if(request.getRequestURI().contains("SaveArtwork")) {
			return userservice.saveArtwork(request, response);
		}else if(request.getRequestURI().contains("UpdateEmail")) {
			return userservice.updateEmail(request, response);
		}else if(request.getRequestURI().contains("UpdateUsername")) {
			return userservice.updateUsername(request, response);
		}else if(request.getRequestURI().contains("UpdatePassword")) {
			return userservice.updatePassword(request, response);
		}else if(request.getRequestURI().contains("UpdatePrivilegesToUser")) {
			return userservice.updatePrivilegesToUser(request, response);
		}else if(request.getRequestURI().contains("UpdatePrivilegesToAdmin")) {
			return userservice.updatePrivilegesToAdmin(request, response);
		}else if(request.getRequestURI().contains("DeleteUser")) {
			return userservice.deleteUser(request, response);
		}
		else {
			return "Not yet Implented";
		}
		
	}
	
	public static Object dodelete(HttpServletRequest request, HttpServletResponse response) throws SQLException, UserNotFoundException {
		
		if(request.getRequestURI().contains("login")) {
			return userservice.attemptAuthentication(request, response);
		}else if(request.getRequestURI().contains("Register")) {
			return userservice.register(request, response);
		}else if(request.getRequestURI().contains("ViewSavedWork")) {
			return userservice.viewSavedWork(request, response);
		}else if(request.getRequestURI().contains("SaveArtwork")) {
			return userservice.saveArtwork(request, response);
		}else if(request.getRequestURI().contains("UpdateEmail")) {
			return userservice.updateEmail(request, response);
		}else if(request.getRequestURI().contains("UpdateUsername")) {
			return userservice.updateUsername(request, response);
		}else if(request.getRequestURI().contains("UpdatePassword")) {
			return userservice.updatePassword(request, response);
		}else if(request.getRequestURI().contains("UpdatePrivilegesToUser")) {
			return userservice.updatePrivilegesToUser(request, response);
		}else if(request.getRequestURI().contains("UpdatePrivilegesToAdmin")) {
			return userservice.updatePrivilegesToAdmin(request, response);
		}else if(request.getRequestURI().contains("DeleteUser")) {
			return userservice.deleteUser(request, response);
		}
		else {
			return "Not yet Implented";
		}
		
}}
