package com.cognizant.xxClinicDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.xxClinicDetails.controller.AuthClient;
import com.cognizant.xxClinicDetails.model.AuthResponse;
import com.cognizant.xxClinicDetails.model.ClinicDetails;
import com.cognizant.xxClinicDetails.model.StaffDetails;
import com.cognizant.xxClinicDetails.repository.ClinicDetailsRepository;
import com.cognizant.xxClinicDetails.repository.StaffDetailsRepository;

@Service
public class ClinicDetailsServiceImpl implements ClinicDetailsService{
	
	@Autowired
	private ClinicDetailsRepository clinicDetailsRepository;
	
	@Autowired
	private StaffDetailsRepository staffDetailsRepository;
	
	@Autowired
	private AuthClient authClient;
	
	@Transactional
	public List<ClinicDetails> findAllClinicDetails()
	{
		return clinicDetailsRepository.findAll();
	}
	
	@Transactional
	public ClinicDetails findClinicDetailsById(int id)
	{
		return clinicDetailsRepository.findById(id);
	}
	
	@Transactional
	public void addClinicDetails(ClinicDetails clinicDetails)
	{
		clinicDetailsRepository.save(clinicDetails);
	}
	
	@Transactional
	public void editClinicDetails(ClinicDetails clinicDetails)
	{
		clinicDetailsRepository.save(clinicDetails);
	}
	
	@Transactional
	public void removeClinicDetails(ClinicDetails clinicDetails)
	{
		clinicDetailsRepository.deleteById(clinicDetails.getId());
	}
	
	@Transactional
	public List<StaffDetails> findStaffDetailsByClinicId(int clinicId)
	{
		List<StaffDetails> staffDetailsList = staffDetailsRepository.filterStaffDetailsByClinicId(clinicId);
		
		return staffDetailsList;
	}
	
	public boolean isSessionValid(String token)
	{
		try
		{
			@SuppressWarnings("unused")
			AuthResponse authResponse = authClient.getValidity(token);
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	public void addData()
	{
		ClinicDetails clinic1 = new ClinicDetails(1, "CLINIC ONE", "ADDRESS ONE", "CITY ONE", "STATE ONE", "COUNTRY ONE", "9999999999", "EMAILONE@EMAIL.COM");
		ClinicDetails clinic2 = new ClinicDetails(2, "CLINIC TWO", "ADDRESS TWO", "CITY TWO", "STATE TWO", "COUNTRY TWO", "1111111111", "EMAILTWO@EMAIL.COM");
		
		clinicDetailsRepository.save(clinic1);
		clinicDetailsRepository.save(clinic2);
		
		StaffDetails staff1 = new StaffDetails(1, 1, "Krishna", "Cardiologists");
		StaffDetails staff2 = new StaffDetails(2, 1, "Ramesh", "Gynecologists");
		StaffDetails staff3 = new StaffDetails(3, 1, "Suresh", "Ophthalmologists");
		StaffDetails staff4 = new StaffDetails(4, 2, "Rajesh", "Dermatologists");
		StaffDetails staff5 = new StaffDetails(5, 2, "kiran", "Pediatrician");
		StaffDetails staff6 = new StaffDetails(6, 2, "Anuj", "Dentist");
		
		staffDetailsRepository.save(staff1);
		staffDetailsRepository.save(staff2);
		staffDetailsRepository.save(staff3);
		staffDetailsRepository.save(staff4);
		staffDetailsRepository.save(staff5);
		staffDetailsRepository.save(staff6);
	}

}
