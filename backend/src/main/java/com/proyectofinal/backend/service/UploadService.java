package com.proyectofinal.backend.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService implements IUploadService {

	private final static String DIR_STATIC = "uploads";

	@Override
	public Resource cargar(String nombreFoto) throws MalformedURLException {

		Path path = getPath(nombreFoto);
		Resource resource = new UrlResource(path.toUri());
		if (!resource.exists() && !resource.isReadable()) {
			path = Paths.get("src/main/resources/static/images").resolve("no-image.png").toAbsolutePath();
			resource = new UrlResource(path.toUri());
		}
		return resource;
	}

	@Override
	public String copiar(MultipartFile archivo) throws IOException {
		
		String nombreArchivo = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename().replace(" ", "");
		Path path = getPath(nombreArchivo);
		Files.copy(archivo.getInputStream(), path);
		return nombreArchivo;
	}

	@Override
	public boolean eliminar(String nombreFoto) {
		
		if (nombreFoto != null && nombreFoto.length() > 0) {
			Path pathAnterior = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
			File archivoFotoAnterior = pathAnterior.toFile();
			if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
				archivoFotoAnterior.delete();
				return true;
			}
		}

		return false;
	}

	@Override
	public Path getPath(String nombreFoto) {
		return Paths.get(DIR_STATIC).resolve(nombreFoto).toAbsolutePath();
	}

}
