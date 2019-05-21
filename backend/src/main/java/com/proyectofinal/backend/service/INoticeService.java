package com.proyectofinal.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyectofinal.backend.entity.models.Noticias;

public interface INoticeService {
	
	public Page<Noticias> findAll(Pageable pageable);
	
	public Noticias findNoticiasById(Long id);

	public Noticias saveNoticias(Noticias noticia);

	public void deleteNoticiasById(Long id);
	
	
}
