package com.cognizant.xxClinicDetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.xxClinicDetails.model.ClinicDetails;

@Service
public interface ClinicDetailsService {
	
	public List<ClinicDetails> findAllClinicDetails();
	
	public void addClinicDetails(ClinicDetails clinicDetails);
	
	public void editClinicDetails(ClinicDetails clinicDetails);
	
	public void removeClinicDetails(ClinicDetails clinicDetails);
	
	public boolean isSessionValid(String token);

}
