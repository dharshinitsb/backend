package com.cognizant.xxPatientAuthorization.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.xxPatientAuthorization.model.PatientDetails;
import com.cognizant.xxPatientAuthorization.model.PatientDetailsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest
@AutoConfigureMockMvc
class JWTUtilTest {

	@Autowired
	private PatientDetailsServiceImpl patientDetailsService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Test
	public void contextLoads()
	{
		assertNotNull(jwtUtil);
	}
	
	@Test
	public void generateTokenTestSuccess()
	{
		UserDetails userDetails =patientDetailsService.loadUserByUsername("patient1");
		
		String token = jwtUtil.generateToken(userDetails);
		assertNotNull(token);
	}
	
	@Test
	public void generateTokenTestFail()
	{
		try
		{
		
			UserDetails userDetails = patientDetailsService.loadUserByUsername("randomuser");
		
			String token = jwtUtil.generateToken(userDetails);
			fail();
		}
		catch(UsernameNotFoundException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void extractUsernameTestSuccess() throws Exception
	{
		PatientDetails patient = new PatientDetails(1,"patient1","13579",null,null,null,null);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(patient))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		PatientDetailsDTO patientDetailsDTO = new ObjectMapper().readValue(result.getResponse().getContentAsString(),PatientDetailsDTO.class);
		
		assertEquals("patient1", jwtUtil.extractUsername(patientDetailsDTO.getJwtToken()));
	}
	
	@Test
	public void extractUsernameTestFail() throws Exception
	{
		PatientDetails patient = new PatientDetails(1,"patient1","13579",null,null,null,null);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(patient))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		
		PatientDetailsDTO patientDetailsDTO = new ObjectMapper().readValue(result.getResponse().getContentAsString(),PatientDetailsDTO.class);
		
		assertNotEquals("patient", jwtUtil.extractUsername(patientDetailsDTO.getJwtToken()));
	}
	
	@Test
	public void validateTokenTestSuccess() throws Exception
	{
		PatientDetails patient = new PatientDetails(1,"patient1","13579",null,null,null,null);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(patient))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		PatientDetailsDTO patientDetailsDTO = new ObjectMapper().readValue(result.getResponse().getContentAsString(),PatientDetailsDTO.class);
		
		assertTrue(jwtUtil.validateToken(patientDetailsDTO.getJwtToken()));
	}
	
	@Test
	public void validateTokenTestFail() throws Exception
	{
		assertFalse(jwtUtil.validateToken("randomtoken"));
	}
	
	@Test
	public void extractExpirationTestSuccess() throws Exception
	{
		PatientDetails patient = new PatientDetails(1,"patient1","13579",null,null,null,null);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(patient))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		
		PatientDetailsDTO patientDetailsDTO = new ObjectMapper().readValue(result.getResponse().getContentAsString(),PatientDetailsDTO.class); 
		
		assertNotNull(jwtUtil.extractExpiration(patientDetailsDTO.getJwtToken()));
	}
	
	@Test
	public void isTokenExpiredTestSuccess() throws Exception
	{
		PatientDetails patient = new PatientDetails(1,"patient1","13579",null,null,null,null);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(patient))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		PatientDetailsDTO patientDetailsDTO =new ObjectMapper().readValue(result.getResponse().getContentAsString(),PatientDetailsDTO.class);
		
		assertFalse(jwtUtil.isTokenExpired(patientDetailsDTO.getJwtToken()));
	}
	
	public static String asJsonString(PatientDetails patientDetails)
	{
		try
		{
			return new ObjectMapper().writeValueAsString(patientDetails);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}




}
