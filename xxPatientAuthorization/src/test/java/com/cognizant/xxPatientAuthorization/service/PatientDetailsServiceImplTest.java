package com.cognizant.xxPatientAuthorization.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.xxPatientAuthorization.model.PatientDetails;
import com.cognizant.xxPatientAuthorization.repository.PatientDetailsRepository;
@SpringBootTest
@AutoConfigureMockMvc
class PatientDetailsServiceImplTest {
	@Autowired
	private PatientDetailsServiceImpl patientDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private PatientDetailsRepository patientDetailsRepository;
	
	@Test
	public void contextLoads()
	{
		assertNotNull(patientDetailsService);
	}
	
	@Test
	public void loadUserByUsernameTestSuccess()
	{
		assertEquals("patient1",patientDetailsService.loadUserByUsername("patient1").getUsername());
		
	}
	
	@Test
	public void loadUserByUsernameTestFail()
	{
		try
		{
			assertEquals("randomuser", patientDetailsService.loadUserByUsername("randomuser").getUsername());
			fail();
		}
		catch(UsernameNotFoundException e)
		{
			assertTrue(true);
		}
	}
	@Test
	public void createPatientDetailsTestSuccess()
	{
		PatientDetails patient = new PatientDetails(3, "patient3", "23680", "Lecter", "9898989898", "mail@gmail.com", "Random Hannibal Address");
		patient.setPassword(passwordEncoder.encode(patient.getPassword()));
		patientDetailsRepository.save(patient);
		assertTrue(patientDetailsRepository.existsById(3));
	}
	@Test
	public void createPatientDetailsTestFail()
	{
		PatientDetails patient = new PatientDetails(9, "patient3", "23680", "Lecter", "9898989898", "mail@gmail.com", "Random Hannibal Address");
		patient.setPassword(passwordEncoder.encode(patient.getPassword()));
		assertFalse(patientDetailsRepository.existsById(9));
	}
	@Test
	public void editPatientDetailsTestSuccess()
	{
		PatientDetails patient = new PatientDetails(1, "UpdatedPatient", "23680", "Lecter", "98980000", "mail@gmaiil.com", "Random Hannibal Address");
		patient.setPassword(passwordEncoder.encode(patient.getPassword()));
		patientDetailsRepository.save(patient);
	    assertEquals(patient.getUsername(),patientDetailsRepository.findById(1).getUsername());
	}
	@Test
	public void editPatientDetailsTestFail()
	{
		PatientDetails patient = new PatientDetails(3, "NotUpdatedPatient", "23680", "Lecter", "98980000", "mail@gmaiil.com", "Random Hannibal Address");
		patient.setPassword(passwordEncoder.encode(patient.getPassword()));
		
		 assertNotEquals(patient.getUsername(),patientDetailsRepository.findById(3).getUsername());
	}
	
	@Test
	public void removePatientTestSuccess()
	{
		patientDetailsRepository.deleteById(1);
		assertFalse(patientDetailsRepository.existsById(1));
	}
	
	@Test
	public void getPatientDetailsByIdTestSuccess()
	{
		assertNotNull(patientDetailsRepository.findById(1));
	}
	@Test
	public void getPatientDetailsByIdTestFail()
	{
		assertNull(patientDetailsRepository.findById(6));
	}
	
	@Test
	public void addDataTestSuccess()
	{	
		PatientDetails patient = new PatientDetails( "patient3", "23680", "Lecter", "9898989898", "mail@gmail.com", "Random Hannibal Address");
		patientDetailsService.addData();
		assertTrue(true);
	}
	
	
	
}
