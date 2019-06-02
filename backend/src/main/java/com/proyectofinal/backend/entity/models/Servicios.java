package com.proyectofinal.backend.entity.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicios")
public class Servicios implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "icono")
	private String icono;
	
	@Column(name = "texto", columnDefinition="TEXT")
	private String texto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Servicios(Integer id, String titulo, String icono, String texto) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.icono = icono;
		this.texto = texto;
	}
	public Servicios() {
		
	}

	@Override
	public String toString() {
		return "Servicios [id=" + id + ", titulo=" + titulo + ", icono=" + icono + ", texto=" + texto +"]";
	}
	private static final long serialVersionUID = 1L;
	
}
