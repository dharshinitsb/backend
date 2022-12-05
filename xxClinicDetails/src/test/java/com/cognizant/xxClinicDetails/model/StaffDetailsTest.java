package com.cognizant.xxClinicDetails.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class StaffDetailsTest {
	
	@Test
	public void idTest() throws Exception
	{
		StaffDetails staffDetails = new StaffDetails();
		staffDetails.setId(10);
		int result = staffDetails.getId();
		
		assertEquals(result,10);
	}
	
	@Test
	public void clinicIdTest() throws Exception
	{
		StaffDetails staffDetails = new StaffDetails();
		staffDetails.setClinicId(10);
		int result = staffDetails.getClinicId();
		
		assertEquals(result,10);
	}
	
	@Test
	public void staffNameTest() throws Exception
	{
		StaffDetails staffDetails = new StaffDetails();
		staffDetails.setStaffName("STAFF NAME");
		String result = staffDetails.getStaffName();
		
		assertEquals(result,"STAFF NAME");
	}
	
	@Test
	public void specialtyTest() throws Exception
	{
		StaffDetails staffDetails = new StaffDetails();
		staffDetails.setSpecialty("SPECIALTY");
		String result = staffDetails.getSpecialty();
		
		assertEquals(result,"SPECIALTY");
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try
		{
			StaffDetails staffDetails1 = new StaffDetails();
			StaffDetails staffDetails2 = new StaffDetails(1, "Krishna", "Cardiologists");
			StaffDetails staffDetails3 = new StaffDetails(1, 1, "Krishna", "Cardiologists");
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}


}
