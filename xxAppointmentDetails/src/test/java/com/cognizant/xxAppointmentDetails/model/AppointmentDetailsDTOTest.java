package com.cognizant.xxAppointmentDetails.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class AppointmentDetailsDTOTest {
	
	@Test
	public void idTest() throws Exception
	{
		AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO();
		appointmentDetailsDTO.setId(10);
		int result = appointmentDetailsDTO.getId();
		
		assertEquals(result,10);
	}
	
	@Test
	public void patientIdTest() throws Exception
	{
		AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO();
		appointmentDetailsDTO.setPatientId(10);
		int result = appointmentDetailsDTO.getPatientId();
		
		assertEquals(result,10);
	}
	
	@Test
	public void clinicIdTest() throws Exception
	{
		AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO();
		appointmentDetailsDTO.setClinicId(10);
		int result = appointmentDetailsDTO.getClinicId();
		
		assertEquals(result,10);
	}
	
	@Test
	public void specialtyTest() throws Exception
	{
		AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO();
		appointmentDetailsDTO.setSpecialty("SPECIALTY");
		String result = appointmentDetailsDTO.getSpecialty();
		
		assertEquals(result, "SPECIALTY");
	}
	
	@Test
	public void appointmentDateYearTest() throws Exception
	{
		AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO();
		appointmentDetailsDTO.setAppointmentDateYear(2022);
		int result = appointmentDetailsDTO.getAppointmentDateYear();
		
		assertEquals(result,2022);
	}
	
	@Test
	public void appointmentDateMonthTest() throws Exception
	{
		AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO();
		appointmentDetailsDTO.setAppointmentDateMonth(12);
		int result = appointmentDetailsDTO.getAppointmentDateMonth();
		
		assertEquals(result,12);
	}
	
	@Test
	public void appointmentDateDayTest() throws Exception
	{
		AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO();
		appointmentDetailsDTO.setAppointmentDateDay(15);
		int result = appointmentDetailsDTO.getAppointmentDateDay();
		
		assertEquals(result,15);
	}
	
	@Test
	public void appointmentDateSlotTest() throws Exception
	{
		AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO();
		appointmentDetailsDTO.setAppointmentDateSlot(11);
		int result = appointmentDetailsDTO.getAppointmentDateSlot();
		
		assertEquals(result,11);
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try
		{
			AppointmentDetailsDTO appointmentDetailsDTO1 = new AppointmentDetailsDTO();
			AppointmentDetailsDTO appointmentDetailsDTO2 = new AppointmentDetailsDTO(1, 1, "SPECIALTY", 2022, 12, 15, 11);
			AppointmentDetailsDTO appointmentDetailsDTO3 = new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11);
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
