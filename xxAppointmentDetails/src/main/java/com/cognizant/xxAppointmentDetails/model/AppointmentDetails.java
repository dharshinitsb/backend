package com.cognizant.xxAppointmentDetails.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment_details")
public class AppointmentDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "patient_id", nullable = false)
	private int patientId;
	
	@Column(name = "clinic_id", nullable = false)
	private int clinicId;
	
	@Column(name = "specialty", nullable = false)
	private String specialty;
	
	@Column(columnDefinition = "TIMESTAMP", name = "appointment_date", nullable = false)
	private LocalDateTime appointmentDate;

	public AppointmentDetails() {
		super();
	}

	public AppointmentDetails(int patientId, int clinicId, String specialty, LocalDateTime appointmentDate) {
		super();
		this.patientId = patientId;
		this.clinicId = clinicId;
		this.specialty = specialty;
		this.appointmentDate = appointmentDate;
	}

	public AppointmentDetails(int id, int patientId, int clinicId, String specialty, LocalDateTime appointmentDate) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.clinicId = clinicId;
		this.specialty = specialty;
		this.appointmentDate = appointmentDate;
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
	
	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public void setClinicId(int clinicId) {
		this.clinicId = clinicId;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	

}
