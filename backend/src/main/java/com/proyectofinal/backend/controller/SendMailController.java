package com.proyectofinal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.backend.entity.models.MensajeContacto;
import com.proyectofinal.backend.service.IMailService;

@RestController
public class SendMailController {

	@Autowired
	private IMailService mailService;

	@PostMapping("/api/sendmail")
	@ResponseStatus(HttpStatus.CREATED)
	public String sendMail(@RequestBody MensajeContacto mensaje) {

		String message = mensaje.getMensaje() + "\n\n Datos de contacto: " + "\nNombre: " + mensaje.getNombre()
				+ "\nE-mail: " + mensaje.getMail();
		mailService.sendMail("trabajodjangocorreo@gmail.com", "miguel.novom@gmail.com", mensaje.getAsunto(), message);
		return message;
	}
}
