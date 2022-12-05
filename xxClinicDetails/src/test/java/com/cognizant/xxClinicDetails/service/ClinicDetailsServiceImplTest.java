package com.cognizant.xxClinicDetails.service;

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

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.xxClinicDetails.controller.AuthClient;
import com.cognizant.xxClinicDetails.model.AuthResponse;
import com.cognizant.xxClinicDetails.model.ClinicDetails;
import com.cognizant.xxClinicDetails.model.StaffDetails;
import com.cognizant.xxClinicDetails.repository.ClinicDetailsRepository;
import com.cognizant.xxClinicDetails.repository.StaffDetailsRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class ClinicDetailsServiceImplTest {
	
	@InjectMocks
	private ClinicDetailsServiceImpl clinicDetailsServiceImpl;
	
	@Mock
	private ClinicDetailsRepository clinicDetailsRepository;
	
	@Mock
	private StaffDetailsRepository staffDetailsRepository;
	
	@Mock
	private AuthClient authClient;
	
	@Test
	public void contextLoads() throws Exception
	{
		assertNotNull(clinicDetailsServiceImpl);
	}
	
	@Test
	public void findAllClinicDetailsTestSuccess() throws Exception
	{
		ClinicDetails stubClinicDetails = new ClinicDetails(1, "CLINIC ONE", "ADDRESS ONE", "CITY ONE", "STATE ONE", "COUNTRY ONE", "9999999999", "EMAILONE@EMAIL.COM");
		List<ClinicDetails> stubList = new ArrayList<>();
		stubList.add(stubClinicDetails);
		
		doReturn(stubList).when(clinicDetailsRepository).findAll();
		
		List<ClinicDetails> resultList = clinicDetailsServiceImpl.findAllClinicDetails();
		
		assertNotNull(resultList);
	}
	
	@Test
	public void findAllClinicDetailsTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(clinicDetailsRepository).findAll();
		
		try
		{
			List<ClinicDetails> resultList = clinicDetailsServiceImpl.findAllClinicDetails();
			
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void findClinicDetailsByIdTestSuccess() throws Exception
	{
		doReturn(new ClinicDetails(1, "CLINIC ONE", "ADDRESS ONE", "CITY ONE", "STATE ONE", "COUNTRY ONE", "9999999999", "EMAILONE@EMAIL.COM")).when(clinicDetailsRepository).findById(anyInt());
		
		try
		{
			ClinicDetails clinicDetails = clinicDetailsServiceImpl.findClinicDetailsById(10);
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void findClinicDetailsByIdTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(clinicDetailsRepository).findById(anyInt());
		
		try
		{
			ClinicDetails clinicDetails = clinicDetailsServiceImpl.findClinicDetailsById(10);
			
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void addClinicDetailsTestSuccess() throws Exception
	{
		doReturn(null).when(clinicDetailsRepository).save(any(ClinicDetails.class));
		
		try
		{
			clinicDetailsServiceImpl.addClinicDetails(new ClinicDetails());
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void addClinicDetailsTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(clinicDetailsRepository).save(any(ClinicDetails.class));
		
		try
		{
			clinicDetailsServiceImpl.addClinicDetails(new ClinicDetails());
			
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void editClinicDetailsTestSuccess() throws Exception
	{
		doReturn(null).when(clinicDetailsRepository).save(any(ClinicDetails.class));
		
		try
		{
			clinicDetailsServiceImpl.editClinicDetails(new ClinicDetails());
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void editClinicDetailsTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(clinicDetailsRepository).save(any(ClinicDetails.class));
		
		try
		{
			clinicDetailsServiceImpl.editClinicDetails(new ClinicDetails());
			
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void removeClinicDetailsTestSuccess() throws Exception
	{
		doNothing().when(clinicDetailsRepository).deleteById(anyInt());
		
		try
		{
			clinicDetailsServiceImpl.removeClinicDetails(new ClinicDetails());
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void removeClinicDetailsTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(clinicDetailsRepository).deleteById(anyInt());
		
		try
		{
			clinicDetailsServiceImpl.removeClinicDetails(new ClinicDetails());
			
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void findStaffDetailsByClinicIdTestSuccess() throws Exception
	{
		StaffDetails stubStaffDetails = new StaffDetails(1, 1, "Krishna", "Cardiologists");
		List<StaffDetails> stubList = new ArrayList<>();
		stubList.add(stubStaffDetails);
		
		doReturn(stubList).when(staffDetailsRepository).filterStaffDetailsByClinicId(anyInt());
		
		List<StaffDetails> resultList = clinicDetailsServiceImpl.findStaffDetailsByClinicId(10);
		
		assertNotNull(resultList);
	}
	
	@Test
	public void findStaffDetailsByClinicIdTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(staffDetailsRepository).filterStaffDetailsByClinicId(anyInt());
		
		try
		{
			List<StaffDetails> resultList = clinicDetailsServiceImpl.findStaffDetailsByClinicId(10);
			
			fail();
		}
		catch(Exception e)
		{
			assertTrue(true);
		}
	}

	@Test
	public void isSessionValidTestSuccess() throws Exception
	{
		doReturn(new AuthResponse())
		.when(authClient)
		.getValidity(anyString());
		
		boolean result = clinicDetailsServiceImpl.isSessionValid("token");
		
		assertTrue(result);
	}
	
	@Test
	public void isSessionValidTestFail() throws Exception
	{
		doThrow(NullPointerException.class)
		.when(authClient)
		.getValidity(anyString());
		
		assertFalse(clinicDetailsServiceImpl.isSessionValid("token"));
	}
	
	@Test
	public void addDataTest()
	{
		try 
		{
			clinicDetailsServiceImpl.addData();
		
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
