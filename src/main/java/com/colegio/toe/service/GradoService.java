package com.colegio.toe.service;

import java.util.List;

import com.colegio.toe.dto.GradoDTORequest;
import com.colegio.toe.dto.GradoDTOResponse;

public interface GradoService {
	void guardar(GradoDTORequest Grado);
	void actualizar(GradoDTORequest Grado);
	void eliminar(Integer id);	
	List<GradoDTOResponse>listar();
	GradoDTOResponse obtenerById(Integer id);
}
