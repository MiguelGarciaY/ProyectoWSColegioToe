package com.colegio.toe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.colegio.toe.dto.RolDTOResponse;
import com.colegio.toe.dto.RolDTORequest;
import com.colegio.toe.model.Rol;
import com.colegio.toe.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{
	private RolRepository repository;
	@Override
	public void guardar(RolDTORequest RolDTO) {
		Rol rol=new Rol();
		rol.setNombre(RolDTO.getRol());
		rol.setPermisos(RolDTO.getAccesos());				
		repository.save(rol);		
	}

	@Override
	public void actualizar(RolDTORequest RolDTO) {
		Rol rol=new Rol();
		rol.setId(RolDTO.getCodigoRol());
		rol.setNombre(RolDTO.getRol());
		rol.setPermisos(RolDTO.getAccesos());	
		repository.saveAndFlush(rol);			
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);			
	}

	@Override
	public List<RolDTOResponse> listar() {
		List<RolDTOResponse> listar=new ArrayList<>();
		RolDTOResponse dto=null;
		List<Rol> b=repository.findAll();
		
		for(Rol rol:b) {
			dto=new RolDTOResponse();
			dto.setCodigoRol(rol.getId());
			dto.setRol(rol.getNombre());
			dto.setAccesos(rol.getPermisos());			
			listar.add(dto);			
		}
		return listar;
	}

	@Override
	public RolDTOResponse obtenerById(Integer id) {
		Rol rol=repository.findById(id).orElse(null);
		RolDTOResponse dto=null;
		dto=new RolDTOResponse();
		dto.setCodigoRol(rol.getId());
		dto.setRol(rol.getNombre());
		dto.setAccesos(rol.getPermisos());	
		return dto;
	}

}
