package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.SucursalResponseDto;
import com.example.demo.services.SucursalServices;

@SpringBootTest
class StaterPickUpApplicationTests {
	
	@Autowired
	SucursalServices SucursalServices;
	
	@Test
	void pruebaCracionFallida() {
		SucursalServices.createSucursal(1, "Medrano 1023", 4, 6);
		//no se pueden crear dos sucursales exactamente iguales
		assertNotEquals(null,SucursalServices.createSucursal(1, "Medrano 1023", 4, 6));
	}
	
	@Test
	void pruebaCreacionExitosa() {
		SucursalResponseDto sucursal;
		sucursal = SucursalServices.createSucursal(5, "Papa Francisco 2020", 7, 20);
		//la sucursal se creo correctamente
		assertEquals(5,sucursal.getId());
		assertEquals("Papa Francisco 2020",sucursal.getDireccion());
		assertEquals(7,sucursal.getLatitud());
		assertEquals(20,sucursal.getLonguitud());
	}
	
	@Test
	void pruebaDistancia() {
		
		SucursalResponseDto sucursal;
		SucursalServices.createSucursal(0, "Papa Francisco 2020", 1, 3);
		SucursalServices.createSucursal(1, "Somos Colinia 4092", 3, 7);
		SucursalServices.createSucursal(2, "Santiago 92", 10, 15);
		SucursalServices.createSucursal(3, "Barca 678", 12, 11);
		SucursalServices.createSucursal(4, "Alforo 2312", 11, 9);

		sucursal = SucursalServices.getSucursal(6, 12);
		assertEquals(2,sucursal.getId());
		assertEquals("Santiago 92",sucursal.getDireccion());
		assertEquals(10,sucursal.getLatitud());
		assertEquals(15,sucursal.getLonguitud());
	}

}
