package com.hackaton.unifacisa.Services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.hackaton.unifacisa.security.UserSecurity;

public class UserService {

	public static UserSecurity authenticated() {
		try {
			
			return (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
		} catch (Exception e) {
			
			return null;
			
		}
	}

}
