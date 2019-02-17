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
	public void testCreateAndDeletSimpleUser() { 
		try {
			User u = UserDaoImpl.getInstance().insertUser("test1", "test1pass", "username@uname.edu");
			assertEquals(u.getUsername(), "test1"); 
			assertEquals(u.getPrivileges().name(), Privileges.USER.name()); 
			assertEquals(u.getEmail(), "username@uname.edu"); 
			UserDaoImpl.getInstance().deleteUser("test1"); 
			u = UserDaoImpl.getInstance().getUser("test1"); 
			fail("user still found after deletion"); 
		} catch (InvalidUsernameException e) {
			assertTrue(true);
		}
		catch (InvalidPasswordException e) {
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
