package com.cognizant.xxAppointmentDetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.xxAppointmentDetails.model.AppointmentDetailsDTO;

@Service
public interface AppointmentDetailsService {
	
	public List<AppointmentDetailsDTO> findAllAppointmentDetails();
	
	public void addAppointmentDetails(AppointmentDetailsDTO appointmentDetailsDTO);
	
	public void editAppointmentDetails(AppointmentDetailsDTO appointmentDetailsDTO);
	
	public void removeAppointmentDetails(AppointmentDetailsDTO appointmentDetailsDTO);
	
	public List<AppointmentDetailsDTO> findAppointmentDetailsByPatientId(int patientId);
	
	public List<AppointmentDetailsDTO> findAppointmentDetailsByClinicId(int clinicId);
	
	public boolean isSlotAvailable(AppointmentDetailsDTO appointmentDetailsDTO);
	
	public boolean isSessionValid(String token);
	
	public void addData();

}
