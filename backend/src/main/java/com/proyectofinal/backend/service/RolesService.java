package com.proyectofinal.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectofinal.backend.entity.models.Roles;
import com.proyectofinal.backend.repository.RolesRepository;

@Service
public class RolesService implements IRolesService {
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Roles findRolesById(int id) {
		return rolesRepository.findById(id).orElse(null);
	}

}
