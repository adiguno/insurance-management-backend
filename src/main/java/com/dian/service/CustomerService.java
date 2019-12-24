package com.dian.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dian.model.Customer;
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
//	@Autowired
//	public CustomerRepository customerRepository;
	
	public final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	// add a customer
	public Customer addCustomer(Customer cus) {
		customerRepository.save(cus);
		return cus;
	}

	// return all customers
	public List<Customer> getAllCustomers() {
		return (List<Customer>)customerRepository.findAll();
		// or
//		List<Customer> returnList = new ArrayList<>();
//		customerRepository.findAll().forEach(returnList::add);
//		returnList = (List<Customer>)customerRepository.findAll();
//		return returnList;
	}
	
	
}
