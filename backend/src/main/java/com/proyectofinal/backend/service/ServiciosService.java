package com.proyectofinal.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyectofinal.backend.entity.models.Servicios;
import com.proyectofinal.backend.repository.ServiciosRepository;

@Service
public class ServiciosService implements IServiciosService {
	
	@Autowired
	private ServiciosRepository serviciosRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Servicios findServiciosById(int id) {
		return serviciosRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public Servicios saveServicios(Servicios servicio) {
		return serviciosRepository.save(servicio);
	}

	@Override
	@Transactional()
	public void deleteServiciosById(int id) {
		serviciosRepository.deleteById(id);

	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Servicios> findAll() {
		return serviciosRepository.findAll();
	}

}
