package com.cognizant.xxPatientAuthorization.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.xxPatientAuthorization.model.AuthResponse;
import com.cognizant.xxPatientAuthorization.model.PatientDetails;
import com.cognizant.xxPatientAuthorization.model.PatientDetailsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest
@AutoConfigureMockMvc
class PatientDetailsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PatientDetailsController patientDetailsController;
	
	@Test
	public void contextLoads()
	{
		assertNotNull(patientDetailsController);
	}
	
	@Test
	public void loginTestSuccess() throws Exception{
		
		PatientDetails patient = new PatientDetails(1,"patient1","13579",null,null,null,null);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(patient))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void loginTestFail() throws Exception{
		
		PatientDetails patient = new PatientDetails(1,"patient1","13597",null,null,null,null);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(patient))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isForbidden());
	}
	
	@Test
	public void validateTestSuccess() throws Exception
	{
		PatientDetails patient = new PatientDetails(1,"patient1","13579",null,null,null,null);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(patient))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		PatientDetailsDTO patientDetailsDTO =new ObjectMapper().readValue(result.getResponse().getContentAsString(),PatientDetailsDTO.class);
		AuthResponse auth = new AuthResponse("patient1",true);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/validate")
				.header("Authorization", "Bearer " + patientDetailsDTO.getJwtToken()))
				.andExpect(status().isOk());
	}
	
	@Test
	public void validateTestFail() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/validate")
				.header("Authorization", "random token"))
				.andExpect(status().isForbidden());
		
		ResponseEntity<?> response = patientDetailsController.getValidity(null);
		
		assertEquals(403, response.getStatusCodeValue());
	}
	
	@Test
	public void registerPatientTestSuccess() throws Exception
	{   PatientDetails patient = new PatientDetails(3, "patient3", "23680", "Lecter", "9898989898", "mail@gmail.com", "Random Hannibal Address");
		ResultActions actions = mockMvc.perform(post("/registerPatientDetails").contentType(MediaType.APPLICATION_JSON).content(asJsonString(patient)));
    	actions.andExpect(status().isOk());
	}

	@Test
	public void registerPatientTestFail() throws Exception
	{
		
		ResponseEntity<?> response = patientDetailsController.registerPatientDetails(null);
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(),"FORBIDDEN");
		
	}
	
	@Test
	public void updatePatientDetailsTestSuccess() throws Exception{
		PatientDetails patient = new PatientDetails(2, "patient4", "23680", "Lecter", "9898989890", "gmail@gmail.com", "Random Hannibal Address");
		ResultActions actions = mockMvc.perform(post("/updatePatientDetails").contentType(MediaType.APPLICATION_JSON).content(asJsonString(patient)));
    	actions.andExpect(status().isOk());
	}
	@Test
	public void updatePatientDetailsTestFail() throws Exception{
		
		ResponseEntity<?> response = patientDetailsController.updatePatientDetails(null);
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(),"FORBIDDEN");
		
	}
	
	@Test
	public void deletePatientDetailsTestSuccess() throws Exception{
		PatientDetails patient = new PatientDetails(2, "patient1", "13579", "Dexter Morgan", "9876543210", "dexter@gmail.com", "Random Dexter Address");
		ResultActions actions = mockMvc.perform(post("/deletePatientDetails").contentType(MediaType.APPLICATION_JSON).content(asJsonString(patient)));
    	actions.andExpect(status().isOk());	
	}
	
	@Test
	public void deletePatientDetailsTestFail() throws Exception{
		ResponseEntity<?> response = patientDetailsController.deletePatientDetails(null);
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(),"FORBIDDEN");
		
	}
	
	@Test
	public void findPatientDetailsByIdTestSuccess()  throws Exception
	{
		ResultActions actions = mockMvc.perform(get("/findPatientDetailsById/2"));
    	actions.andExpect(status().isOk());	
		
	}

	@Test
	public void findPatientDetailsByIdTestFail()  throws Exception
	{
		ResultActions actions = mockMvc.perform(get("/findPatientDetailsById/6"));
    	actions.andExpect(status().isForbidden());	
		
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
