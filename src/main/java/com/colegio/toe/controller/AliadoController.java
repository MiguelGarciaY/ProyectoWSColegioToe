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
import com.colegio.toe.dto.AliadoDTORequest;
import com.colegio.toe.dto.AliadoDTOResponse;
import com.colegio.toe.service.AliadoService;

@RestController
@RequestMapping("/aliado/v1")
public class AliadoController {
	@Autowired
	private AliadoService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<AliadoDTOResponse>> listar() {
		return new ResponseEntity<List<AliadoDTOResponse>>( service.listar(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody AliadoDTORequest usuario) {
		service.guardar(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		AliadoDTOResponse p=service.obtenerById(id);
		if(p != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody AliadoDTORequest usuario) {
		AliadoDTOResponse p=service.obtenerById(usuario.getCodigoAliado());
		
		if(p != null) {
			service.actualizar(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<AliadoDTOResponse> obtenerID(@PathVariable Integer id) {
		AliadoDTOResponse p=service.obtenerById(id);
		
		if(p != null) {			
			return new ResponseEntity<AliadoDTOResponse>(service.obtenerById(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<AliadoDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
