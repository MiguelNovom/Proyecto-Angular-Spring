package com.proyectofinal.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectofinal.backend.entity.models.Users;

public interface UserRepository extends CrudRepository<Users, Long>{
	
	public Users findByEmail(String email);
	
	@Query("select u from Users u where u.email=?1")
	public Users findByEmail2(String email);
	
	@Query("select u, s.titulo as titulo from Users u JOIN u.servicios s ")
	public List<Object> findAllSuscribed();
}
