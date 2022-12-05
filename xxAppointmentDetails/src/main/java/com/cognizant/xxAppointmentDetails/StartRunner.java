package com.cognizant.xxAppointmentDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cognizant.xxAppointmentDetails.service.AppointmentDetailsServiceImpl;

@Component
public class StartRunner implements ApplicationRunner {
	
	@Autowired
	private AppointmentDetailsServiceImpl appointmentDetailsService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		appointmentDetailsService.addData();
	}

}
