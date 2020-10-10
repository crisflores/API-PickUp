package com.example.demo.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SucursalDao;
import com.example.demo.dto.SucursalResponseDto;
import com.example.demo.entity.Sucursal;

@Service
public class SucursalServices {
	
	@Autowired
	private SucursalDao dao;
	List<Sucursal> sucursales;
	double minimo;
	
	public SucursalResponseDto getSucursal(Integer latitud, Integer longuitud) {
		
		SucursalResponseDto respuesta = null;
		double aux;
		this.minimo = Integer.MAX_VALUE;
		sucursales = dao.buscarTodasSucursales();
		respuesta = sucursales!=null? new SucursalResponseDto():null;
		for (Sucursal obj1: sucursales) {
			aux = Math.sqrt( Math.pow(obj1.getLatitud() - latitud,2) + Math.pow(obj1.getLonguitud() - longuitud,2));
			if(minimo>=aux) {
				minimo=aux;
				respuesta.setId(obj1.getId());
				respuesta.setLatitud(obj1.getLatitud());
				respuesta.setLonguitud(obj1.getLonguitud());
				respuesta.setDireccion(obj1.getDireccion());
				
			}
		}
		return respuesta;
	}

	public SucursalResponseDto createSucursal(Integer id, String direccion, Integer latitud, Integer longuitud) {
		SucursalResponseDto respuesta = null;
		Sucursal aux = this.dao.crearSucursal(id, direccion, latitud, longuitud);
		if( aux != null) {
			respuesta = new SucursalResponseDto();
			respuesta.setId(aux.getId());
			respuesta.setDireccion(aux.getDireccion());
			respuesta.setLatitud(aux.getLatitud());
			respuesta.setLonguitud(aux.getLonguitud());
			return respuesta;
		}
		return respuesta;
	}
	
	public SucursalResponseDto buscarSucursal(Integer id) {
		SucursalResponseDto respuesta = null;
		Sucursal sucursal = dao.buscarSucursal(id);
		if(sucursal != null) {
			respuesta = new SucursalResponseDto();
			respuesta.setId(sucursal.getId());
			respuesta.setDireccion(sucursal.getDireccion());
			respuesta.setLatitud(sucursal.getLatitud());
			respuesta.setLonguitud(sucursal.getLonguitud());
		}
		return respuesta;
	}
}
