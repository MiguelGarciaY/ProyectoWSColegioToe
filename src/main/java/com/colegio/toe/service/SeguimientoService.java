package com.colegio.toe.service;

import java.util.List;

import com.colegio.toe.dto.SeguimientoDTORequest;
import com.colegio.toe.dto.SeguimientoDTOResponse;

public interface SeguimientoService {
	void guardar(SeguimientoDTORequest Seguimiento);
	void actualizar(SeguimientoDTORequest Seguimiento);
	void eliminar(Integer id);	
	List<SeguimientoDTOResponse>listar();
	SeguimientoDTOResponse obtenerById(Integer id);
}
