package com.proyectofinal.backend.entity.models;

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class Users implements Serializable{

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
	@Column(name = "create_at", insertable = false, updatable = false)
	private Date create_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_at", insertable = false, updatable = false, nullable = true)
	private Date update_at;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="users_roles", joinColumns= @JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"user_id", "role_id"})})
	private List<Roles> roles;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", password=" + password + ", enabled=" + enabled + ", telefono=" + telefono + ", create_at="
				+ create_at + ", update_at=" + update_at + ", roles=" + roles + "]";
	}

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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	
	
}
