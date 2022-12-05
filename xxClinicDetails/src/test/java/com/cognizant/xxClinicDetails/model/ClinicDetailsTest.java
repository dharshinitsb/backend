package com.cognizant.xxClinicDetails.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class ClinicDetailsTest {
	
	@Test
	public void idTest() throws Exception
	{
		ClinicDetails clinicDetails = new ClinicDetails();
		clinicDetails.setId(10);
		int result = clinicDetails.getId();
		
		assertEquals(result,10);
	}
	
	@Test
	public void clinicNameTest() throws Exception
	{
		ClinicDetails clinicDetails = new ClinicDetails();
		clinicDetails.setClinicName("CLINIC NAME");
		String result = clinicDetails.getClinicName();
		
		assertEquals(result,"CLINIC NAME");
	}
	
	@Test
	public void addressTest() throws Exception
	{
		ClinicDetails clinicDetails = new ClinicDetails();
		clinicDetails.setAddress("ADDRESS");
		String result = clinicDetails.getAddress();
		
		assertEquals(result,"ADDRESS");
	}
	
	@Test
	public void cityTest() throws Exception
	{
		ClinicDetails clinicDetails = new ClinicDetails();
		clinicDetails.setCity("CITY");
		String result = clinicDetails.getCity();
		
		assertEquals(result,"CITY");
	}
	
	@Test
	public void stateTest() throws Exception
	{
		ClinicDetails clinicDetails = new ClinicDetails();
		clinicDetails.setState("STATE");
		String result = clinicDetails.getState();
		
		assertEquals(result,"STATE");
	}
	
	@Test
	public void countryTest() throws Exception
	{
		ClinicDetails clinicDetails = new ClinicDetails();
		clinicDetails.setCountry("COUNTRY");
		String result = clinicDetails.getCountry();
		
		assertEquals(result,"COUNTRY");
	}
	
	@Test
	public void contactNumberTest() throws Exception
	{
		ClinicDetails clinicDetails = new ClinicDetails();
		clinicDetails.setContactNumber("9876543210");
		String result = clinicDetails.getContactNumber();
		
		assertEquals(result,"9876543210");
	}
	
	@Test
	public void emailIdTest() throws Exception
	{
		ClinicDetails clinicDetails = new ClinicDetails();
		clinicDetails.setEmailId("EMAIL");
		String result = clinicDetails.getEmailId();
		
		assertEquals(result,"EMAIL");
	}

	@Test
	public void constructorTest() throws Exception
	{
		try
		{
			ClinicDetails clinicDetails1 = new ClinicDetails();
			ClinicDetails clinicDetails2 = new ClinicDetails("CLINIC ONE", "ADDRESS ONE", "CITY ONE", "STATE ONE", "COUNTRY ONE", "9999999999", "EMAILONE@EMAIL.COM");
			ClinicDetails clinicDetails3 = new ClinicDetails(1, "CLINIC ONE", "ADDRESS ONE", "CITY ONE", "STATE ONE", "COUNTRY ONE", "9999999999", "EMAILONE@EMAIL.COM");
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}



}
