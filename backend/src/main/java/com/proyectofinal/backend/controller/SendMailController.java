package com.proyectofinal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.backend.entity.models.MensajeContacto;
import com.proyectofinal.backend.service.MailService;

@RestController
public class SendMailController {

	@Autowired
	private MailService mailService;

	@PostMapping("/api/sendmail")
	@ResponseStatus(HttpStatus.CREATED)
	public String sendMail(@RequestBody MensajeContacto mensaje) {
		System.out.print(mensaje.getAsunto());
		String message = mensaje.getMensaje() + "\n\n Datos de contacto: " + "\nNombre: " + mensaje.getNombre()
				+ "\nE-mail: " + mensaje.getMail();
		mailService.sendMail("miguel.novom@gmail.com", "trabajodjangocorreo@gmail.com", mensaje.getAsunto(), message);

		return message;
	}
}
