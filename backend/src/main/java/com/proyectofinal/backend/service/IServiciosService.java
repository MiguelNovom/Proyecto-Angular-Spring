package com.proyectofinal.backend.service;

import java.util.List;

import com.proyectofinal.backend.entity.models.Servicios;

public interface IServiciosService {

	Servicios findServiciosById(int id);

	Servicios saveServicios(Servicios servicio);

	void deleteServiciosById(int id);

	List<Servicios> findAll();

}