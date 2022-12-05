package com.cognizant.xxStaffLeaveDetails.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.xxStaffLeaveDetails.model.AuthResponse;

@FeignClient(name = "patient-authorization", url = "${PATIENT_AUTHORIZATION:http://localhost:8091}")
public interface AuthClient {
	
	@GetMapping("/validate")
	public AuthResponse getValidity(@RequestHeader("Authorization") String token);

}