package com.example.demo.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Sucursal;
import com.example.demo.repository.SucursalRepository;

@Component
public class SucursalDao {
	@Autowired
	private SucursalRepository SucursalRepository;
	
	public Sucursal buscarSucursal(Integer id) {
		Optional <Sucursal> sucursal = SucursalRepository.findById(id);
		return sucursal.isPresent()? sucursal.get():null;
	}

	public Sucursal crearSucursal(Integer id, String direccion, Integer latitud, Integer longuitud) {
		Sucursal sucursal = new Sucursal();
		if(id >= 0 && direccion != null && latitud >= 0 && longuitud >= 0 && this.buscarSucursal(id) == null) {
			sucursal.setId(id);
			sucursal.setDireccion(direccion);
			sucursal.setLatitud(latitud);
			sucursal.setLonguitud(longuitud);
			this.SucursalRepository.save(sucursal);
			return sucursal;
		}
		return null;
	}

	public List<Sucursal> buscarTodasSucursales() {
		return SucursalRepository.findAll();
	}
}
