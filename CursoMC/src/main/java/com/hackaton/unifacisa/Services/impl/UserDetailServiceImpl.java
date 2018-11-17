package com.hackaton.unifacisa.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hackaton.unifacisa.domain.Usuario;
import com.hackaton.unifacisa.repositories.UsuarioRepository;
import com.hackaton.unifacisa.security.UserSecurity;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario cli= repo.findByEmail(email);
		if(cli == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSecurity(cli.getId(),cli.getEmail(),cli.getSenha(),cli.getPerfis());
	}

}
