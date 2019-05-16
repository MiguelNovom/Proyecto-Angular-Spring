package com.proyectofinal.backend.service;

import com.proyectofinal.backend.entity.models.Users;

public interface IUserService {

	public Users findByEmail(String email);

}