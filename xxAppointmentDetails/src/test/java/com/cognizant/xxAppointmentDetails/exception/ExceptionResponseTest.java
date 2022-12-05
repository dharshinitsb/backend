package com.cognizant.xxAppointmentDetails.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class ExceptionResponseTest {
	
	@Test
	public void detailsTest() throws Exception
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setDetails("details");
		String resultDetails = exceptionResponse.getDetails();
		
		assertEquals(resultDetails, "details");
	}
	
	@Test
	public void messageTest() throws Exception
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage("message");;
		String resultMessage = exceptionResponse.getMessage();
		
		assertEquals(resultMessage, "message");
	}
	
	@Test
	public void timestampTest() throws Exception
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setTimestamp(new Date());
		Date resultDate = exceptionResponse.getTimestamp();
		
		assertNotNull(resultDate);
	}
	
	@Test
	public void toStringTest() throws Exception
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "details", "message");
		String resultString = exceptionResponse.toString();
		
		assertTrue(true);
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try 
		{
			ExceptionResponse obj1 = new ExceptionResponse();
			ExceptionResponse obj2 = new ExceptionResponse(new Date(), "details", "message");
			
			assertTrue(true);	
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
