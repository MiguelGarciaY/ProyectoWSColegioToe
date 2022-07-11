package com.colegio.toe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.toe.dto.AliadoDTORequest;
import com.colegio.toe.dto.AliadoDTOResponse;
import com.colegio.toe.model.Aliado;
import com.colegio.toe.repository.AliadoRepository;

@Service
public class AliadoServiceImpl implements AliadoService{

	@Autowired
	private AliadoRepository repository;
	
	@Override
	public void guardar(AliadoDTORequest AliadoDTO) {
		Aliado aliado=new Aliado();
		aliado.setDescripcion(AliadoDTO.getDetalleAliado());
		aliado.setCorreo(AliadoDTO.getEmailAliado());
		aliado.setTelefono(AliadoDTO.getTelfAliado());		
		repository.save(aliado);
	}

	@Override
	public void actualizar(AliadoDTORequest AliadoDTO) {
		Aliado aliado=new Aliado();
		aliado.setIdAliado(AliadoDTO.getCodigoAliado());
		aliado.setDescripcion(AliadoDTO.getDetalleAliado());
		aliado.setCorreo(AliadoDTO.getEmailAliado());
		aliado.setTelefono(AliadoDTO.getTelfAliado());
		repository.saveAndFlush(aliado);
	}

	@Override
	public void eliminar(Integer id) {	
		repository.deleteById(id);
	}

	@Override
	public List<AliadoDTOResponse> listar() {
		List<AliadoDTOResponse> listar=new ArrayList<>();
		AliadoDTOResponse dto=null;
		List<Aliado> b=repository.findAll();
		
		for(Aliado aliado:b) {
			dto=new AliadoDTOResponse();
			dto.setCodigoAliado(aliado.getIdAliado());
			dto.setDetalleAliado(aliado.getDescripcion());
			dto.setEmailAliado(aliado.getCorreo());
			dto.setTelfAliado(aliado.getTelefono());
			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public AliadoDTOResponse obtenerById(Integer id) {
		Aliado aliado=repository.findById(id).orElse(null);
		AliadoDTOResponse dto=null;
		dto=new AliadoDTOResponse();
		dto.setCodigoAliado(aliado.getIdAliado());
		dto.setDetalleAliado(aliado.getDescripcion());
		dto.setEmailAliado(aliado.getCorreo());
		dto.setTelfAliado(aliado.getTelefono());
		return dto;
	}
}
