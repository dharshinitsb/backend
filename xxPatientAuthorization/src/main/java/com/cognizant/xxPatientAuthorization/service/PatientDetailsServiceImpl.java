package com.cognizant.xxPatientAuthorization.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.xxPatientAuthorization.model.PatientDetails;
import com.cognizant.xxPatientAuthorization.repository.PatientDetailsRepository;

@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(PatientDetailsServiceImpl.class);
	
	@Autowired
	private PatientDetailsRepository patientDetailsRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username)
	{
		logger.info("METHOD EXECUTION START");
		
		try
		{
			PatientDetails patientDetails = patientDetailsRepository.findByUsername(username);
			
			                               
			if(patientDetails != null)
			{
				logger.info("METHOD EXECUTION END - USER FOUND");
				return new User(patientDetails.getUsername(), patientDetails.getPassword(),new ArrayList<>());
			}
			else
			{
				logger.info("METHOD EXECUTION END - USERNAME NOT FOUND");
				throw new UsernameNotFoundException("UsernameNotFoundException");
			}
		}
		
		catch (Exception e)
		{
			logger.info("EXCEPTION THROWN");
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}
		
	}
	
	@Transactional
	public void addPatientDetails(PatientDetails patientDetails)
	{
		patientDetails.setPassword(passwordEncoder.encode(patientDetails.getPassword()));
		
		patientDetailsRepository.save(patientDetails);
	}
	
	@Transactional
	public void editPatientDetails(PatientDetails patientDetails)
	{
		patientDetails.setPassword(passwordEncoder.encode(patientDetails.getPassword()));
		
		patientDetailsRepository.save(patientDetails);
	}
	
	@Transactional
	public void removePatientDetails(PatientDetails patientDetails)
	{
		patientDetailsRepository.deleteById(patientDetails.getId());
	}
	
	@Transactional
	public PatientDetails getPatientDetailsById(int id)
	{
		PatientDetails patientDetails = patientDetailsRepository.findById(id);
		PatientDetails returnObj = new PatientDetails(patientDetails.getId(), patientDetails.getUsername(), null, patientDetails.getPatientName(),
														patientDetails.getContactNumber(), patientDetails.getEmailId(), patientDetails.getAddress());
		
		return returnObj;
	}
	
	@Transactional
	public void addData()
	{
		PatientDetails patient1 = new PatientDetails(1, "patient1", passwordEncoder.encode("13579"), "Dexter Morgan", "9876543210", "dexter@gmail.com", "Chennai");
		patientDetailsRepository.save(patient1);
		
		PatientDetails patient2 = new PatientDetails(2, "patient2", passwordEncoder.encode("24680"), "Hannibal Lecter", "9999999999", "hannibal@gmail.com", "chennai");
		patientDetailsRepository.save(patient2);
		
		PatientDetails patient3 = new PatientDetails(3, "admin", passwordEncoder.encode("12345"), "krish", "6303065650", "krish@gmail.com", "Hyderabad");
		patientDetailsRepository.save(patient3);
		
		
	}
	public PatientDetails getPatient(String username) {
		return patientDetailsRepository.findByUsername(username);
	}

}
