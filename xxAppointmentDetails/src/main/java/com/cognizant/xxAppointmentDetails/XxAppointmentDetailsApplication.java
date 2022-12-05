package com.cognizant.xxAppointmentDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class XxAppointmentDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(XxAppointmentDetailsApplication.class, args);
	}

}
