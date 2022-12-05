package com.cognizant.xxClinicDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cognizant.xxClinicDetails.service.ClinicDetailsServiceImpl;

@Component
public class StartRunner implements ApplicationRunner {
	
	@Autowired
	private ClinicDetailsServiceImpl clinicDetailsService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		clinicDetailsService.addData();
	}

}
