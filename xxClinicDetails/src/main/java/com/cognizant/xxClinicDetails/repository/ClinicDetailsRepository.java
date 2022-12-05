package com.cognizant.xxClinicDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.xxClinicDetails.model.ClinicDetails;

@Repository
public interface ClinicDetailsRepository extends JpaRepository<ClinicDetails,Integer> {
	
	public ClinicDetails findById(int id);

}
