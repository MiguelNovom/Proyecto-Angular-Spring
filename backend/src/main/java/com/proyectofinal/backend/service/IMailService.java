package com.proyectofinal.backend.service;

public interface IMailService {

	void sendMail(String from, String to, String subject, String body);

}