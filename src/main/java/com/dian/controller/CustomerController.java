package com.dian.controller;


import java.sql.Date;
import java.util.List;
import java.util.Optional;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
 *	- use username as the unique check
 * 	- agents and branch managers have access to customer's information
 * 
 * 
 * Questions:
 * 	- why do we need passwords
 * 		- no need for storing passwords in the customer table
 *  - what is the unique identifier (other than id), email and password? or username and password?
 *  	- using username as unique id
 *  
 *
 */

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	private CustomerService customerService;
	
    private static final Logger logger = LogManager.getLogger(CustomerController.class);

	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam(value="id") long id) {
		logger.debug("delete customer, id = " + id);
		this.customerService.deleteCustomer(id);
	}
	
	@PutMapping("/edit")
	public Customer editById(@RequestParam(value="id") long id, @RequestBody Customer cus) {
		logger.debug("update customer, id = " + id);
		Customer existing =  this.customerService.getCustomerById(id);
		existing.setAddress(cus.getAddress());
		existing.setAge(cus.getAge());
		existing.setBranchId(cus.getBranchId());
		existing.setDate(cus.getDate());
		existing.setEmail(cus.getEmail());
		existing.setFirstName(cus.getFirstName());
		existing.setLastName(cus.getLastName());
		existing.setOccupation(cus.getOccupation());
		existing.setPassword(cus.getPassword());
		existing.setSex(cus.getSex());
		existing.setQualification(cus.getQualification());
		return this.customerService.updateCustomer(existing);
	}

	@PostMapping("/add")
	public Customer addNew(@RequestBody Customer cus) {
		return this.customerService.addCustomer(cus);
	}	
	
	@GetMapping("/all") 
	public List<Customer> findAll() {
		return this.customerService.getAllCustomers();
	}
	
	@GetMapping("/branch")
	public List<Customer> findByBranchId(@RequestParam(value="branchId") long branchId) {
		logger.debug("get customer, by branchId = " + branchId);
		return this.customerService.getCustomersByBranchId(branchId);
	}
	
	@GetMapping("/lastname")
	public List<Customer> findByLastName(@RequestParam(value="lastName") String lastName) {
		logger.debug("get customer, by lastName = " + lastName);
		return this.customerService.getCustomerByLastName(lastName);
	}
	
	@GetMapping("/id")
	public Customer findById(@RequestParam(value="id") long id) {
		logger.debug("get customer, by id = " + id);
		return this.customerService.getCustomerById(id);
	}
}
