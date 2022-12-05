package com.cognizant.xxAppointmentDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.xxAppointmentDetails.model.AppointmentDetails;

@Repository
public interface AppointmentDetailsRepository extends JpaRepository<AppointmentDetails,Integer> {
	
	@Query("select ad from AppointmentDetails ad where ad.clinicId = :clinicId")
	public List<AppointmentDetails> filterByClinicId(@Param("clinicId") int clinicId);
	
	@Query("select ad from AppointmentDetails ad where ad.patientId = :patientId")
	public List<AppointmentDetails> filterByPatientId(@Param("patientId") int patientId);

}
