package com.cognizant.xxStaffLeaveDetails.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
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

import com.cognizant.xxStaffLeaveDetails.model.BookingDetails;
import com.cognizant.xxStaffLeaveDetails.model.StaffLeaveDetails;
import com.cognizant.xxStaffLeaveDetails.service.StaffLeaveDetailsServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class StaffLeaveDetailsControllerTest {
	
	@InjectMocks
	private StaffLeaveDetailsController staffLeaveDetailsController;
	
	@Mock
	private StaffLeaveDetailsServiceImpl staffLeaveDetailsServiceImpl;
	
	@Test
	public void contextLoads() throws Exception
	{
		assertNotNull(staffLeaveDetailsController);
	}
	
	@Test
	public void getAllStaffLeaveDetailsTestSuccess() throws Exception
	{
		StaffLeaveDetails stubStaffLeaveDetails = new StaffLeaveDetails();
		List<StaffLeaveDetails> stubList = new ArrayList<>();
		stubList.add(stubStaffLeaveDetails);
		
		doReturn(stubList).when(staffLeaveDetailsServiceImpl).findAllStaffLeaveDetails();
		doReturn(true).when(staffLeaveDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = staffLeaveDetailsController.getAllStaffLeaveDetails("token");
		
		assertEquals(response.getStatusCodeValue(), 200);
		assertNotNull(response.getBody());	
	}
	
	@Test
	public void getAllStaffLeaveDetailsTestFail() throws Exception
	{
		StaffLeaveDetails stubStaffLeaveDetails = new StaffLeaveDetails();
		List<StaffLeaveDetails> stubList = new ArrayList<>();
		stubList.add(stubStaffLeaveDetails);
		
		doReturn(stubList).when(staffLeaveDetailsServiceImpl).findAllStaffLeaveDetails();
		doReturn(false).when(staffLeaveDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = staffLeaveDetailsController.getAllStaffLeaveDetails("token");
		
		assertEquals(response.getStatusCodeValue(), 403);
		assertEquals(response.getBody(), "AUTHORIZATION ERROR");	
	}
	
	@Test
	public void createStaffLeaveDetailsTestSuccess() throws Exception
	{
		doNothing().when(staffLeaveDetailsServiceImpl).addStaffLeaveDetails(any(StaffLeaveDetails.class));
		doReturn(true).when(staffLeaveDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = staffLeaveDetailsController.createStaffLeaveDetails("token", new StaffLeaveDetails());
		
		assertEquals(response.getStatusCodeValue(), 200);
		assertEquals(response.getBody(), "CREATED STAFF LEAVE DETAILS SUCCESSFULLY");	
	}
	
	@Test
	public void createStaffLeaveDetailsTestFail() throws Exception
	{
		doNothing().when(staffLeaveDetailsServiceImpl).addStaffLeaveDetails(any(StaffLeaveDetails.class));
		doReturn(false).when(staffLeaveDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = staffLeaveDetailsController.createStaffLeaveDetails("token", new StaffLeaveDetails());
		
		assertEquals(response.getStatusCodeValue(), 403);
		assertEquals(response.getBody(), "AUTHORIZATION ERROR");	
	}
	
	@Test
	public void updateStaffLeaveDetailsTestSuccess() throws Exception
	{
		doNothing().when(staffLeaveDetailsServiceImpl).editStaffLeaveDetails(any(StaffLeaveDetails.class));
		doReturn(true).when(staffLeaveDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = staffLeaveDetailsController.updateStaffLeaveDetails("token", new StaffLeaveDetails());
		
		assertEquals(response.getStatusCodeValue(), 200);
		assertEquals(response.getBody(), "UPDATED STAFF LEAVE DETAILS SUCCESSFULLY");	
	}
	
	@Test
	public void updateStaffLeaveDetailsTestFail() throws Exception
	{
		doNothing().when(staffLeaveDetailsServiceImpl).editStaffLeaveDetails(any(StaffLeaveDetails.class));
		doReturn(false).when(staffLeaveDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = staffLeaveDetailsController.updateStaffLeaveDetails("token", new StaffLeaveDetails());
		
		assertEquals(response.getStatusCodeValue(), 403);
		assertEquals(response.getBody(), "AUTHORIZATION ERROR");	
	}
	
	@Test
	public void deleteStaffLeaveDetailsTestSuccess() throws Exception
	{
		doNothing().when(staffLeaveDetailsServiceImpl).removeStaffLeaveDetails(any(StaffLeaveDetails.class));
		doReturn(true).when(staffLeaveDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = staffLeaveDetailsController.deleteStaffLeaveDetails("token", new StaffLeaveDetails());
		
		assertEquals(response.getStatusCodeValue(), 200);
		assertEquals(response.getBody(), "DELETED STAFF LEAVE DETAILS SUCCESSFULLY");	
	}
	
	@Test
	public void deleteStaffLeaveDetailsTestFail() throws Exception
	{
		doNothing().when(staffLeaveDetailsServiceImpl).removeStaffLeaveDetails(any(StaffLeaveDetails.class));
		doReturn(false).when(staffLeaveDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response = staffLeaveDetailsController.deleteStaffLeaveDetails("token", new StaffLeaveDetails());
		
		assertEquals(response.getStatusCodeValue(), 403);
		assertEquals(response.getBody(), "AUTHORIZATION ERROR");	
	}
	
	@Test
	public void checkStaffAvailabilityTestSuccess() throws Exception
	{
		doReturn(true).when(staffLeaveDetailsServiceImpl).isSessionValid(anyString());
		doReturn(true).when(staffLeaveDetailsServiceImpl).isStaffAvailable(any(BookingDetails.class));
		
		ResponseEntity<?> response1 = staffLeaveDetailsController.checkStaffAvailability("token", new BookingDetails());
		
		assertEquals(response1.getStatusCodeValue(), 200);
		assertEquals(response1.getBody(), "STAFF AVAILABLE");
		
		doReturn(true).when(staffLeaveDetailsServiceImpl).isSessionValid(anyString());
		doReturn(false).when(staffLeaveDetailsServiceImpl).isStaffAvailable(any(BookingDetails.class));
		
		ResponseEntity<?> response2 = staffLeaveDetailsController.checkStaffAvailability("token", new BookingDetails());
		
		assertEquals(response2.getStatusCodeValue(), 200);
		assertEquals(response2.getBody(), "STAFF UNAVAILABLE");
	}
	
	@Test
	public void checkStaffAvailabilityTestFail() throws Exception
	{
		doReturn(false).when(staffLeaveDetailsServiceImpl).isSessionValid(anyString());
		
		ResponseEntity<?> response1 = staffLeaveDetailsController.checkStaffAvailability("token", new BookingDetails());
		
		assertEquals(response1.getStatusCodeValue(), 403);
		assertEquals(response1.getBody(), "AUTHORIZATION ERROR");
	}


}
