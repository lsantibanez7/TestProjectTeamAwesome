package com.proj2.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.proj2.exception.IncorrectPasswordException;
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
		} catch (InvalidPasswordException e) {
			fail("Invalid Password Exception");
		} catch (UserNotFoundException e) {
			
		}
	}
	
	@Test
	public void testCreateAndDeleteUserWithUnconventionalInputs() { 
		try {
			User u = UserDaoImpl.getInstance().insertUser("ξαμεσ你好", "ξαμεσπασσ", "test@test.edu");
			assertEquals(u.getUsername(), "ξαμεσ你好"); 
			assertEquals(u.getPrivileges().name(), Privileges.USER.name()); 
			assertEquals(u.getEmail(), "test@test.edu"); 
			UserDaoImpl.getInstance().deleteUser("ξαμεσ你好"); 
			u = UserDaoImpl.getInstance().getUser("ξαμεσ你好"); 
			fail("UserNotFoundException not thrown"); 
		} catch (InvalidUsernameException e) {
			fail("Invalid Username Exception"); 
		} catch (InvalidPasswordException e) {
			fail("Invalid Password Exception");
		} catch (UserNotFoundException e) {

		}
	}
	
	@Test
	public void testAuthenticateLogin() { 
		try {
			UserDaoImpl.getInstance().insertUser("test2", "test2pass", "username2@uname.edu");
			UserDaoImpl.getInstance().insertUser("test3", "test3pass", "username3@uname.edu");
			UserDaoImpl.getInstance().insertUser("test4", "test4pass", "username4@uname.edu");
			int auth1 = UserDaoImpl.getInstance().authenticateLogIn("test2ag;jsja;", "djagls;jeg;jsofaj"); 
			int auth2 = UserDaoImpl.getInstance().authenticateLogIn("test3", "djagls;jeg;jsofaj"); 
			int auth3 = UserDaoImpl.getInstance().authenticateLogIn("test4", "test4pass");
			UserDaoImpl.getInstance().deleteUser("test2"); 
			UserDaoImpl.getInstance().deleteUser("test3"); 
			UserDaoImpl.getInstance().deleteUser("test4");
			assertEquals(auth1, 1); 
			assertEquals(auth2, 2); 
			assertEquals(auth3, 3);  
		} catch (InvalidUsernameException e) {
			fail("Invalid Username Exception"); 
		} catch (InvalidPasswordException e) {
			fail("Invalid Password Exception");
		}
	}
	
	@Test
	public void testUpdatePassword() {
		try {
			User u = UserDaoImpl.getInstance().insertUser("test5", "test5pass", "username1@uname.edu");
			int auth1 = UserDaoImpl.getInstance().authenticateLogIn("test5", "altered-password"); 
			assertEquals(auth1, 2); 
			assertTrue(UserDaoImpl.getInstance().updatePassword("test5", "altered-password")); 
			int auth2 = UserDaoImpl.getInstance().authenticateLogIn("test5", "altered-password"); 
			assertEquals(auth2, 3); 
			UserDaoImpl.getInstance().deleteUser("test5"); 
		} catch (InvalidUsernameException e) {
			fail("Invalid Username Exception"); 
		} catch (InvalidPasswordException e) {
			fail("Invalid Password Exception");
		} catch (UserNotFoundException e) {
			fail("UserNotFoundException"); 
		}
	}
	
	@Test
	public void testUpdateVerifyPasswordSuccessfullyChangesPassword() {
		try {
			UserDaoImpl.getInstance().insertUser("test6", "test6pass", "username1@uname.edu");
			int auth1 = UserDaoImpl.getInstance().authenticateLogIn("test6", "test6-altered-password"); 
			assertEquals(auth1, 2); 
			assertFalse(UserDaoImpl.getInstance().updateVerifyPassword("test6", "test6pass", "test6-altered-password")); 
			int auth2 = UserDaoImpl.getInstance().authenticateLogIn("test6", "test6-altered-password"); 
			assertEquals(auth2, 3); 
			UserDaoImpl.getInstance().deleteUser("test6"); 
		} catch (InvalidUsernameException e) {
			fail("Invalid Username Exception"); 
		} catch (InvalidPasswordException e) {
			fail("Invalid Password Exception");
		} catch (UserNotFoundException e) {
			fail("User Not Found Exception"); 
		} catch (IncorrectPasswordException e) {
			fail("Incorrect Password Exception"); 
		}
	}
	
	@Test
	public void testUpdateVerifyPasswordThrowsErrorForWrongPassword() {
		try {
			User u = UserDaoImpl.getInstance().insertUser("test7", "test7pass", "username1@uname.edu");
			int auth1 = UserDaoImpl.getInstance().authenticateLogIn("test7", "altered-password"); 
			assertEquals(auth1, 2); 
			assertFalse(UserDaoImpl.getInstance().updateVerifyPassword("test7", "wrong-password", "altered-password")); 
			fail("Should have thrown error");  
		} catch (InvalidUsernameException e) {
			fail("Invalid Username Exception"); 
		} catch (InvalidPasswordException e) {
			fail("Invalid Password Exception");
		} catch (UserNotFoundException e) {
			fail("UserNotFoundException"); 
		} catch (IncorrectPasswordException e) {
			UserDaoImpl.getInstance().deleteUser("test7"); 
		}
	}
	
	
	
	
	
}
