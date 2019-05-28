package com.proyectofinal.backend.entity.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	@JsonIgnoreProperties({"servicios"})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Users users;

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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Servicios(Integer id, String titulo, String icono, String texto, Users users) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.icono = icono;
		this.texto = texto;
		this.users = users;
	}
	public Servicios() {
		
	}

	@Override
	public String toString() {
		return "Servicios [id=" + id + ", titulo=" + titulo + ", icono=" + icono + ", texto=" + texto + ", users="
				+ users + "]";
	}
	private static final long serialVersionUID = 1L;
	
}
