package com.cognizant.xxClinicDetails.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthResponseTest {
	
	@Test
	public void usernameTest() throws Exception
	{
		AuthResponse authResponse = new AuthResponse();
		authResponse.setUsername("random user");
		String resultUsername = authResponse.getUsername();
		
		assertEquals(resultUsername, "random user");
	}
	
	@Test
	public void isValidTest() throws Exception
	{
		AuthResponse authResponse = new AuthResponse();
		authResponse.setValid(true);;
		boolean resultIsValid = authResponse.isValid();
		
		assertTrue(resultIsValid);
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try 
		{
			AuthResponse obj1 = new AuthResponse();
			AuthResponse obj2 = new AuthResponse("username", true);
		
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}

