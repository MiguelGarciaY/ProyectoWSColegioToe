package com.colegio.toe.service;

import java.util.List;

import com.colegio.toe.dto.RolDTORequest;
import com.colegio.toe.dto.RolDTOResponse;

public interface RolService {
	void guardar(RolDTORequest Rol);
	void actualizar(RolDTORequest Rol);
	void eliminar(Integer id);	
	List<RolDTOResponse>listar();
	RolDTOResponse obtenerById(Integer id);
}
