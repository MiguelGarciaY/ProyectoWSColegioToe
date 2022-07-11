package com.colegio.toe.service;

import java.util.List;

import com.colegio.toe.dto.InformeMedicoDTORequest;
import com.colegio.toe.dto.InformeMedicoDTOResponse;

public interface InformeMedicoService {
	void guardar(InformeMedicoDTORequest InformeMedico);
	void actualizar(InformeMedicoDTORequest InformeMedico);
	void eliminar(Integer id);	
	List<InformeMedicoDTOResponse>listar();
	InformeMedicoDTOResponse obtenerById(Integer id);
}
