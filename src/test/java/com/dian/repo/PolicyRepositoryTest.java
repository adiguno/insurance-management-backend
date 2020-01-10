package com.dian.repo;

import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dian.model.Policy;
import com.dian.repository.PolicyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PolicyRepositoryTest {
	@Autowired
	private PolicyRepository policyRepository;
	
	@Test
	public void testFindByPolicyName() {
		Optional<Policy> policy = policyRepository.findByPolicyName("policyTest");
		assertFalse(policy.isPresent());
	}
}
