package com.proyectofinal.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Noticias findNoticiasById(Long id) {
		return noticeRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public Noticias saveNoticias(Noticias noticia) {
		return noticeRepository.save(noticia);
	}

	@Override
	@Transactional()
	public void deleteNoticiasById(Long id) {
		noticeRepository.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Page<Noticias> findAll(Pageable pageable) {
		return noticeRepository.findAll(pageable);
	}
}
