package com.cognizant.xxAppointmentDetails.controller;

import java.util.List;

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

import com.cognizant.xxAppointmentDetails.model.AppointmentDetailsDTO;
import com.cognizant.xxAppointmentDetails.service.AppointmentDetailsServiceImpl;

@RestController
@CrossOrigin
public class AppointmentDetailsController {
	
	@Autowired
	private AppointmentDetailsServiceImpl appointmentDetailsServiceImpl;
	
	@GetMapping("/getAllAppointmentDetails")
	public ResponseEntity<?> getAllAppointmentDetails(@RequestHeader("Authorization") String token)
	{
		if(appointmentDetailsServiceImpl.isSessionValid(token))
		{
			List<AppointmentDetailsDTO> appointmentDetailsDTOList = appointmentDetailsServiceImpl.findAllAppointmentDetails();
			
			return new ResponseEntity<>(appointmentDetailsDTOList, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/createAppointmentDetails")
	public ResponseEntity<?> createAppointmentDetails(@RequestHeader("Authorization") String token, @RequestBody AppointmentDetailsDTO appointmentDetailsDTO)
	{
		if(appointmentDetailsServiceImpl.isSessionValid(token))
		{
			if(appointmentDetailsServiceImpl.isSlotAvailable(appointmentDetailsDTO))
			{
				appointmentDetailsServiceImpl.addAppointmentDetails(appointmentDetailsDTO);
				
				return new ResponseEntity<>("CREATED APPOINTMENT DETAILS SUCCESSFULLY", HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>("SLOT UNAVAILABLE", HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/updateAppointmentDetails")
	public ResponseEntity<?> updateAppointmentDetails(@RequestHeader("Authorization") String token, @RequestBody AppointmentDetailsDTO appointmentDetailsDTO)
	{
		if(appointmentDetailsServiceImpl.isSessionValid(token))
		{
			if(appointmentDetailsServiceImpl.isSlotAvailable(appointmentDetailsDTO))
			{
				appointmentDetailsServiceImpl.editAppointmentDetails(appointmentDetailsDTO);
				
				return new ResponseEntity<>("UPDATED APPOINTMENT DETAILS SUCCESSFULLY", HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>("SLOT UNAVAILABLE", HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/deleteAppointmentDetails")
	public ResponseEntity<?> deleteAppointmentDetails(@RequestHeader("Authorization") String token, @RequestBody AppointmentDetailsDTO appointmentDetailsDTO)
	{
		if(appointmentDetailsServiceImpl.isSessionValid(token))
		{
			appointmentDetailsServiceImpl.removeAppointmentDetails(appointmentDetailsDTO);
			
			return new ResponseEntity<>("DELETED APPOINTMENT DETAILS SUCCESSFULLY", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@GetMapping("/getAppointmentDetailsByPatientId/{patientId}")
	public ResponseEntity<?> getAppointmentDetailsByPatientId(@RequestHeader("Authorization") String token, @PathVariable int patientId)
	{
		if(appointmentDetailsServiceImpl.isSessionValid(token))
		{
			List<AppointmentDetailsDTO> appointmentDetailsDTOList = appointmentDetailsServiceImpl.findAppointmentDetailsByPatientId(patientId);
			
			return new ResponseEntity<>(appointmentDetailsDTOList, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@GetMapping("/getAppointmentDetailsByClinicId/{clinicId}")
	public ResponseEntity<?> getAppointmentDetailsByClinicId(@RequestHeader("Authorization") String token, @PathVariable int clinicId)
	{
		if(appointmentDetailsServiceImpl.isSessionValid(token))
		{
			List<AppointmentDetailsDTO> appointmentDetailsDTOList = appointmentDetailsServiceImpl.findAppointmentDetailsByClinicId(clinicId);
			
			return new ResponseEntity<>(appointmentDetailsDTOList, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}

}
