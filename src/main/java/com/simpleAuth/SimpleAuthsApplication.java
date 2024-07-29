package com.simpleAuth;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.simpleAuth.model.Account;
import com.simpleAuth.model.Role;
import com.simpleAuth.repository.AccountRepository;
import com.simpleAuth.repository.RoleRepository;
import com.simpleAuth.services.AccountService;

@SpringBootApplication
public class SimpleAuthsApplication {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(SimpleAuthsApplication.class, args);
		System.out.println("=============== START OK ===============");
	}

	@Bean
	public String initData() {
		Role role = Role.builder().authority("ADMIN").build();
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		roleRepository.save(role);
		Role role01 = Role.builder().authority("USER").build();
		roleRepository.save(role01);

		// Account account =
		// Account.builder().username("test").password("$2a$10$UMZPt0V3vDvNPveXt13z2uNCK8bcRsNVhe8kpThQzRIn27//Ih55m").roles(roles).build();
		Account account = Account.builder().username("test").password("{noop}12345678").roles(roles).build();
		accountRepository.save(account);

		return null;

	}

}
