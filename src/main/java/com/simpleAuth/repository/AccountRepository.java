package com.simpleAuth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleAuth.model.Account;


public interface AccountRepository extends JpaRepository<Account,String> {

	Optional<Account> findByUsername(String username);
}
