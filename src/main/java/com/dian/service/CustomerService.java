package com.dian.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		this.customerRepository.save(cus);
		return cus;
	}

	public List<Customer> getAllCustomers() {
		return (List<Customer>)this.customerRepository.findAll();
	}
	
	public List<Customer> getCustomersByBranchId(long branchId) {
		List<Customer> list = new ArrayList<>();
		Iterable<Customer> cusIterable = this.customerRepository.findByBranchId(branchId);
		cusIterable.forEach(list::add);
		return list;
	}
	
	public List<Customer> getCustomerByLastName(String lastName) {
		List<Customer> list = new ArrayList<>();
		Iterable<Customer> itr = this.customerRepository.findByLastName(lastName);
		itr.forEach(list::add);
		return list;
	}
	
	public Optional<Customer> getCustomerById(long id) {
		return this.customerRepository.findById(id);
	}
	
}
