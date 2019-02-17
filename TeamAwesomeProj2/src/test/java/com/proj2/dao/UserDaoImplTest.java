package com.proj2.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.proj2.exception.InvalidPasswordException;
import com.proj2.exception.InvalidUsernameException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.Privileges;
import com.proj2.model.User;

public class UserDaoImplTest {
	// Test that DaoImpl methods make accurate calls to the database
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	
	@Test
	public void testCreateAndDeleteSimpleUser() { 
		try {
			User u = UserDaoImpl.getInstance().insertUser("test1", "test1pass", "username@uname.edu");
			assertEquals(u.getUsername(), "test1"); 
			assertEquals(u.getPrivileges().name(), Privileges.USER.name()); 
			assertEquals(u.getEmail(), "username@uname.edu"); 
			UserDaoImpl.getInstance().deleteUser("test1"); 
			u = UserDaoImpl.getInstance().getUser("test1"); 
			fail("UserNotFoundException not thrown"); 
		} catch (InvalidUsernameException e) {
			fail("Invalid Username Exception"); 
		}
		catch (InvalidPasswordException e) {
			fail("Invalid Password Exception");
		} catch (UserNotFoundException e) {
			
		}
	}
	
	@Test
	public void testAuthenticateLogin() { 
		try {
			UserDaoImpl.getInstance().insertUser("test1", "test1pass", "username1@uname.edu");
			UserDaoImpl.getInstance().insertUser("test2", "test2pass", "username2@uname.edu");
			UserDaoImpl.getInstance().insertUser("test3", "test3pass", "username3@uname.edu");
			int auth1 = UserDaoImpl.getInstance().authenticateLogIn("test1ag;jsja;", "djagls;jeg;jsofaj"); 
			int auth2 = UserDaoImpl.getInstance().authenticateLogIn("test2", "djagls;jeg;jsofaj"); 
			int auth3 = UserDaoImpl.getInstance().authenticateLogIn("test3", "test3pass");
			UserDaoImpl.getInstance().deleteUser("test1"); 
			UserDaoImpl.getInstance().deleteUser("test2"); 
			UserDaoImpl.getInstance().deleteUser("test3");
			assertEquals(auth1, 1); 
			assertEquals(auth2, 2); 
			assertEquals(auth3, 3);  
		} catch (InvalidUsernameException e) {
			fail("Invalid Username Exception"); 
		}
		catch (InvalidPasswordException e) {
			fail("Invalid Password Exception");
		}
	}
	
	
}
