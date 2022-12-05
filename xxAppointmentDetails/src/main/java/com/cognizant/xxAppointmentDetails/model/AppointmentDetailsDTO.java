package com.cognizant.xxAppointmentDetails.model;

public class AppointmentDetailsDTO {
	
	private int id;
	
	private int patientId;
	
	private int clinicId;
	
	private String specialty;
	
	private int appointmentDateYear;
	
	private int appointmentDateMonth;
	
	private int appointmentDateDay;
	
	private int appointmentDateSlot;

	public AppointmentDetailsDTO() {
		super();
	}

	public AppointmentDetailsDTO(int patientId, int clinicId, String specialty, int appointmentDateYear, int appointmentDateMonth, int appointmentDateDay,
			int appointmentDateSlot) {
		super();
		this.patientId = patientId;
		this.clinicId = clinicId;
		this.specialty = specialty;
		this.appointmentDateYear = appointmentDateYear;
		this.appointmentDateMonth = appointmentDateMonth;
		this.appointmentDateDay = appointmentDateDay;
		this.appointmentDateSlot = appointmentDateSlot;
	}

	public AppointmentDetailsDTO(int id, int patientId, int clinicId, String specialty, int appointmentDateYear, int appointmentDateMonth,
			int appointmentDateDay, int appointmentDateSlot) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.clinicId = clinicId;
		this.specialty = specialty;
		this.appointmentDateYear = appointmentDateYear;
		this.appointmentDateMonth = appointmentDateMonth;
		this.appointmentDateDay = appointmentDateDay;
		this.appointmentDateSlot = appointmentDateSlot;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getClinicId() {
		return clinicId;
	}

	public void setClinicId(int clinicId) {
		this.clinicId = clinicId;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public int getAppointmentDateYear() {
		return appointmentDateYear;
	}

	public void setAppointmentDateYear(int appointmentDateYear) {
		this.appointmentDateYear = appointmentDateYear;
	}

	public int getAppointmentDateMonth() {
		return appointmentDateMonth;
	}

	public void setAppointmentDateMonth(int appointmentDateMonth) {
		this.appointmentDateMonth = appointmentDateMonth;
	}

	public int getAppointmentDateDay() {
		return appointmentDateDay;
	}

	public void setAppointmentDateDay(int appointmentDateDay) {
		this.appointmentDateDay = appointmentDateDay;
	}

	public int getAppointmentDateSlot() {
		return appointmentDateSlot;
	}

	public void setAppointmentDateSlot(int appointmentDateSlot) {
		this.appointmentDateSlot = appointmentDateSlot;
	}

}
