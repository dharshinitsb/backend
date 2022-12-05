package com.cognizant.xxClinicDetails.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.xxClinicDetails.model.ClinicDetails;
import com.cognizant.xxClinicDetails.model.StaffDetails;
import com.cognizant.xxClinicDetails.service.ClinicDetailsServiceImpl;

@RestController
@CrossOrigin
public class ClinicDetailsController {
	
	@Autowired
	private ClinicDetailsServiceImpl clinicDetailsServiceImpl;
	
	@GetMapping("/getAllClinicDetails")
	public ResponseEntity<?> getAllClinicDetails(@RequestHeader("Authorization") @NotNull String token)
	{
		if(clinicDetailsServiceImpl.isSessionValid(token))
		{
			List<ClinicDetails> clinicDetailsList = clinicDetailsServiceImpl.findAllClinicDetails();
			
			return new ResponseEntity<>(clinicDetailsList, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION FAILURE", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/createClinicDetails")
	public ResponseEntity<?> createClinicDetails(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull ClinicDetails clinicDetails)
	{
		if(clinicDetailsServiceImpl.isSessionValid(token))
		{
			clinicDetailsServiceImpl.addClinicDetails(clinicDetails);
			
			return new ResponseEntity<>("CREATED CLINIC DETAILS SUCCESSFULLY", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION FAILURE", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/updateClinicDetails")
	public ResponseEntity<?> updateClinicDetails(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull ClinicDetails clinicDetails)
	{
		if(clinicDetailsServiceImpl.isSessionValid(token))
		{
			clinicDetailsServiceImpl.editClinicDetails(clinicDetails);
			
			return new ResponseEntity<>("UPDATED CLINIC DETAILS SUCCESSFULLY", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION FAILURE", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/deleteClinicDetails")
	public ResponseEntity<?> deleteClinicDetails(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull ClinicDetails clinicDetails)
	{
		if(clinicDetailsServiceImpl.isSessionValid(token))
		{
			clinicDetailsServiceImpl.removeClinicDetails(clinicDetails);
			
			return new ResponseEntity<>("DELETED CLINIC DETAILS SUCCESSFULLY", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION FAILURE", HttpStatus.FORBIDDEN);
	}
	
	@GetMapping("/getStaffDetailsByClinicId/{clinicId}")
	public ResponseEntity<?> getStaffDetailsByClinicId(@RequestHeader("Authorization") @NotNull String token, @PathVariable @NotNull int clinicId)
	{
		if(clinicDetailsServiceImpl.isSessionValid(token))
		{
			List<StaffDetails> staffDetailsList = clinicDetailsServiceImpl.findStaffDetailsByClinicId(clinicId);
			
			return new ResponseEntity<>(staffDetailsList, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION FAILURE", HttpStatus.FORBIDDEN);
	}
	
	@GetMapping("/getClinicDetailsById/{id}")
	public ResponseEntity<?> getClinicDetailsById(@RequestHeader("Authorization") @NotNull String token, @PathVariable int id)
	{
		if(clinicDetailsServiceImpl.isSessionValid(token))
		{
			ClinicDetails clinicDetails = clinicDetailsServiceImpl.findClinicDetailsById(id);
			
			return new ResponseEntity<>(clinicDetails, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION FAILURE", HttpStatus.FORBIDDEN);
	}

}
