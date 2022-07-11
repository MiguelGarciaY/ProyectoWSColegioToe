package com.colegio.toe.service;

import java.util.List;

import com.colegio.toe.dto.AlumnoDTORequest;
import com.colegio.toe.dto.AlumnoDTOResponse;

public interface AlumnoService {
	void guardar(AlumnoDTORequest Alumno);
	void actualizar(AlumnoDTORequest Alumno);
	void eliminar(Integer id);	
	List<AlumnoDTOResponse>listar();
	AlumnoDTOResponse obtenerById(Integer id);
}
