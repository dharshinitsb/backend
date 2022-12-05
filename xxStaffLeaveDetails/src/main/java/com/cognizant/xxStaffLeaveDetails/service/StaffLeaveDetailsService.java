package com.cognizant.xxStaffLeaveDetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.xxStaffLeaveDetails.model.BookingDetails;
import com.cognizant.xxStaffLeaveDetails.model.StaffLeaveDetails;

@Service
public interface StaffLeaveDetailsService {
	
	public List<StaffLeaveDetails> findAllStaffLeaveDetails();
	
	public void addStaffLeaveDetails(StaffLeaveDetails staffLeaveDetails);
	
	public void editStaffLeaveDetails(StaffLeaveDetails staffLeaveDetails);
	
	public void removeStaffLeaveDetails(StaffLeaveDetails staffLeaveDetails);
	
	public boolean isStaffAvailable(BookingDetails bookingDetails);
	
	public boolean isSessionValid(String token);
	
	public void addData();

}
