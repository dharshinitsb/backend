package com.cognizant.xxAppointmentDetails.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.xxAppointmentDetails.controller.AuthClient;
import com.cognizant.xxAppointmentDetails.model.AppointmentDetails;
import com.cognizant.xxAppointmentDetails.model.AppointmentDetailsDTO;
import com.cognizant.xxAppointmentDetails.model.AuthResponse;
import com.cognizant.xxAppointmentDetails.repository.AppointmentDetailsRepository;

@Service
public class AppointmentDetailsServiceImpl implements AppointmentDetailsService {
	
	@Autowired
	private AppointmentDetailsRepository appointmentDetailsRepository;
	
	@Autowired
	private AuthClient authClient;
	
	
	public List<AppointmentDetailsDTO> findAllAppointmentDetails()
	{
		List<AppointmentDetails> appointmentDetailsList = appointmentDetailsRepository.findAll();
		
		List<AppointmentDetailsDTO> appointmentDetailsDTOList = new ArrayList<>();
		
		for(AppointmentDetails appointmentDetails: appointmentDetailsList)
		{
			AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO(appointmentDetails.getId(), appointmentDetails.getPatientId(),
											appointmentDetails.getClinicId(), appointmentDetails.getSpecialty(), appointmentDetails.getAppointmentDate().getYear(),
											appointmentDetails.getAppointmentDate().getMonthValue(), appointmentDetails.getAppointmentDate().getDayOfMonth(), 
											appointmentDetails.getAppointmentDate().getHour());
			
			appointmentDetailsDTOList.add(appointmentDetailsDTO);
		}
		
		return appointmentDetailsDTOList;
	}
	
	
	public void addAppointmentDetails(AppointmentDetailsDTO appointmentDetailsDTO)
	{
		AppointmentDetails appointmentDetails = new AppointmentDetails(appointmentDetailsDTO.getPatientId(), appointmentDetailsDTO.getClinicId(), appointmentDetailsDTO.getSpecialty(),
				LocalDateTime.of(appointmentDetailsDTO.getAppointmentDateYear(), appointmentDetailsDTO.getAppointmentDateMonth(), 
						appointmentDetailsDTO.getAppointmentDateDay(), appointmentDetailsDTO.getAppointmentDateSlot(), 0));
		
		appointmentDetailsRepository.save(appointmentDetails);
	}
	
	
	public void editAppointmentDetails(AppointmentDetailsDTO appointmentDetailsDTO)
	{
		AppointmentDetails appointmentDetails = new AppointmentDetails(appointmentDetailsDTO.getId(), appointmentDetailsDTO.getPatientId(), appointmentDetailsDTO.getClinicId(), appointmentDetailsDTO.getSpecialty(),
				LocalDateTime.of(appointmentDetailsDTO.getAppointmentDateYear(), appointmentDetailsDTO.getAppointmentDateMonth(), 
						appointmentDetailsDTO.getAppointmentDateDay(), appointmentDetailsDTO.getAppointmentDateSlot(), 0));
		
		appointmentDetailsRepository.save(appointmentDetails);	
	}
	
	@Transactional
	public void removeAppointmentDetails(AppointmentDetailsDTO appointmentDetailsDTO)
	{
		appointmentDetailsRepository.deleteById(appointmentDetailsDTO.getId());	
	}
	
	@Transactional
	public List<AppointmentDetailsDTO> findAppointmentDetailsByPatientId(int patientId)
	{
		List<AppointmentDetails> appointmentDetailsList = appointmentDetailsRepository.filterByPatientId(patientId);
		
		List<AppointmentDetailsDTO> appointmentDetailsDTOList = new ArrayList<>();
		
		for(AppointmentDetails appointmentDetails: appointmentDetailsList)
		{
			AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO(appointmentDetails.getId(), appointmentDetails.getPatientId(),
											appointmentDetails.getClinicId(), appointmentDetails.getSpecialty(), appointmentDetails.getAppointmentDate().getYear(),
											appointmentDetails.getAppointmentDate().getMonthValue(), appointmentDetails.getAppointmentDate().getDayOfMonth(), 
											appointmentDetails.getAppointmentDate().getHour());
			
			appointmentDetailsDTOList.add(appointmentDetailsDTO);
		}
		
		return appointmentDetailsDTOList;	
	}
	
	@Transactional
	public List<AppointmentDetailsDTO> findAppointmentDetailsByClinicId(int clinicId)
	{
		List<AppointmentDetails> appointmentDetailsList = appointmentDetailsRepository.filterByClinicId(clinicId);
		
		List<AppointmentDetailsDTO> appointmentDetailsDTOList = new ArrayList<>();
		
		for(AppointmentDetails appointmentDetails: appointmentDetailsList)
		{
			AppointmentDetailsDTO appointmentDetailsDTO = new AppointmentDetailsDTO(appointmentDetails.getId(), appointmentDetails.getPatientId(),
											appointmentDetails.getClinicId(), appointmentDetails.getSpecialty(), appointmentDetails.getAppointmentDate().getYear(),
											appointmentDetails.getAppointmentDate().getMonthValue(), appointmentDetails.getAppointmentDate().getDayOfMonth(), 
											appointmentDetails.getAppointmentDate().getHour());
			
			appointmentDetailsDTOList.add(appointmentDetailsDTO);
		}
		
		return appointmentDetailsDTOList;
	}
	
	
	
	public boolean isSlotAvailable(AppointmentDetailsDTO appointmentDetailsDTO)
	{
		List<AppointmentDetails> appointmentDetailsList = appointmentDetailsRepository.filterByClinicId(appointmentDetailsDTO.getClinicId());
		
		boolean slotAvailable = true;
		
		for(AppointmentDetails appointmentDetails:appointmentDetailsList)
		{
			if(appointmentDetails.getAppointmentDate().getYear()==appointmentDetailsDTO.getAppointmentDateYear() && 
					appointmentDetails.getAppointmentDate().getMonthValue()==appointmentDetailsDTO.getAppointmentDateMonth() &&
					appointmentDetails.getAppointmentDate().getDayOfMonth()==appointmentDetailsDTO.getAppointmentDateDay() &&
					appointmentDetails.getAppointmentDate().getHour()==appointmentDetailsDTO.getAppointmentDateSlot())
			{
				slotAvailable = false;
				break;
			}
		}
		
		return slotAvailable;
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
		AppointmentDetails appointmentDetails1 = new AppointmentDetails(1, 1, 1, "SPECIALTY ONE", LocalDateTime.of(2022, 12, 15, 11, 0));
		appointmentDetailsRepository.save(appointmentDetails1);
		
		AppointmentDetails appointmentDetails2 = new AppointmentDetails(2, 2, 1, "SPECIALTY TWO", LocalDateTime.of(2022, 12, 16, 15, 15));
		appointmentDetailsRepository.save(appointmentDetails2);
	}

}
