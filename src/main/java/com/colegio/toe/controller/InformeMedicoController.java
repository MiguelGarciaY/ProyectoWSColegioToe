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

import com.colegio.toe.dto.InformeMedicoDTORequest;
import com.colegio.toe.dto.InformeMedicoDTOResponse;
import com.colegio.toe.service.InformeMedicoService;

@RestController
@RequestMapping("/informe/v1")
public class InformeMedicoController {
	@Autowired
	private InformeMedicoService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<InformeMedicoDTOResponse>> listar() {
		return new ResponseEntity<List<InformeMedicoDTOResponse>>(service.listar(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody InformeMedicoDTORequest usuario) {
		service.guardar(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		InformeMedicoDTOResponse p=service.obtenerById(id);
		if(p != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody InformeMedicoDTORequest usuario) {
		InformeMedicoDTOResponse p=service.obtenerById(usuario.getCodigoInforme());
		
		if(p != null) {
			service.actualizar(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<InformeMedicoDTOResponse> obtenerID(@PathVariable Integer id) {
		InformeMedicoDTOResponse p=service.obtenerById(id);
		
		if(p != null) {			
			return new ResponseEntity<InformeMedicoDTOResponse>(service.obtenerById(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<InformeMedicoDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
