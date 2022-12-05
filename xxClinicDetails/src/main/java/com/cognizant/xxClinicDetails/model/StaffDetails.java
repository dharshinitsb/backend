package com.cognizant.xxClinicDetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff_details")
public class StaffDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "clinic_id", nullable = false)
	private int clinicId;
	
	@Column(name = "staff_name", nullable = false)
	private String staffName;
	
	@Column(name = "specialty", nullable = false)
	private String specialty;

	public StaffDetails() {
		super();
	}

	public StaffDetails(int clinicId, String staffName, String specialty) {
		super();
		this.clinicId = clinicId;
		this.staffName = staffName;
		this.specialty = specialty;
	}

	public StaffDetails(int id, int clinicId, String staffName, String specialty) {
		super();
		this.id = id;
		this.clinicId = clinicId;
		this.staffName = staffName;
		this.specialty = specialty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClinicId() {
		return clinicId;
	}

	public void setClinicId(int clinicId) {
		this.clinicId = clinicId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	

}
