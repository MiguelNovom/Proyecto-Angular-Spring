package com.proyectofinal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.backend.entity.models.Noticias;
import com.proyectofinal.backend.service.INoticeService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class NoticeController {
	
	@Autowired
	private INoticeService noticeService;

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/noticias/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Noticias show(@PathVariable Long id) {
		return noticeService.findNoticiasById(id);
	}
	
	@GetMapping("/noticias/page/{page}")
	public Page<Noticias> list(@PathVariable Integer page) {
		return noticeService.findAll(PageRequest.of(page, 6));
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/noticias/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		noticeService.deleteNoticiasById(id);;
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/noticias")
	@ResponseStatus(HttpStatus.CREATED)
	public Noticias create(@RequestBody Noticias noticia) {
		return noticeService.saveNoticias(noticia);
	}

}
