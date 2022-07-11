package com.colegio.toe.service;

import java.util.List;

import com.colegio.toe.dto.CasoDTORequest;
import com.colegio.toe.dto.CasoDTOResponse;

public interface CasoService {
	void guardar(CasoDTORequest Caso);
	void actualizar(CasoDTORequest Caso);
	void eliminar(Integer id);	
	List<CasoDTOResponse>listar();
	CasoDTOResponse obtenerById(Integer id);
}
