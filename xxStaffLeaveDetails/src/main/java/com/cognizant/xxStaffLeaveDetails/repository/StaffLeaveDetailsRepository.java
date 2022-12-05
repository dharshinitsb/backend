package com.cognizant.xxStaffLeaveDetails.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.xxStaffLeaveDetails.model.StaffLeaveDetails;

@Repository
public interface StaffLeaveDetailsRepository extends JpaRepository<StaffLeaveDetails,Integer> {
	
	@Query("select sld from StaffLeaveDetails sld where sld.clinicId = :clinicId and lower(sld.specialty) = lower(:specialty)")
	public List<StaffLeaveDetails> checkStaffLeaveDetails(@Param("clinicId") int clinicId,
													@Param("specialty") String specialty);

}
