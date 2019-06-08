package com.proyectofinal.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.backend.entity.models.MensajeContacto;
import com.proyectofinal.backend.service.IMailService;

@RestController
public class SendMailController {

	@Autowired
	private IMailService mailService;

	@PostMapping("/api/sendmail")
	public ResponseEntity<?> sendMail(@RequestBody MensajeContacto emailmessage)
			{
		String message = emailmessage.getMensaje() + "\n\n Datos de contacto: " + "\nNombre: " + emailmessage.getNombre()
				+ "\nE-mail: " + emailmessage.getMail();
		mailService.sendMail("trabajodjangocorreo@gmail.com", "miguel.novom@gmail.com", emailmessage.getAsunto(), message);
		Map<String, Object> response =  new HashMap<>();
		response.put("mensaje", "Se ha enviado su mensaje correctamente.");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
