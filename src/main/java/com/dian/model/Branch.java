package com.dian.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * NOTES:
 * 	- PHONE, is a string
 */

@Entity
@Table(name="BRANCH")
public class Branch {
	@Id
	@Column(name="BRANCH_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long branchId;
	
	@Column(name="BRANCH_NAME")
	private String branchName;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="PHONE")
	private String phone;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="DATE")
	private LocalDate date;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	

	public Branch() {}
	public Branch(long branchId, String branchName, String address, String phone, LocalDate date,
			String city, String state) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.address = address;
		this.phone = phone;
		this.date = date;
		this.city = city;
		this.state = state;
	}


	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", address=" + address + ", phone="
				+ phone + ", date=" + date + ", city=" + city + ", state=" + state + "]";
	}
	
}
