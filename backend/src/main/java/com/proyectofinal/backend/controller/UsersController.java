package com.proyectofinal.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.backend.entity.models.Roles;
import com.proyectofinal.backend.entity.models.Users;
import com.proyectofinal.backend.service.IRolesService;
import com.proyectofinal.backend.service.IUserService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class UsersController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRolesService rolesService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<?> create(@RequestBody Users usuario) {
		
		Map<String, Object> response = new HashMap<>();
		Users email = userService.findByEmail(usuario.getEmail());
		
		if(email == null) {
			String passDescodificada = usuario.getPassword();
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			usuario.setEnabled(true);
			
			List<Roles> roles = new ArrayList<Roles>();
			Roles rol = rolesService.findRolesById(1);
			roles.add(rol);
			usuario.setRoles(roles);
			
			userService.save(usuario);
			
			usuario.setPassword(passDescodificada);
			response.put("usuario", usuario);
			response.put("mensaje", "Se ha dado de alta en el sistema correctamente");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
			
		}else {
			response.put("mensaje", "El email introducido ya esta dado del alta en el sistema.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
