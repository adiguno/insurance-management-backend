package com.dian.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.dian.model.Policy;
import com.dian.repository.PolicyRepository;

@RunWith(MockitoJUnitRunner.class)
public class PolicyServiceTest {
	private final static long policyId = 1;
	private final static String policyName= "testPolicy";
	

	@Mock
	private PolicyRepository policyRepositoryMock;
	
	@InjectMocks
	private PolicyService service;
	
	@Mock
	private Policy policyMock;
	
	@Before
	public void setupReturnValuesOfMockMethods() {
//		when(policyRepositoryMock.findAll()).thenReturn();
		when(policyRepositoryMock.findById(policyId)).thenReturn(Optional.of(policyMock));
		when(policyRepositoryMock.findByPolicyName(policyName)).thenReturn(Optional.of(policyMock));
		when(policyMock.getPolicyName()).thenReturn(policyName);
	}
	
	@Test
	public void lookingupPolicyById() {
		assertThat(service.getPolicyById(policyId), is(policyMock));
	}	
	@Test
	public void lookingupPolicyByName() {
		// test if the object returned is a Policy object
		assertThat(service.getPolicyByName(policyName), is(policyMock));
		// test if the object returned has the same policy name
		assertEquals(service.getPolicyByName(policyName).getPolicyName(), policyMock.getPolicyName());
	}
	
}
