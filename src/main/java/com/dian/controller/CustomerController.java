package com.dian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dian.model.Customer;
import com.dian.service.CustomerService;

@RestController//("/api")
@RequestMapping("/api")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/add")
	public Customer addNew() {
		Customer cus = new Customer();
		cus.setFirstName("only firstname");
		this.customerService.addCustomer(cus);
		return cus;
	}
	
	@GetMapping("/all") 
	public String test() {
		return "something";
	}
	
	
}
