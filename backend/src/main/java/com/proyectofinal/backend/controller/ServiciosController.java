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
import com.proyectofinal.backend.entity.models.Users;
import com.proyectofinal.backend.service.IServiciosService;
import com.proyectofinal.backend.service.IUserService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class ServiciosController {

	@Autowired
	private IServiciosService servicioService;

	@Autowired
	private IUserService userSerivce;

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

	@Secured({ "ROLE_USER" })
	@PutMapping("/servicios/suscribe/{email}")
	public ResponseEntity<?> suscribe(@RequestBody Servicios servicio, @PathVariable String email) {
		Map<String, Object> response = new HashMap<>();
		Users usuario = userSerivce.findByEmail(email);

		try {
			List<Servicios> servicios = usuario.getServicios();
			servicios.add(servicio);
			usuario.setServicios(servicios);
			userSerivce.save(usuario);
			response.put("mensaje", "Se ha suscrito!");
		} catch (Exception e) {
			response.put("mensaje", "Ya esta suscrito a este servicio");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured({ "ROLE_ADMIN" })
	@PutMapping("/servicios/{id}")
	public ResponseEntity<?> update(@RequestBody Servicios servicio, @PathVariable int id) {

		Map<String, Object> response = new HashMap<>();

		Servicios servicioA = servicioService.findServiciosById(id);
		Servicios servicioUpdated = null;

		servicioA.setTitulo(servicio.getTitulo());
		servicioA.setTexto(servicio.getTexto());
		servicioA.setIcono(servicio.getIcono());

		servicioUpdated = servicioService.saveServicios(servicioA);

		response.put("mensaje", "Servicio Actualizado con exito!");
		response.put("servicio", servicioUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
