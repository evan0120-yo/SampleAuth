package com.simpleAuth.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simpleAuth.exception.DataNotFoundException;
import com.simpleAuth.model.Account;
import com.simpleAuth.model.Role;
import com.simpleAuth.repository.AccountRepository;
import com.simpleAuth.repository.RoleRepository;
import com.simpleAuth.vo.LoginVO;

@Service
public class AccountService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenService tokenService;
	 
	public Account save(String username, String passwrod) {
		String encodedPassword = passwordEncoder.encode(passwrod);	
		Role userRole = roleRepository.findByAuthority("USER").orElseThrow(() -> new DataNotFoundException("查無此role"));
		Set<Role> roles = new HashSet<>();
		roles.add(userRole);
		
		
		return accountRepository.save(Account.builder().username(username).password(encodedPassword).roles(roles).build());
	}
	
	public LoginVO loginAccount(String username, String password) {
		try {
			Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
			String token = tokenService.generateJwt(auth);
			return LoginVO.builder()
					.account(accountRepository.findByUsername(username).get())
					.jwt(token)
					.build();
		} catch(AuthenticationException e){
			return LoginVO.builder().build();
		}
	}
	

}
