package com.cognizant.xxAppointmentDetails.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.xxAppointmentDetails.controller.AuthClient;
import com.cognizant.xxAppointmentDetails.model.AppointmentDetails;
import com.cognizant.xxAppointmentDetails.model.AppointmentDetailsDTO;
import com.cognizant.xxAppointmentDetails.model.AuthResponse;
import com.cognizant.xxAppointmentDetails.repository.AppointmentDetailsRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class AppointmentDetailsServiceImplTest {
	
	@InjectMocks
	private AppointmentDetailsServiceImpl appointmentDetailsServiceImpl;
	
	@Mock
	private AppointmentDetailsRepository appointmentDetailsRepository;
	
	@Mock
	private AuthClient authClient;
	
	@Test
	public void contextLoads() throws Exception
	{
		assertNotNull(appointmentDetailsServiceImpl);
	}
	
	@Test
	public void findAllAppointmentDetailsTestSuccess() throws Exception
	{
		AppointmentDetails stubAppointmentDetails = new AppointmentDetails(1, 1, 1, "SPECIALTY", LocalDateTime.of(2022, 12, 15, 11, 0));
		List<AppointmentDetails> stubList = new ArrayList<>();
		stubList.add(stubAppointmentDetails);
		
		doReturn(stubList).when(appointmentDetailsRepository).findAll();
		
		List<AppointmentDetailsDTO> resultList = appointmentDetailsServiceImpl.findAllAppointmentDetails();
		
		assertNotNull(resultList);
	}
	
	@Test
	public void findAllAppointmentDetailsTestFail() throws Exception
	{		
		doThrow(new NullPointerException()).when(appointmentDetailsRepository).findAll();
		
		try
		{
			List<AppointmentDetailsDTO> resultList = appointmentDetailsServiceImpl.findAllAppointmentDetails();
			
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void addAppointmentDetailsTestSuccess() throws Exception
	{
		doReturn(null).when(appointmentDetailsRepository).save(any(AppointmentDetails.class));
		
		try
		{
			appointmentDetailsServiceImpl.addAppointmentDetails(new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11));
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void addAppointmentDetailsTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(appointmentDetailsRepository).save(any(AppointmentDetails.class));
		
		try
		{
			appointmentDetailsServiceImpl.addAppointmentDetails(new AppointmentDetailsDTO());
			
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void editAppointmentDetailsTestSuccess() throws Exception
	{
		doReturn(null).when(appointmentDetailsRepository).save(any(AppointmentDetails.class));
		
		try
		{
			appointmentDetailsServiceImpl.editAppointmentDetails(new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11));
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void editAppointmentDetailsTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(appointmentDetailsRepository).save(any(AppointmentDetails.class));
		
		try
		{
			appointmentDetailsServiceImpl.editAppointmentDetails(new AppointmentDetailsDTO());
			
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void removeAppointmentDetailsTestSuccess() throws Exception
	{
		doNothing().when(appointmentDetailsRepository).deleteById(anyInt());
		
		try
		{
			appointmentDetailsServiceImpl.removeAppointmentDetails(new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11));
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void removeAppointmentDetailsTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(appointmentDetailsRepository).deleteById(anyInt());
		
		try
		{
			appointmentDetailsServiceImpl.removeAppointmentDetails(new AppointmentDetailsDTO());
			
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void findAppointmentDetailsByPatientIdTestSuccess() throws Exception
	{
		AppointmentDetails stubAppointmentDetails = new AppointmentDetails(1, 1, 1, "SPECIALTY", LocalDateTime.of(2022, 12, 15, 11, 0));
		List<AppointmentDetails> stubList = new ArrayList<>();
		stubList.add(stubAppointmentDetails);
		
		doReturn(stubList).when(appointmentDetailsRepository).filterByPatientId(anyInt());
		
		List<AppointmentDetailsDTO> resultList = appointmentDetailsServiceImpl.findAppointmentDetailsByPatientId(10);
		
		assertNotNull(resultList);
	}
	
	@Test
	public void findAppointmentDetailsByPatientIdTestFail() throws Exception
	{		
		doThrow(new NullPointerException()).when(appointmentDetailsRepository).filterByPatientId(anyInt());
		
		try
		{
			List<AppointmentDetailsDTO> resultList = appointmentDetailsServiceImpl.findAppointmentDetailsByPatientId(10);
			
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void findAppointmentDetailsByClinicIdTestSuccess() throws Exception
	{
		AppointmentDetails stubAppointmentDetails = new AppointmentDetails(1, 1, 1, "SPECIALTY", LocalDateTime.of(2022, 12, 15, 11, 0));
		List<AppointmentDetails> stubList = new ArrayList<>();
		stubList.add(stubAppointmentDetails);
		
		doReturn(stubList).when(appointmentDetailsRepository).filterByClinicId(anyInt());
		
		List<AppointmentDetailsDTO> resultList = appointmentDetailsServiceImpl.findAppointmentDetailsByClinicId(10);
		
		assertNotNull(resultList);
	}
	
	@Test
	public void findAppointmentDetailsByClinicIdTestFail() throws Exception
	{		
		doThrow(new NullPointerException()).when(appointmentDetailsRepository).filterByClinicId(anyInt());
		
		try
		{
			List<AppointmentDetailsDTO> resultList = appointmentDetailsServiceImpl.findAppointmentDetailsByClinicId(10);
			
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void isSlotAvailableTestSuccess() throws Exception
	{
		AppointmentDetails stubAppointmentDetails = new AppointmentDetails(1, 1, 1, "SPECIALTY", LocalDateTime.of(2022, 12, 15, 11, 0));
		List<AppointmentDetails> stubList = new ArrayList<>();
		stubList.add(stubAppointmentDetails);
		
		doReturn(stubList).when(appointmentDetailsRepository).filterByClinicId(anyInt());
		
		boolean response =  appointmentDetailsServiceImpl.isSlotAvailable(new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 12));
		
		assertTrue(response);
	}
	
	@Test
	public void isSlotAvailableTestFail() throws Exception
	{
		AppointmentDetails stubAppointmentDetails = new AppointmentDetails(1, 1, 1, "SPECIALTY", LocalDateTime.of(2022, 12, 15, 11, 0));
		List<AppointmentDetails> stubList = new ArrayList<>();
		stubList.add(stubAppointmentDetails);
		
		doReturn(stubList).when(appointmentDetailsRepository).filterByClinicId(anyInt());
		
		boolean response =  appointmentDetailsServiceImpl.isSlotAvailable(new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11));
		
		assertFalse(response);
	}
	
	@Test
	public void isSessionValidTestSuccess() throws Exception
	{
		doReturn(new AuthResponse())
		.when(authClient)
		.getValidity(anyString());
		
		boolean result = appointmentDetailsServiceImpl.isSessionValid("token");
		
		assertTrue(result);
	}
	
	@Test
	public void isSessionValidTestFail() throws Exception
	{
		doThrow(NullPointerException.class)
		.when(authClient)
		.getValidity(anyString());
		
		assertFalse(appointmentDetailsServiceImpl.isSessionValid("token"));
	}
	
	@Test
	public void addDataTest()
	{
		try 
		{
			appointmentDetailsServiceImpl.addData();
		
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
