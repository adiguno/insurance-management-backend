package com.dian.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dian.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
//	public void deleteById(Long id);
//	public Optional<Customer> findById(Long id);
	
}
