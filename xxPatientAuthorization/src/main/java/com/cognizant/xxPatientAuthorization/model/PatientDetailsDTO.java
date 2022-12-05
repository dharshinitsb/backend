package com.cognizant.xxPatientAuthorization.model;

public class PatientDetailsDTO {

	String jwtToken;
	PatientDetails patientDetails;
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public PatientDetails getPatientDetails() {
		return patientDetails;
	}
	public void setPatientDetails(PatientDetails patientDetails) {
		this.patientDetails = patientDetails;
	}
	public PatientDetailsDTO(String jwtToken, PatientDetails patientDetails) {
		super();
		this.jwtToken = jwtToken;
		this.patientDetails = patientDetails;
	}
	public PatientDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
