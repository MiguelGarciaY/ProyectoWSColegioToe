package com.colegio.toe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.colegio.toe.dto.GradoDTOResponse;
import com.colegio.toe.dto.GradoDTORequest;
import com.colegio.toe.model.Grado;
import com.colegio.toe.repository.GradoRepository;

@Service
public class GradoServiceImpl implements GradoService{
	private GradoRepository repository;

	@Override
	public void guardar(GradoDTORequest GradoDTO) {
		Grado grado=new Grado();
		grado.setGrado(GradoDTO.getGradoAlumno());
		grado.setSeccion(GradoDTO.getSeccionAlumno());
		grado.setTurno(GradoDTO.getTurnoAlumno());		
		repository.save(grado);		
	}

	@Override
	public void actualizar(GradoDTORequest GradoDTO) {
		Grado grado=new Grado();
		grado.setIdGrado(GradoDTO.getCodigoGrado());
		grado.setGrado(GradoDTO.getGradoAlumno());
		grado.setSeccion(GradoDTO.getSeccionAlumno());
		grado.setTurno(GradoDTO.getTurnoAlumno());
		repository.saveAndFlush(grado);		
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public List<GradoDTOResponse> listar() {
		List<GradoDTOResponse> listar=new ArrayList<>();
		GradoDTOResponse dto=null;
		List<Grado> b=repository.findAll();
		
		for(Grado grado:b) {
			dto=new GradoDTOResponse();
			dto.setCodigoGrado(grado.getIdGrado());
			dto.setGradoAlumno(grado.getGrado());
			dto.setSeccionAlumno(grado.getSeccion());
			dto.setTurnoAlumno(grado.getTurno());
			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public GradoDTOResponse obtenerById(Integer id) {
		Grado grado=repository.findById(id).orElse(null);
		GradoDTOResponse dto=null;
		dto=new GradoDTOResponse();
		dto.setCodigoGrado(grado.getIdGrado());
		dto.setGradoAlumno(grado.getGrado());
		dto.setSeccionAlumno(grado.getSeccion());
		dto.setTurnoAlumno(grado.getTurno());
		return dto;
	}

}
