package com.dian.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dian.model.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByRoleName(String name);
}
