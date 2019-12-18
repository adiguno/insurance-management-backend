package com.dian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dian.repository.CustomerRepository;

// used mainly for testing purposes
// dependency injection using constructor

// CRUD
// create customer
// read:
//		all customers
//		customer by id
//		customer by last name
//		customer by email

@Service
public class CustomerService {
	
	public final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	// return all customers
	
}
