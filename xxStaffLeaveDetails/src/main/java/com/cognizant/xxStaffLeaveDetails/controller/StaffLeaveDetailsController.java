package com.cognizant.xxStaffLeaveDetails.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.xxStaffLeaveDetails.model.BookingDetails;
import com.cognizant.xxStaffLeaveDetails.model.StaffLeaveDetails;
import com.cognizant.xxStaffLeaveDetails.service.StaffLeaveDetailsServiceImpl;

@RestController
@CrossOrigin
public class StaffLeaveDetailsController {
	
	@Autowired
	private StaffLeaveDetailsServiceImpl staffLeaveDetailsServiceImpl;
	
	@GetMapping("/getAllStaffLeaveDetails")
	public ResponseEntity<?> getAllStaffLeaveDetails(@RequestHeader("Authorization") @NotNull String token)
	{
		if(staffLeaveDetailsServiceImpl.isSessionValid(token))
		{
			List<StaffLeaveDetails> staffLeaveDetailsList = staffLeaveDetailsServiceImpl.findAllStaffLeaveDetails();
			
			return new ResponseEntity<>(staffLeaveDetailsList, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/createStaffLeaveDetails")
	public ResponseEntity<?> createStaffLeaveDetails(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull StaffLeaveDetails staffLeaveDetails)
	{
		if(staffLeaveDetailsServiceImpl.isSessionValid(token))
		{
			staffLeaveDetailsServiceImpl.addStaffLeaveDetails(staffLeaveDetails);
			
			return new ResponseEntity<>("CREATED STAFF LEAVE DETAILS SUCCESSFULLY", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/updateStaffLeaveDetails")
	public ResponseEntity<?> updateStaffLeaveDetails(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull StaffLeaveDetails staffLeaveDetails)
	{
		if(staffLeaveDetailsServiceImpl.isSessionValid(token))
		{
			staffLeaveDetailsServiceImpl.editStaffLeaveDetails(staffLeaveDetails);
			
			return new ResponseEntity<>("UPDATED STAFF LEAVE DETAILS SUCCESSFULLY", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/deleteStaffLeaveDetails")
	public ResponseEntity<?> deleteStaffLeaveDetails(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull StaffLeaveDetails staffLeaveDetails)
	{
		if(staffLeaveDetailsServiceImpl.isSessionValid(token))
		{
			staffLeaveDetailsServiceImpl.removeStaffLeaveDetails(staffLeaveDetails);
			
			return new ResponseEntity<>("DELETED STAFF LEAVE DETAILS SUCCESSFULLY", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/checkStaffAvailability")
	public ResponseEntity<?> checkStaffAvailability(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull BookingDetails bookingDetails)
	{
		if(staffLeaveDetailsServiceImpl.isSessionValid(token))
		{
			boolean isStaffAvailable = staffLeaveDetailsServiceImpl.isStaffAvailable(bookingDetails);
			
			if(isStaffAvailable)
			{
				return new ResponseEntity<>("STAFF AVAILABLE", HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>("STAFF UNAVAILABLE", HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	

}
