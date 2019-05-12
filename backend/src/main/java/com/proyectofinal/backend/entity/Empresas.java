package com.proyectofinal.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "descripcion")
	private String descripcion;
}
