package com.proyectofinal.backend.entity.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "noticias")
public class Noticias implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "foto")
	private String imagen;
	
	@Column(name = "texto")
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_at", insertable = false, updatable = false)
	private Date create_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_at", insertable = false, updatable = false, nullable = true)
	private Date update_at;
	
	@JsonIgnoreProperties({"facturas"})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Users users;
	
	@PrePersist
	public void prePersist() {
		this.create_at = new Date();
	}

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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Noticias(Integer id, String titulo, String imagen, String texto, Date create_at, Date update_at,
			Users users) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.imagen = imagen;
		this.texto = texto;
		this.create_at = create_at;
		this.update_at = update_at;
		this.users = users;
	}
	public Noticias() {
		
	}

	@Override
	public String toString() {
		return "Noticias [id=" + id + ", titulo=" + titulo + ", imagen=" + imagen + ", texto=" + texto + ", create_at="
				+ create_at + ", update_at=" + update_at + ", users=" + users + "]";
	}
	
	private static final long serialVersionUID = 1L;
}
