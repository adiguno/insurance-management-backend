package com.dian.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dian.model.Manager;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {
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
//	Iterable<Manager> findByLastName(String lastName);
	Manager findByUsername(String username);
}