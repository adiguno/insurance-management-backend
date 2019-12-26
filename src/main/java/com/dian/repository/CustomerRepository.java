package com.dian.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dian.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	// Create/Update
	// 		save
	//		saveAll
	// Delete
	//		deleteById
	//		deleteAll(Iterable)
	//		delete
	//		deleteAll
	// Read
	// 		findById
	//		findAllById
	//		findAll
	//		count
	// 		existById
	Iterable<Customer> findByLastName(String lastName);
	Iterable<Customer> findByBranchId(long branchId);
}
