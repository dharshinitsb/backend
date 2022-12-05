package com.cognizant.xxClinicDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.xxClinicDetails.model.StaffDetails;

@Repository
public interface StaffDetailsRepository extends JpaRepository<StaffDetails,Integer> {
	
	@Query("select sd from StaffDetails sd where sd.clinicId = :clinicId")
	public List<StaffDetails> filterStaffDetailsByClinicId(@Param("clinicId") int clinicId);

}
