package com.colegio.toe.service;

import java.util.List;

import com.colegio.toe.dto.AliadoDTORequest;
import com.colegio.toe.dto.AliadoDTOResponse;

public interface AliadoService {
	void guardar(AliadoDTORequest Aliado);
	void actualizar(AliadoDTORequest Aliado);
	void eliminar(Integer id);	
	List<AliadoDTOResponse>listar();
	AliadoDTOResponse obtenerById(Integer id);
}
