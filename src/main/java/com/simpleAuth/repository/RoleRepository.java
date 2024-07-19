package com.simpleAuth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleAuth.model.Role;

public interface RoleRepository extends JpaRepository<Role,String> {

	Optional<Role> findByAuthority(String authority);
}
