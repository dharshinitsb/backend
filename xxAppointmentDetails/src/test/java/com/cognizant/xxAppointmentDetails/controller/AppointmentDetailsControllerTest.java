package com.cognizant.xxAppointmentDetails.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.cognizant.xxAppointmentDetails.model.AppointmentDetailsDTO;
import com.cognizant.xxAppointmentDetails.service.AppointmentDetailsServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class AppointmentDetailsControllerTest {
	
	@InjectMocks
	private AppointmentDetailsController appointmentDetailsController;
	
	@Mock
	private AppointmentDetailsServiceImpl appointmentDetailsServiceImpl;
	
	@Test
	public void contextLoads() throws Exception
	{
		assertNotNull(appointmentDetailsController);
	}
	
	@Test
	public void getAllAppointmentDetailsTestSuccess() throws Exception
	{
		AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11);
		List<AppointmentDetailsDTO> stubList = new ArrayList<>();
		stubList.add(appointmentDetailsDTO);
		
		doReturn(stubList).when(appointmentDetailsServiceImpl).findAllAppointmentDetails();
		doReturn(true).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = appointmentDetailsController.getAllAppointmentDetails("token");
		
		assertEquals(response.getStatusCodeValue(), 200);
		assertNotNull(response.getBody());	
	}
	
	@Test
	public void getAllAppointmentDetailsTestFail() throws Exception
	{
		doReturn(false).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = appointmentDetailsController.getAllAppointmentDetails("token");
		
		assertEquals(response.getStatusCodeValue(), 403);
		assertEquals(response.getBody(), "AUTHORIZATION ERROR");	
	}
	
	@Test
	public void createAppointmentDetailsTestSuccess() throws Exception
	{
		doReturn(true).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		doReturn(true).when(appointmentDetailsServiceImpl).isSlotAvailable(any(AppointmentDetailsDTO.class));
		doNothing().when(appointmentDetailsServiceImpl).addAppointmentDetails(any(AppointmentDetailsDTO.class));
		
		ResponseEntity<?> response1 = appointmentDetailsController.createAppointmentDetails("token", new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11));
		assertEquals(response1.getStatusCodeValue(),200);
		assertEquals(response1.getBody(),"CREATED APPOINTMENT DETAILS SUCCESSFULLY");
		
		doReturn(true).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		doReturn(false).when(appointmentDetailsServiceImpl).isSlotAvailable(any(AppointmentDetailsDTO.class));
		doNothing().when(appointmentDetailsServiceImpl).addAppointmentDetails(any(AppointmentDetailsDTO.class));
		
		ResponseEntity<?> response2 = appointmentDetailsController.createAppointmentDetails("token", new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 12));
		assertEquals(response2.getStatusCodeValue(),200);
		assertEquals(response2.getBody(),"SLOT UNAVAILABLE");
	}
	
	@Test
	public void createAppointmentDetailsTestFail() throws Exception
	{
		doReturn(false).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = appointmentDetailsController.createAppointmentDetails("token", new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11));
		
		assertEquals(response.getStatusCodeValue(), 403);
		assertEquals(response.getBody(),"AUTHORIZATION ERROR");
	}
	
	@Test
	public void updateAppointmentDetailsTestSuccess() throws Exception
	{
		doReturn(true).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		doReturn(true).when(appointmentDetailsServiceImpl).isSlotAvailable(any(AppointmentDetailsDTO.class));
		doNothing().when(appointmentDetailsServiceImpl).editAppointmentDetails(any(AppointmentDetailsDTO.class));
		
		ResponseEntity<?> response1 = appointmentDetailsController.updateAppointmentDetails("token", new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11));
		assertEquals(response1.getStatusCodeValue(),200);
		assertEquals(response1.getBody(),"UPDATED APPOINTMENT DETAILS SUCCESSFULLY");
		
		doReturn(true).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		doReturn(false).when(appointmentDetailsServiceImpl).isSlotAvailable(any(AppointmentDetailsDTO.class));
		doNothing().when(appointmentDetailsServiceImpl).editAppointmentDetails(any(AppointmentDetailsDTO.class));
		
		ResponseEntity<?> response2 = appointmentDetailsController.updateAppointmentDetails("token", new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 12));
		assertEquals(response2.getStatusCodeValue(),200);
		assertEquals(response2.getBody(),"SLOT UNAVAILABLE");
	}
	
	@Test
	public void updateAppointmentDetailsTestFail() throws Exception
	{
		doReturn(false).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = appointmentDetailsController.updateAppointmentDetails("token", new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11));
		
		assertEquals(response.getStatusCodeValue(), 403);
		assertEquals(response.getBody(),"AUTHORIZATION ERROR");
	}
	
	@Test
	public void deleteAppointmentDetailsTestSuccess() throws Exception
	{
		doReturn(true).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		doNothing().when(appointmentDetailsServiceImpl).removeAppointmentDetails(any(AppointmentDetailsDTO.class));
		
		ResponseEntity<?> response = appointmentDetailsController.deleteAppointmentDetails("token", new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11));
		
		assertEquals(response.getStatusCodeValue(),200);
		assertEquals(response.getBody(),"DELETED APPOINTMENT DETAILS SUCCESSFULLY");
	}
	
	@Test
	public void deleteAppointmentDetailsTestFail() throws Exception
	{
		doReturn(false).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = appointmentDetailsController.deleteAppointmentDetails("token", new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11));
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(),"AUTHORIZATION ERROR");
	}
	
	@Test
	public void getAppointmentDetailsByPatientIdTestSuccess() throws Exception
	{
		AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11);
		List<AppointmentDetailsDTO> stubList = new ArrayList<>();
		stubList.add(appointmentDetailsDTO);
		
		doReturn(true).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		doReturn(stubList).when(appointmentDetailsServiceImpl).findAppointmentDetailsByPatientId(anyInt());
		
		ResponseEntity<?> response = appointmentDetailsController.getAppointmentDetailsByPatientId("token", 10);
		
		assertEquals(response.getStatusCodeValue(),200);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void getAppointmentDetailsByPatientIdTestFail() throws Exception
	{
		doReturn(false).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = appointmentDetailsController.getAppointmentDetailsByPatientId("token", 10);
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(),"AUTHORIZATION ERROR");
	}
	
	@Test
	public void getAppointmentDetailsByClinicIdTestSuccess() throws Exception
	{
		AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO(1, 1, 1, "SPECIALTY", 2022, 12, 15, 11);
		List<AppointmentDetailsDTO> stubList = new ArrayList<>();
		stubList.add(appointmentDetailsDTO);
		
		doReturn(true).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		doReturn(stubList).when(appointmentDetailsServiceImpl).findAppointmentDetailsByClinicId(anyInt());
		
		ResponseEntity<?> response = appointmentDetailsController.getAppointmentDetailsByClinicId("token", 10);
		
		assertEquals(response.getStatusCodeValue(),200);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void getAppointmentDetailsByClinicIdTestFail() throws Exception
	{
		doReturn(false).when(appointmentDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = appointmentDetailsController.getAppointmentDetailsByClinicId("token", 10);
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(),"AUTHORIZATION ERROR");
	}


}
