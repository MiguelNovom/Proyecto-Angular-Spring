package com.proyectofinal.backend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@Column(name = "nombre", length = 45)
	private String nombre;

	@Column(name = "apellidos", length = 100)
	private String apellidos;

	@Column(name = "email", length = 60, unique = true, nullable = false)
	private String email;
	
	@Column(name = "password", length = 64)
	@NotEmpty
	private String password;

	@Column(name = "telefono")
	@Digits(fraction = 0, integer = 10)
	private String telefono;
	
	@Column(name = "status")
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_at", insertable = false, updatable = false, nullable = false)
	private Date create_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_at", insertable = false, updatable = false, nullable = false)
	private Date update_at;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public User(Integer id, String nombre, String apellidos, String email, @NotEmpty String password,
			@Digits(fraction = 0, integer = 10) String telefono, Date create_at, Date update_at) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.create_at = create_at;
		this.update_at = update_at;
	}
	public User(String status) {
		this.status=status;
	}
}
