package com.proyectofinal.backend.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@Column(name = "nombre", length = 45)
	private String nombre;

	@Column(name = "apellidos", length = 100)
	private String apellidos;

	@Column(name = "email", length = 60, unique = true, nullable = false)
	private String email;
	
	@Column(name = "password", length = 60)
	@NotEmpty
	private String password;
	
	@Column(name = "enabled")
	private Boolean enabled;

	@Column(name = "telefono")
	@Digits(fraction = 0, integer = 10)
	private String telefono;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_at", insertable = false, updatable = false, nullable = false)
	private Date create_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_at", insertable = false, updatable = false, nullable = false)
	private Date update_at;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Roles> roles;
	
	private static final long serialVersionUID = 1L;
}
