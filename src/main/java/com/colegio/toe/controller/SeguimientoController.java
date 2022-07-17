package com.colegio.toe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.toe.dto.SeguimientoDTORequest;
import com.colegio.toe.dto.SeguimientoDTOResponse;
import com.colegio.toe.service.SeguimientoService;
@RestController
@RequestMapping("/seguimiento/v1")
public class SeguimientoController {
	@Autowired
	private SeguimientoService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<SeguimientoDTOResponse>> listar() {
		return new ResponseEntity<List<SeguimientoDTOResponse>>( service.listar(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody SeguimientoDTORequest usuario) {
		service.guardar(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		SeguimientoDTOResponse p=service.obtenerById(id);
		if(p != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody SeguimientoDTORequest usuario) {
		SeguimientoDTOResponse p=service.obtenerById(usuario.getCodigoSeguimiento());
		
		if(p != null) {
			service.actualizar(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<SeguimientoDTOResponse> obtenerID(@PathVariable Integer id) {
		SeguimientoDTOResponse p=service.obtenerById(id);
		
		if(p != null) {			
			return new ResponseEntity<SeguimientoDTOResponse>(service.obtenerById(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<SeguimientoDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
