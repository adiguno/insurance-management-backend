package com.dian.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dian.model.Policy;

@Repository
public interface PolicyRepository extends CrudRepository<Policy, Long>{
	Optional<Policy> findByPolicyName(String policyName);
}
