package com.colegio.toe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.colegio.toe.dto.InformeMedicoDTOResponse;
import com.colegio.toe.dto.InformeMedicoDTORequest;
import com.colegio.toe.model.InformeMedico;
import com.colegio.toe.repository.InformeMedicoRepository;

@Service
public class InformeMedicoServiceImpl implements InformeMedicoService{
	private InformeMedicoRepository repository;

	@Override
	public void guardar(InformeMedicoDTORequest InformeMedicoDTO) {
		InformeMedico informeMedico=new InformeMedico();
		informeMedico.setFecha(InformeMedicoDTO.getFechaInforme());
		informeMedico.setDescripcion(InformeMedicoDTO.getDetalleInforme());		
		repository.save(informeMedico);		
	}

	@Override
	public void actualizar(InformeMedicoDTORequest InformeMedicoDTO) {
		InformeMedico informeMedico=new InformeMedico();
		informeMedico.setIdInforme(InformeMedicoDTO.getCodigoInforme());
		informeMedico.setFecha(InformeMedicoDTO.getFechaInforme());
		informeMedico.setDescripcion(InformeMedicoDTO.getDetalleInforme());	
		repository.saveAndFlush(informeMedico);			
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);			
	}

	@Override
	public List<InformeMedicoDTOResponse> listar() {
		List<InformeMedicoDTOResponse> listar=new ArrayList<>();
		InformeMedicoDTOResponse dto=null;
		List<InformeMedico> b=repository.findAll();
		
		for(InformeMedico informeMedico:b) {
			dto=new InformeMedicoDTOResponse();
			dto.setCodigoInforme(informeMedico.getIdInforme());
			dto.setFechaInforme(informeMedico.getFecha());
			dto.setDetalleInforme(informeMedico.getDescripcion());		
			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public InformeMedicoDTOResponse obtenerById(Integer id) {
		InformeMedico informeMedico=repository.findById(id).orElse(null);
		InformeMedicoDTOResponse dto=null;
		dto=new InformeMedicoDTOResponse();
		dto.setCodigoInforme(informeMedico.getIdInforme());
		dto.setFechaInforme(informeMedico.getFecha());
		dto.setDetalleInforme(informeMedico.getDescripcion());
		return dto;
	}

}
