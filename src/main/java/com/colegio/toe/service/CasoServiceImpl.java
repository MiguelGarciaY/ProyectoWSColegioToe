package com.colegio.toe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.toe.dto.CasoDTOResponse;
import com.colegio.toe.dto.CasoDTORequest;
import com.colegio.toe.model.Caso;
import com.colegio.toe.repository.CasoRepository;

@Service
public class CasoServiceImpl implements CasoService{
	
	@Autowired
	private CasoRepository repository;

	@Override
	public void guardar(CasoDTORequest CasoDTO) {
		Caso caso=new Caso();
		caso.setDescripcion(CasoDTO.getDetalleCaso());
		caso.setFecha(CasoDTO.getFechaCaso());
		caso.setTutor(CasoDTO.getTutorCaso());
		caso.setEstado(CasoDTO.getActivoCaso());
		caso.setPrioridad(CasoDTO.getPrioridadCaso());
		repository.save(caso);		
	}

	@Override
	public void actualizar(CasoDTORequest CasoDTO) {
		Caso caso=new Caso();
		caso.setIdCaso(CasoDTO.getCodigoCaso());
		caso.setDescripcion(CasoDTO.getDetalleCaso());
		caso.setFecha(CasoDTO.getFechaCaso());
		caso.setTutor(CasoDTO.getTutorCaso());
		caso.setEstado(CasoDTO.getActivoCaso());
		caso.setPrioridad(CasoDTO.getPrioridadCaso());
		repository.saveAndFlush(caso);		
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);	
		
	}

	@Override
	public List<CasoDTOResponse> listar() {
		List<CasoDTOResponse> listar=new ArrayList<>();
		CasoDTOResponse dto=null;
		List<Caso> b=repository.findAll();
		
		for(Caso caso:b) {
			dto=new CasoDTOResponse();
			dto.setCodigoCaso(caso.getIdCaso());
			dto.setDetalleCaso(caso.getDescripcion());
			dto.setFechaCaso(caso.getFecha());
			dto.setTutorCaso(caso.getTutor());
			dto.setActivoCaso(caso.getEstado());
			dto.setPrioridadCaso(caso.getPrioridad());
			listar.add(dto);
		}
		return listar;
	}

	@Override
	public CasoDTOResponse obtenerById(Integer id) {
		Caso caso=repository.findById(id).orElse(null);
		CasoDTOResponse dto=null;
		dto=new CasoDTOResponse();
		dto.setCodigoCaso(caso.getIdCaso());
		dto.setDetalleCaso(caso.getDescripcion());
		dto.setFechaCaso(caso.getFecha());
		dto.setTutorCaso(caso.getTutor());
		dto.setActivoCaso(caso.getEstado());
		dto.setPrioridadCaso(caso.getPrioridad());
		return dto;
	}
}
