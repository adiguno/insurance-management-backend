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
 *  -[x] persist customer with his information (using request body)
 *  	firstName, lastName, age, sex, date, qualification, occupation, address, 
 *  	email, password, branchId
 *  -[x] fix date parameter
 *  -[ ] add new customer:
 *  		1. use today's date
 *  -[ ] load in pre-existing records before app startup (schema.sql ??)
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
	public Customer findById(@RequestParam(value="id") long id) {
		return this.customerService.getCustomerById(id);
	}
}
