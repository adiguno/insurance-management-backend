package com.dian.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dian.model.User;

/**
 * NOTES:
 * 		- <User, Integer> in the example 
 * 		- JpaRepository in example
 * 
 * @author guodi
 *
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String userName);
}
