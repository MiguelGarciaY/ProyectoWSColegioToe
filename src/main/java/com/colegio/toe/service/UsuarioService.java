package com.colegio.toe.service;

import java.util.List;

import com.colegio.toe.dto.UsuarioDTORequest;
import com.colegio.toe.dto.UsuarioDTOResponse;

public interface UsuarioService {
	void guardar(UsuarioDTORequest Usuario);
	void actualizar(UsuarioDTORequest Usuario);
	void eliminar(Integer id);	
	List<UsuarioDTOResponse>listar();
	UsuarioDTOResponse obtenerById(Integer id);
}
