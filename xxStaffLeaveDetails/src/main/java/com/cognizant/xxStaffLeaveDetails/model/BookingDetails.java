package com.cognizant.xxStaffLeaveDetails.model;

public class BookingDetails {
	
	private int clinicId;
	
	private String specialty;
	
	private int appointmentDateYear;
	
	private int appointmentDateMonth;
	
	private int appointmentDateDay;

	public BookingDetails() {
		super();
	}

	public BookingDetails(int clinicId, String specialty, int appointmentDateYear, int appointmentDateMonth,
			int appointmentDateDay) {
		super();
		this.clinicId = clinicId;
		this.specialty = specialty;
		this.appointmentDateYear = appointmentDateYear;
		this.appointmentDateMonth = appointmentDateMonth;
		this.appointmentDateDay = appointmentDateDay;
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
	
	

}
