package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SucursalRequestDto;
import com.example.demo.dto.SucursalRequestDtoBuscar;
import com.example.demo.dto.SucursalRequestDtoCreate;
import com.example.demo.dto.SucursalResponseDto;
import com.example.demo.services.SucursalServices;

@RestController
public class SucursalController {
	
	@Autowired
	private SucursalServices SucursalServices;
	
	@RequestMapping(value = "/getSucursal", method = RequestMethod.POST, produces = { "application/json" } )
	public SucursalResponseDto getSucursal(@RequestBody SucursalRequestDto Request) {
		return this.SucursalServices.getSucursal(Request.getLatitud(),Request.getLonguitud());
	}
	@RequestMapping(value = "/createSucursal", method = RequestMethod.POST, produces = { "application/json" } )
	public SucursalResponseDto createSucursal(@RequestBody SucursalRequestDtoCreate Request) {
		return this.SucursalServices.createSucursal(Request.getId(),Request.getDireccion(),Request.getLatitud(),Request.getLonguitud());
	}
	@RequestMapping(value = "/buscarSucursal", method = RequestMethod.POST, produces = { "application/json" } )
	public SucursalResponseDto buscarSucursal(@RequestBody SucursalRequestDtoBuscar Request) {
		return this.SucursalServices.buscarSucursal(Request.getId());
	}
}
