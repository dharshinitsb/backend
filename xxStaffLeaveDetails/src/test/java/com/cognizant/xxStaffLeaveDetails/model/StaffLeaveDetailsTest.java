package com.cognizant.xxStaffLeaveDetails.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class StaffLeaveDetailsTest {
	
	@Test
	public void idTest() throws Exception
	{
		StaffLeaveDetails staffLeaveDetails = new StaffLeaveDetails();
		staffLeaveDetails.setId(10);
		int result = staffLeaveDetails.getId();
		
		assertEquals(result, 10);
	}
	
	@Test
	public void clinicIdTest() throws Exception
	{
		StaffLeaveDetails staffLeaveDetails = new StaffLeaveDetails();
		staffLeaveDetails.setClinicId(10);
		int result = staffLeaveDetails.getClinicId();
		
		assertEquals(result, 10);
	}
	
	@Test
	public void staffNameTest() throws Exception
	{
		StaffLeaveDetails staffLeaveDetails = new StaffLeaveDetails();
		staffLeaveDetails.setStaffName("STAFF NAME");
		String result = staffLeaveDetails.getStaffName();
		
		assertEquals(result, "STAFF NAME");
	}
	
	@Test
	public void specialtyTest() throws Exception
	{
		StaffLeaveDetails staffLeaveDetails = new StaffLeaveDetails();
		staffLeaveDetails.setSpecialty("SPECIALTY");
		String result = staffLeaveDetails.getSpecialty();
		
		assertEquals(result, "SPECIALTY");
	}
	
	@Test
	public void leaveDateTest() throws Exception
	{
		StaffLeaveDetails staffLeaveDetails = new StaffLeaveDetails();
		staffLeaveDetails.setLeaveDate(LocalDate.of(2022, 12, 20));
		LocalDate result = staffLeaveDetails.getLeaveDate();
		
		assertEquals(result, LocalDate.of(2022, 12, 20));
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try
		{
			StaffLeaveDetails staffLeaveDetails1 = new StaffLeaveDetails();
			StaffLeaveDetails staffLeaveDetails2 = new StaffLeaveDetails(1, "STAFF ONE", "SPECIALTY ONE", LocalDate.of(2022, 12, 15));
			StaffLeaveDetails staffLeaveDetails3 = new StaffLeaveDetails(1, 1, "STAFF ONE", "SPECIALTY ONE", LocalDate.of(2022, 12, 15));
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
