package com.dian.controller;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dian.model.Customer;
import com.dian.service.CustomerService;

/**
 * 
 * @author Adiguno
 *
 * TODO: 
 *  -[x] persist customer with his information (using request param)
 *  	firstName, lastName, age, sex, date, qualification, occupation, address, 
 *  	email, password, branchId
 *  -[ ] fix date parameter
 *  
 *  -[ ] retrieve all of the customers
 *  -[ ] retrieve the list of customers with branch id
 *  
 */

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	// TODO
	@PostMapping("/add")
	public Customer addNew(@RequestParam(value="firstName") String firstName,
			@RequestParam(value="lastName") String lastName,
			@RequestParam(value="age") int age,
			@RequestParam(value="sex") String sex,
			@RequestParam(value="date", required=false) Date date,
			@RequestParam(value="qualification") String qualification,
			@RequestParam(value="occupation") String occupation,
			@RequestParam(value="address") String address,
			@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,
			@RequestParam(value="branchId") long branchId
			) {
		Customer cus = new Customer();
		cus.setFirstName(firstName);
		cus.setLastName(lastName);
		cus.setAge(age);
		cus.setSex(sex);
		cus.setDate(date);
		cus.setQualification(qualification);
		cus.setQualification(qualification);
		cus.setAddress(address);
		cus.setEmail(email);
		cus.setPassword(password);
		cus.setBranchId(branchId);
		
		this.customerService.addCustomer(cus);
		return cus;
	}
	
	@GetMapping("/all") 
	public String test() {
		return "something";
	}
	
	
}
