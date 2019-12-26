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
//		customer by branch id

@Service
public class CustomerService {
	
	public final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer addCustomer(Customer cus) {
		customerRepository.save(cus);
		return cus;
	}

	public List<Customer> getAllCustomers() {
		return (List<Customer>)customerRepository.findAll();
	}
	
	
}
