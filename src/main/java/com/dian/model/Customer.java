/**
 * 
 */
package com.dian.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author guodi
 *	
 * TODO: branch_id foreign key
 * 
 */

@Entity
@Table(name="CUSTOMER")
public class Customer {
	@Id
	@Column(name="CUTOMER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="SEX")
	private String sex;
	
	@Column(name="DATE")
	private Date date; // sql date
	
	@Column(name="QUALIFICATION")
	private String qualification;
	
	@Column(name="OCCUPATION")
	private String occupation;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="BRANCH_ID")
	private long branchId; // foreign key
	
	public Customer() {}
	public Customer(String firstName, String lastName, int age, String sex, Date date, String qualification,
			String occupation, String address, String email, String password, long branchId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sex = sex;
		this.date = date;
		this.qualification = qualification;
		this.occupation = occupation;
		this.address = address;
		this.email = email;
		this.password = password;
		this.branchId = branchId;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", sex="
				+ sex + ", date=" + date + ", qualification=" + qualification + ", occupation=" + occupation
				+ ", address=" + address + ", email=" + email + ", password=" + password + ", branchId=" + branchId
				+ "]";
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getBranchId() {
		return branchId;
	}
	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}
	
	
	
}
