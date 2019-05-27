package com.proyectofinal.backend.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proyectofinal.backend.entity.models.Noticias;
import com.proyectofinal.backend.service.INoticeService;
import com.proyectofinal.backend.service.IUploadService;


@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class NoticeController {

	@Autowired
	private IUploadService uploadService;

	@Autowired
	private INoticeService noticeService;


	@GetMapping("/noticias/{id}")
	public Noticias show(@PathVariable int id) {
		return noticeService.findNoticiasById(id);
	}
	
	@GetMapping("/noticias")
	public List<Noticias> list() {
		return noticeService.findAllOrderByDate();
	}

	@Secured({ "ROLE_ADMIN" })
	@DeleteMapping("/noticias/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		noticeService.deleteNoticiasById(id);
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("/noticias")
	@ResponseStatus(HttpStatus.CREATED)
	public Noticias create(@RequestBody Noticias noticia) {
		return noticeService.saveNoticias(noticia);
	}
	
	@Secured({ "ROLE_ADMIN" })
	@PutMapping("/noticias/{id}")
	public  ResponseEntity<?> update(@RequestBody Noticias noticia,@PathVariable int id) {
		
		Map<String, Object> response = new HashMap<>();
		
		Noticias noticiaA= noticeService.findNoticiasById(id);
		Noticias noticiaUpdated = null;
		Date fechaModificacion = new Date();
		
		noticiaA.setTitulo(noticia.getTitulo());
		noticiaA.setTexto(noticia.getTexto());
		noticiaA.setCreate_at(fechaModificacion);
		noticiaA.setImagen(noticia.getImagen());
		
		noticiaUpdated = noticeService.saveNoticias(noticiaA);
		System.out.print(noticiaUpdated);
		response.put("mensaje", "Noticia Actualizada con exito!");
		response.put("noticia", noticiaUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("/noticias/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") int id) {
		Map<String, Object> response = new HashMap<>();

		Noticias notica = noticeService.findNoticiasById(id);

		if (!archivo.isEmpty()) {
			String nombreArchivo = null;
			try {
				nombreArchivo = uploadService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen del cliente");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			String nombreFotoAnterior = notica.getImagen();

			uploadService.eliminar(nombreFotoAnterior);

			notica.setImagen(nombreArchivo);

			noticeService.saveNoticias(notica);

			response.put("noticia", notica);
			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);

		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {

		Resource resource = null;
		try {
			resource = uploadService.cargar(nombreFoto);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");

		return new ResponseEntity<Resource>(resource, cabecera, HttpStatus.OK);
	}
}
