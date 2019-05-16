package com.proyectofinal.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectofinal.backend.entity.models.Users;
import com.proyectofinal.backend.repository.UserRepository;

@Service()
public class UserService  implements UserDetailsService, IUserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly=true)
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Users usuario = userRepository.findByEmail(email);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Error en el login: no existe el email '"+email+"' en el sistema!");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.collect(Collectors.toList());
		
		return new User(usuario.getEmail(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}
	@Override
	@Transactional(readOnly=true)
	public Users findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
