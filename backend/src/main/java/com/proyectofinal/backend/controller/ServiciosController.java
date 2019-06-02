package com.proyectofinal.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.backend.entity.models.Servicios;
import com.proyectofinal.backend.service.IServiciosService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class ServiciosController {

	@Autowired
	private IServiciosService servicioService;

	@GetMapping("/servicios/{id}")
	public Servicios show(@PathVariable int id) {
		return servicioService.findServiciosById(id);
	}
	
	@GetMapping("/servicios")
	public List<Servicios> list() {
		return servicioService.findAll();
	}
	
	@Secured({ "ROLE_ADMIN" })
	@DeleteMapping("/servicios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		servicioService.deleteServiciosById(id);
	}
	
	@Secured({ "ROLE_ADMIN" })
	@PostMapping("/servicios")
	@ResponseStatus(HttpStatus.CREATED)
	public Servicios create(@RequestBody Servicios servicio) {
		return servicioService.saveServicios(servicio);
	}
	
	@Secured({ "ROLE_ADMIN" })
	@PutMapping("/servicios/{id}")
	public  ResponseEntity<?> update(@RequestBody Servicios servicio,@PathVariable int id) {
		
		Map<String, Object> response = new HashMap<>();
		
		Servicios servicioA= servicioService.findServiciosById(id);
		Servicios servicioUpdated = null;
		
		servicioA.setTitulo(servicio.getTitulo());
		servicioA.setTexto(servicio.getTexto());
		servicioA.setIcono(servicio.getIcono());
		
		servicioUpdated = servicioService.saveServicios(servicioA);
		System.out.print(servicioUpdated);
		response.put("mensaje", "Servicio Actualizado con exito!");
		response.put("servicio", servicioUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}