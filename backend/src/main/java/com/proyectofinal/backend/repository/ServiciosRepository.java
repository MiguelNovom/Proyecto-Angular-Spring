package com.proyectofinal.backend.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.backend.entity.models.Servicios;

public interface ServiciosRepository extends JpaRepository<Servicios, Serializable> {

}
