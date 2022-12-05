package com.cognizant.xxStaffLeaveDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cognizant.xxStaffLeaveDetails.service.StaffLeaveDetailsServiceImpl;

@Component
public class StartRunner implements ApplicationRunner {
	
	@Autowired
	private StaffLeaveDetailsServiceImpl staffLeaveDetailsService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		staffLeaveDetailsService.addData();
	}

}