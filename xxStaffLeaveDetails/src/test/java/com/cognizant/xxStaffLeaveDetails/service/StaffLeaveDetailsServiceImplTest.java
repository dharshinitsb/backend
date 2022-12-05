package com.cognizant.xxStaffLeaveDetails.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.xxStaffLeaveDetails.controller.AuthClient;
import com.cognizant.xxStaffLeaveDetails.model.AuthResponse;
import com.cognizant.xxStaffLeaveDetails.model.BookingDetails;
import com.cognizant.xxStaffLeaveDetails.model.StaffLeaveDetails;
import com.cognizant.xxStaffLeaveDetails.repository.StaffLeaveDetailsRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class StaffLeaveDetailsServiceImplTest {
	
	@InjectMocks
	private StaffLeaveDetailsServiceImpl staffLeaveDetailsServiceImpl;
	
	@Mock
	private StaffLeaveDetailsRepository staffLeaveDetailsRepository;
	
	@Mock
	private AuthClient authClient;
	
	@Test
	public void contextLoads() throws Exception
	{
		assertNotNull(staffLeaveDetailsServiceImpl);
	}
	
	@Test
	public void findAllStaffLeaveDetailsTestSuccess() throws Exception
	{
		StaffLeaveDetails stubStaffLeaveDetails = new StaffLeaveDetails();
		List<StaffLeaveDetails> stubList = new ArrayList<>();
		stubList.add(stubStaffLeaveDetails);
		
		doReturn(stubList).when(staffLeaveDetailsRepository).findAll();
		
		List<StaffLeaveDetails> resultList = staffLeaveDetailsServiceImpl.findAllStaffLeaveDetails();
		
		assertNotNull(resultList);
	}
	
	@Test
	public void findAllStaffLeaveDetailsTestFail() throws Exception
	{
		doReturn(null).when(staffLeaveDetailsRepository).findAll();
		
		List<StaffLeaveDetails> resultList = staffLeaveDetailsServiceImpl.findAllStaffLeaveDetails();
		
		assertNull(resultList);
	}
	
	@Test
	public void addStaffLeaveDetailsTestSuccess() throws Exception
	{
		doReturn(null).when(staffLeaveDetailsRepository).save(any(StaffLeaveDetails.class));
		
		try 
		{
			staffLeaveDetailsServiceImpl.addStaffLeaveDetails(new StaffLeaveDetails());
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void addStaffLeaveDetailsTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(staffLeaveDetailsRepository).save(null);
		
		try 
		{
			staffLeaveDetailsServiceImpl.addStaffLeaveDetails(null);
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void editStaffLeaveDetailsTestSuccess() throws Exception
	{
		doReturn(null).when(staffLeaveDetailsRepository).save(any(StaffLeaveDetails.class));
		
		try 
		{
			staffLeaveDetailsServiceImpl.editStaffLeaveDetails(new StaffLeaveDetails());
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void editStaffLeaveDetailsTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(staffLeaveDetailsRepository).save(null);
		
		try 
		{
			staffLeaveDetailsServiceImpl.editStaffLeaveDetails(null);
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void removeStaffLeaveDetailsTestSuccess() throws Exception
	{
		doNothing().when(staffLeaveDetailsRepository).deleteById(anyInt());
		
		StaffLeaveDetails stub = new StaffLeaveDetails();
		stub.setId(1);
		
		try 
		{
			staffLeaveDetailsServiceImpl.removeStaffLeaveDetails(stub);
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void removeStaffLeaveDetailsTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(staffLeaveDetailsRepository).deleteById(null);
		
		try 
		{
			staffLeaveDetailsServiceImpl.removeStaffLeaveDetails(null);
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void isStaffAvailableTestSuccess() throws Exception
	{
		StaffLeaveDetails stubStaffLeaveDetails = new StaffLeaveDetails(1, 1, "STAFF ONE", "SPECIALTY ONE", LocalDate.of(2022, 12, 15));
		List<StaffLeaveDetails> stubList = new ArrayList<>();
		stubList.add(stubStaffLeaveDetails);
		BookingDetails stubBookingDetails = new BookingDetails(1, "SPECIALTY ONE", 2022, 12, 16);
		
		doReturn(stubList).when(staffLeaveDetailsRepository).checkStaffLeaveDetails(anyInt(), anyString());
		
		Boolean result = staffLeaveDetailsServiceImpl.isStaffAvailable(stubBookingDetails);
		
		assertTrue(result);
	}
	
	@Test
	public void isStaffAvailableTestFail() throws Exception
	{
		StaffLeaveDetails stubStaffLeaveDetails = new StaffLeaveDetails(1, 1, "STAFF ONE", "SPECIALTY ONE", LocalDate.of(2022, 12, 15));
		List<StaffLeaveDetails> stubList = new ArrayList<>();
		stubList.add(stubStaffLeaveDetails);
		BookingDetails stubBookingDetails = new BookingDetails(1, "SPECIALTY ONE", 2022, 12, 15);
		
		doReturn(stubList).when(staffLeaveDetailsRepository).checkStaffLeaveDetails(anyInt(), anyString());
		
		Boolean result = staffLeaveDetailsServiceImpl.isStaffAvailable(stubBookingDetails);
		
		assertFalse(result);
	}
	
	@Test
	public void isSessionValidTestSuccess() throws Exception
	{
		doReturn(new AuthResponse())
		.when(authClient)
		.getValidity(anyString());
		
		boolean result = staffLeaveDetailsServiceImpl.isSessionValid("token");
		
		assertTrue(result);
	}
	
	@Test
	public void isSessionValidTestFail() throws Exception
	{
		doThrow(NullPointerException.class)
		.when(authClient)
		.getValidity(anyString());
		
		assertFalse(staffLeaveDetailsServiceImpl.isSessionValid("token"));
	}
	
	@Test
	public void addDataTest()
	{
		try 
		{
			staffLeaveDetailsServiceImpl.addData();
		
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
