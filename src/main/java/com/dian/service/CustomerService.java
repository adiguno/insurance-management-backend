package com.dian.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dian.model.Customer;
import com.dian.repository.BranchRepository;
import com.dian.repository.CustomerRepository;

// NOTES:
// 	used mainly for testing purposes
// 	dependency injection using constructor
//	could use optionals to help check if the records exists before modifying
//
// CRUD
// create customer
// read:
//		all customers
//		customer by id
//			returns a new empty customer if id is not found
//		customer by last name
//		customer by branch id
// Update:
//		update customer with new customer
// Delete:
//		delete customer by id

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public void deleteCustomer(long id) {
		this.customerRepository.deleteById(id);
	}
	
	public Customer updateCustomer(Customer cus) {
		return this.customerRepository.save(cus);
	}
	
	// add
	public Customer addCustomer(Customer cus) {
		return this.customerRepository.save(cus);
	}

	// get all
	public List<Customer> getAllCustomers() {
		return (List<Customer>)this.customerRepository.findAll();
	}
	// get with username
	public Customer getCustomerByUsername(String username) {
		return this.customerRepository.findByUsername(username);
	}	
//	public List<Customer> getCustomersByUsername(String username) {
//		List<Customer> list = new ArrayList<>();
//		Iterable<Customer> cusIterable = this.customerRepository.findByUsername(username);
//		cusIterable.forEach(list::add);
//		return list;
//	}
	
	public List<Customer> getCustomerByLastName(String lastName) {
		List<Customer> list = new ArrayList<>();
		Iterable<Customer> itr = this.customerRepository.findByLastName(lastName);
		itr.forEach(list::add);
		return list;
	}
	
	public Customer getCustomerById(long id) {
		return this.customerRepository.findById(id).get();
	}
	
}
