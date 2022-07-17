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

import com.colegio.toe.dto.CasoDTORequest;
import com.colegio.toe.dto.CasoDTOResponse;
import com.colegio.toe.service.CasoService;

@RestController
@RequestMapping("/caso/v1")
public class CasoController {
	@Autowired
	private CasoService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<CasoDTOResponse>> listar() {
		return new ResponseEntity<List<CasoDTOResponse>>( service.listar(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody CasoDTORequest usuario) {
		service.guardar(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		CasoDTOResponse p=service.obtenerById(id);
		if(p != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody CasoDTORequest usuario) {
		CasoDTOResponse p=service.obtenerById(usuario.getCodigoCaso());
		
		if(p != null) {
			service.actualizar(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<CasoDTOResponse> obtenerID(@PathVariable Integer id) {
		CasoDTOResponse p=service.obtenerById(id);
		
		if(p != null) {			
			return new ResponseEntity<CasoDTOResponse>(service.obtenerById(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<CasoDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
