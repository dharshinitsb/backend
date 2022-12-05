package com.cognizant.xxClinicDetails.controller;

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

import com.cognizant.xxClinicDetails.model.ClinicDetails;
import com.cognizant.xxClinicDetails.model.StaffDetails;
import com.cognizant.xxClinicDetails.service.ClinicDetailsServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class ClinicDetailsControllerTest {
	
	@InjectMocks
	private ClinicDetailsController clinicDetailsController;
	
	@Mock
	private ClinicDetailsServiceImpl clinicDetailsServiceImpl;
	
	@Test
	public void contextLoads() throws Exception
	{
		assertNotNull(clinicDetailsController);
	}
	
	@Test
	public void getAllClinicDetailsTestSuccess() throws Exception
	{
		ClinicDetails stubClinicDetails = new ClinicDetails(1, "CLINIC ONE", "ADDRESS ONE", "CITY ONE", "STATE ONE", "COUNTRY ONE", "9999999999", "EMAILONE@EMAIL.COM");
		List<ClinicDetails> stubList = new ArrayList<>();
		stubList.add(stubClinicDetails);
		
		doReturn(true).when(clinicDetailsServiceImpl).isSessionValid(anyString());
		doReturn(stubList).when(clinicDetailsServiceImpl).findAllClinicDetails();
		
		ResponseEntity<?> response = clinicDetailsController.getAllClinicDetails("token");
		
		assertEquals(response.getStatusCodeValue(),200);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void getAllClinicDetailsTestFail() throws Exception
	{
		doReturn(false).when(clinicDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = clinicDetailsController.getAllClinicDetails("token");
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(),"AUTHORIZATION FAILURE");
	}
	
	@Test
	public void createClinicDetailsTestSuccess() throws Exception
	{
		doReturn(true).when(clinicDetailsServiceImpl).isSessionValid(anyString());
		doNothing().when(clinicDetailsServiceImpl).addClinicDetails(any(ClinicDetails.class));
		
		ResponseEntity<?> response = clinicDetailsController.createClinicDetails("token", new ClinicDetails());
		
		assertEquals(response.getStatusCodeValue(),200);
		assertEquals(response.getBody(),"CREATED CLINIC DETAILS SUCCESSFULLY");
	}
	
	@Test
	public void createClinicDetailsTestFail() throws Exception
	{
		doReturn(false).when(clinicDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = clinicDetailsController.createClinicDetails("token", new ClinicDetails());
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(),"AUTHORIZATION FAILURE");
	}
	
	@Test
	public void updateClinicDetailsTestSuccess() throws Exception
	{
		doReturn(true).when(clinicDetailsServiceImpl).isSessionValid(anyString());
		doNothing().when(clinicDetailsServiceImpl).editClinicDetails(any(ClinicDetails.class));
		
		ResponseEntity<?> response = clinicDetailsController.updateClinicDetails("token", new ClinicDetails());
		
		assertEquals(response.getStatusCodeValue(),200);
		assertEquals(response.getBody(),"UPDATED CLINIC DETAILS SUCCESSFULLY");
	}
	
	@Test
	public void updateClinicDetailsTestFail() throws Exception
	{
		doReturn(false).when(clinicDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = clinicDetailsController.updateClinicDetails("token", new ClinicDetails());
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(),"AUTHORIZATION FAILURE");
	}
	
	@Test
	public void deleteClinicDetailsTestSuccess() throws Exception
	{
		doReturn(true).when(clinicDetailsServiceImpl).isSessionValid(anyString());
		doNothing().when(clinicDetailsServiceImpl).removeClinicDetails(any(ClinicDetails.class));
		
		ResponseEntity<?> response = clinicDetailsController.deleteClinicDetails("token", new ClinicDetails());
		
		assertEquals(response.getStatusCodeValue(),200);
		assertEquals(response.getBody(),"DELETED CLINIC DETAILS SUCCESSFULLY");
	}
	
	@Test
	public void deleteClinicDetailsTestFail() throws Exception
	{
		doReturn(false).when(clinicDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = clinicDetailsController.deleteClinicDetails("token", new ClinicDetails());
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(),"AUTHORIZATION FAILURE");
	}
	
	@Test
	public void getStaffDetailsByClinicIdTestSuccess() throws Exception
	{
		StaffDetails stubStaffDetails = new StaffDetails(1, 1, "Krishna", "Cardiologists");
		List<StaffDetails> stubList = new ArrayList<>();
		stubList.add(stubStaffDetails);
		
		doReturn(true).when(clinicDetailsServiceImpl).isSessionValid(anyString());
		doReturn(stubList).when(clinicDetailsServiceImpl).findStaffDetailsByClinicId(anyInt());
		
		ResponseEntity<?> response = clinicDetailsController.getStaffDetailsByClinicId("token", 10);
		
		assertEquals(response.getStatusCodeValue(),200);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void getStaffDetailsByClinicIdTestFail() throws Exception
	{
		doReturn(false).when(clinicDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = clinicDetailsController.getStaffDetailsByClinicId("token", 10);
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(),"AUTHORIZATION FAILURE");
	}
	
	@Test
	public void getClinicDetailsByIdTestSuccess() throws Exception
	{
		doReturn(true).when(clinicDetailsServiceImpl).isSessionValid(anyString());
		doReturn(new ClinicDetails(1, "CLINIC ONE", "ADDRESS ONE", "CITY ONE", "STATE ONE", "COUNTRY ONE", "9999999999", "EMAILONE@EMAIL.COM")).when(clinicDetailsServiceImpl).findClinicDetailsById(anyInt());
		
		ResponseEntity<?> response = clinicDetailsController.getClinicDetailsById("token", 10);
		
		assertEquals(response.getStatusCodeValue(),200);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void getClinicDetailsByIdTestFail() throws Exception
	{
		doReturn(false).when(clinicDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = clinicDetailsController.getClinicDetailsById("token", 10);
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(),"AUTHORIZATION FAILURE");
	}


}
