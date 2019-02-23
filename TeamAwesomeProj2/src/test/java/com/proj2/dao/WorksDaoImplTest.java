package com.proj2.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.proj2.exception.InvalidPasswordException;
import com.proj2.exception.InvalidUsernameException;
import com.proj2.exception.UserNotFoundException;
import com.proj2.model.Privileges;
import com.proj2.model.User;
import com.proj2.model.Works;

public class WorksDaoImplTest {

	@Test
	public void testCreateAndDeleteSimpleWorks() { 
		try {
			User u = UserDaoImpl.getInstance().insertUser("test4", "pass4", "test4@test.edu"); 
			Works w = WorksDaoImpl.getWoDa().saveWorks("100110", "no comment", u.getId()); 
			
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
	
}
