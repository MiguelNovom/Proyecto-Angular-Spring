package com.proyectofinal.backend.service;

import java.util.List;

import com.proyectofinal.backend.entity.models.Noticias;

public interface INoticeService {
	
	public List<Noticias> findAllOrderByDate();
	
	public Noticias findNoticiasById(int id);

	public Noticias saveNoticias(Noticias noticia);

	public void deleteNoticiasById(int id);
	
}
