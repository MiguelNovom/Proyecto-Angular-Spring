package com.proyectofinal.backend.service;

import java.util.List;

import com.proyectofinal.backend.entity.models.Users;

public interface IUserService {

	public Users findByEmail(String email);
	
	public List<Users> findAll();
	
	public Users findById(Long id);
	
	public Users save(Users user);
	
	public void delete(Long id);
	

}