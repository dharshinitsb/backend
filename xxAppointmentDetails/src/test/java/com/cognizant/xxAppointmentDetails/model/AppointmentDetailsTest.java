package com.cognizant.xxAppointmentDetails.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class AppointmentDetailsTest {
	
	@Test
	public void idTest() throws Exception
	{
		AppointmentDetails appointmentDetails = new AppointmentDetails();
		appointmentDetails.setId(10);
		int result = appointmentDetails.getId();
		
		assertEquals(result,10);
	}
	
	@Test
	public void patientIdTest() throws Exception
	{
		AppointmentDetails appointmentDetails = new AppointmentDetails();
		appointmentDetails.setPatientId(10);
		int result = appointmentDetails.getPatientId();
		
		assertEquals(result,10);
	}
	
	@Test
	public void clinicIdTest() throws Exception
	{
		AppointmentDetails appointmentDetails = new AppointmentDetails();
		appointmentDetails.setClinicId(10);
		int result = appointmentDetails.getClinicId();
		
		assertEquals(result,10);
	}
	
	@Test
	public void specialtyTest() throws Exception
	{
		AppointmentDetails appointmentDetails = new AppointmentDetails();
		appointmentDetails.setSpecialty("SPECIALTY");
		String result = appointmentDetails.getSpecialty();
		
		assertEquals(result, "SPECIALTY");
	}
	
	@Test
	public void appointmentDateTest() throws Exception
	{
		AppointmentDetails appointmentDetails = new AppointmentDetails();
		appointmentDetails.setAppointmentDate(LocalDateTime.of(2022, 12, 15, 11, 0));
		LocalDateTime result = appointmentDetails.getAppointmentDate();
		
		assertEquals(result, LocalDateTime.of(2022, 12, 15, 11, 0));
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try
		{
			AppointmentDetails appointmentDetails1 = new AppointmentDetails();
			AppointmentDetails appointmentDetails2 = new AppointmentDetails(1, 1, "SPECIALTY", LocalDateTime.of(2022, 12, 15, 11, 0));
			AppointmentDetails appointmentDetails3 = new AppointmentDetails(1, 1, 1, "SPECIALTY", LocalDateTime.of(2022, 12, 15, 11, 0));
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
