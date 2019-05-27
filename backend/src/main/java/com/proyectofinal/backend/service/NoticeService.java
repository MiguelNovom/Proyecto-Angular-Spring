package com.proyectofinal.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectofinal.backend.entity.models.Noticias;
import com.proyectofinal.backend.repository.NoticeRepository;

@Service
public class NoticeService implements INoticeService {
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Noticias findNoticiasById(int id) {
		return noticeRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public Noticias saveNoticias(Noticias noticia) {
		return noticeRepository.save(noticia);
	}

	@Override
	@Transactional()
	public void deleteNoticiasById(int id) {
		noticeRepository.deleteById(id);

	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Noticias> findAllOrderByDate() {
		return noticeRepository.findAllOrderByDate();
	}
}
