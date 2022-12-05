package com.cognizant.xxStaffLeaveDetails.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.xxStaffLeaveDetails.controller.AuthClient;
import com.cognizant.xxStaffLeaveDetails.model.AuthResponse;
import com.cognizant.xxStaffLeaveDetails.model.BookingDetails;
import com.cognizant.xxStaffLeaveDetails.model.StaffLeaveDetails;
import com.cognizant.xxStaffLeaveDetails.repository.StaffLeaveDetailsRepository;

@Service
public class StaffLeaveDetailsServiceImpl implements StaffLeaveDetailsService {
	
	@Autowired
	private StaffLeaveDetailsRepository staffLeaveDetailsRepository;
	
	@Autowired
	private AuthClient authClient;
	
	@Transactional
	public List<StaffLeaveDetails> findAllStaffLeaveDetails()
	{
		List<StaffLeaveDetails> resultList = staffLeaveDetailsRepository.findAll();
		
		return resultList;
	}
	
	@Transactional
	public void addStaffLeaveDetails(StaffLeaveDetails staffLeaveDetails)
	{
		staffLeaveDetailsRepository.save(staffLeaveDetails);
	}
	
	@Transactional
	public void editStaffLeaveDetails(StaffLeaveDetails staffLeaveDetails)
	{
		staffLeaveDetailsRepository.save(staffLeaveDetails);
	}
	
	@Transactional
	public void removeStaffLeaveDetails(StaffLeaveDetails staffLeaveDetails)
	{
		staffLeaveDetailsRepository.deleteById(staffLeaveDetails.getId());
	}
	
	public boolean isStaffAvailable(BookingDetails bookingDetails)
	{
		List<StaffLeaveDetails> staffLeaveDetailsList = staffLeaveDetailsRepository.checkStaffLeaveDetails(bookingDetails.getClinicId(), bookingDetails.getSpecialty());
		
		boolean staffAvailable=true;
		
		for(StaffLeaveDetails staffLeaveDetails:staffLeaveDetailsList)
		{
			if(bookingDetails.getAppointmentDateYear()==staffLeaveDetails.getLeaveDate().getYear() && bookingDetails.getAppointmentDateMonth()==staffLeaveDetails.getLeaveDate().getMonthValue() && bookingDetails.getAppointmentDateDay()==staffLeaveDetails.getLeaveDate().getDayOfMonth())
			{
				staffAvailable = false;
				break;
			}
		}
		
		return staffAvailable;
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
		StaffLeaveDetails staffLeaveDetails1 = new StaffLeaveDetails(1, 1, "Krishna", "Cardiologists", LocalDate.of(2022, 12, 15));
		StaffLeaveDetails staffLeaveDetails2 = new StaffLeaveDetails(2, 1, "Ramesh", "Gynecologists", LocalDate.of(2022, 12, 20));
		StaffLeaveDetails staffLeaveDetails3 = new StaffLeaveDetails(2, 2, "Rajesh", "Dermatologists", LocalDate.of(2022, 12, 25));
		
		staffLeaveDetailsRepository.save(staffLeaveDetails1);
		staffLeaveDetailsRepository.save(staffLeaveDetails2);
		staffLeaveDetailsRepository.save(staffLeaveDetails3);
	}

}
