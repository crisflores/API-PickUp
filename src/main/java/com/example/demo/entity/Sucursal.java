package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sucursal {
	@Column(name="id")
	@Id
	private Integer id;
	@Column(name="direccion")
	private String direccion;
	@Column(name="latitud")
	private Integer latitud;
	@Column(name="longuitud")
	private Integer longuitud;
	
	public Integer getLatitud() {
		return latitud;
	}
	public void setLatitud(Integer latitud) {
		this.latitud = latitud;
	}
	public Integer getLonguitud() {
		return longuitud;
	}
	public void setLonguitud(Integer longuitud) {
		this.longuitud = longuitud;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
