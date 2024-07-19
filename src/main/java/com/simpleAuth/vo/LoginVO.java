package com.simpleAuth.vo;

import com.simpleAuth.model.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginVO {
	
	private Account account;
	private String jwt;

}
