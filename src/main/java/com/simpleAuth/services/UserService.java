package com.simpleAuth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.simpleAuth.exception.DataNotFoundException;
import com.simpleAuth.repository.AccountRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return accountRepository.findByUsername(username).orElseThrow(() -> new DataNotFoundException("查無此帳號	"));
	}

}
