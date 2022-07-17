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
import com.colegio.toe.dto.AlumnoDTORequest;
import com.colegio.toe.dto.AlumnoDTOResponse;
import com.colegio.toe.service.AlumnoService;

@RestController
@RequestMapping("/alumno/v1")
public class AlumnoController {
	@Autowired
	private AlumnoService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<AlumnoDTOResponse>> listar() {
		return new ResponseEntity<List<AlumnoDTOResponse>>( service.listar(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody AlumnoDTORequest usuario) {
		service.guardar(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		AlumnoDTOResponse p=service.obtenerById(id);
		if(p != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody AlumnoDTORequest usuario) {
		AlumnoDTOResponse p=service.obtenerById(usuario.getCodigoAlumno());
		
		if(p != null) {
			service.actualizar(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<AlumnoDTOResponse> obtenerID(@PathVariable Integer id) {
		AlumnoDTOResponse p=service.obtenerById(id);
		
		if(p != null) {			
			return new ResponseEntity<AlumnoDTOResponse>(service.obtenerById(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<AlumnoDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
