package com.cognizant.xxStaffLeaveDetails.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingDetailsTest {
	
	@Test
	public void clinicIdTest() throws Exception
	{
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setClinicId(10);
		int result = bookingDetails.getClinicId();
		
		assertEquals(result, 10);
	}
	
	@Test
	public void specialtyTest() throws Exception
	{
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setSpecialty("SPECIALTY");
		String result = bookingDetails.getSpecialty();
		
		assertEquals(result, "SPECIALTY");
	}
	
	@Test
	public void appointmentDateYearTest() throws Exception
	{
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setAppointmentDateYear(2022);
		int result = bookingDetails.getAppointmentDateYear();
		
		assertEquals(result, 2022);
	}
	
	@Test
	public void appointmentDateMonthTest() throws Exception
	{
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setAppointmentDateMonth(12);
		int result = bookingDetails.getAppointmentDateMonth();
		
		assertEquals(result, 12);
	}
	
	@Test
	public void appointmentDateDayTest() throws Exception
	{
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setAppointmentDateDay(20);
		int result = bookingDetails.getAppointmentDateDay();
		
		assertEquals(result, 20);
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try
		{
			BookingDetails bookingDetails1 = new BookingDetails();
			BookingDetails bookingDetails2 = new BookingDetails(10, "SPECIALTY", 2022, 12, 15);
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
