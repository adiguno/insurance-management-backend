package com.dian.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dian.model.Agent;
import com.dian.model.CustomerPolicyRegistration;

@Repository
public interface CustomerPolicyRegistrationRepository extends CrudRepository<CustomerPolicyRegistration, Long>{
	// to be tested
	Iterable<CustomerPolicyRegistration> findByAgent(Agent agent);
}
