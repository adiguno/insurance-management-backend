package com.dian.controller;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dian.model.Customer;
import com.dian.service.CustomerService;



/**
 * 
 * @author Adiguno
 * 
 * NOTES:
 *	- using request params (should be used for searching/filtering)
 * 
 * 
 * Questions:
 * 	- why do we need passwords
 *  - what is the unique identifier (other than id), email and password? or username and password?
 * 	- only agents should have access to this controller ?
 * 		- rename to agent's controller?
 *
 * TODO: 
 *  -[ ] persist customer with his information (using request body)
 *  	firstName, lastName, age, sex, date, qualification, occupation, address, 
 *  	email, password, branchId
 *  -[ ] fix date parameter
 *  	- options:
 *  		1. use today's date
 *  			- load in pre-existing records before startup (schema.sql ??)
 *  		2. pass in sql date in query param
 *  
 *  -[x] retrieve all of the customers
 *  -[x] retrieve the list of customers with branch id
 *  -[x] retrieve the list of customers with last name
 *  -[ ] get customer by id needs work
 *  
 *  -[ ] update
 *  -[ ] delete
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
	
	// TODO date
//	@PostMapping("/add")
//	public Customer addNew(@RequestParam(value="firstName") String firstName,
//			@RequestParam(value="lastName") String lastName,
//			@RequestParam(value="age") int age,
//			@RequestParam(value="sex") String sex,
//			@RequestParam(value="date", required=false) Date date,
//			@RequestParam(value="qualification") String qualification,
//			@RequestParam(value="occupation") String occupation,
//			@RequestParam(value="address") String address,
//			@RequestParam(value="email") String email,
//			@RequestParam(value="password") String password,
//			@RequestParam(value="branchId") long branchId) {
//		Customer cus = new Customer();
//		cus.setFirstName(firstName);
//		cus.setLastName(lastName);
//		cus.setAge(age);
//		cus.setSex(sex);
//		cus.setDate(date);
//		cus.setQualification(qualification);
//		cus.setOccupation(occupation);
//		cus.setAddress(address);
//		cus.setEmail(email);
//		cus.setPassword(password);
//		cus.setBranchId(branchId);
//		this.customerService.addCustomer(cus);
//		return cus;
//	}
	@PostMapping("/add")
	public Customer addNew(@RequestBody Customer cus) {
		this.customerService.addCustomer(cus);
		return cus;
	}
		
	
	@GetMapping("/all") 
	public List<Customer> findAll() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/branch")
	public List<Customer> findByBranchId(@RequestParam(value="branchId") long branchId) {
		return this.customerService.getCustomersByBranchId(branchId);
	}
	
	@GetMapping("/lastname")
	public List<Customer> findByLastName(@RequestParam(value="lastName") String lastName) {
		return this.customerService.getCustomerByLastName(lastName);
	}
	
	@GetMapping("/id")
	public Optional<Customer> findById(@RequestParam(value="id") long id) {
		return this.customerService.getCustomerById(id);
	}
}
