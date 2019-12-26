package com.dian.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dian.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
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
}
