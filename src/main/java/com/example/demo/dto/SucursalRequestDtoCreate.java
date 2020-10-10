package com.example.demo.dto;

public class SucursalRequestDtoCreate {
	private Integer id;
	private String direccion;
	private Integer longuitud;
	private Integer latitud;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getLonguitud() {
		return longuitud;
	}
	public void setLonguitud(Integer longuitud) {
		this.longuitud = longuitud;
	}
	public Integer getLatitud() {
		return latitud;
	}
	public void setLatitud(Integer latitud) {
		this.latitud = latitud;
	}

}
