package com.dian.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dian.model.Agent;
import com.dian.model.Manager;

@Repository
public interface AgentRepository extends CrudRepository<Agent, Long> {
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
	Agent findByUsername(String username);
}
