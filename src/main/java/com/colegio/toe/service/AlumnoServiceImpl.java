package com.colegio.toe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.toe.dto.AlumnoDTOResponse;
import com.colegio.toe.dto.AlumnoDTORequest;
import com.colegio.toe.model.Alumno;
import com.colegio.toe.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{
	
	@Autowired
	private AlumnoRepository repository;

	@Override
	public void guardar(AlumnoDTORequest AlumnoDTO) {
		Alumno alumno=new Alumno();
		alumno.setEstado(AlumnoDTO.getActivo());
		alumno.setNombre(AlumnoDTO.getNombreAlumno());
		alumno.setDni(AlumnoDTO.getDocumento());
		alumno.setEdad(AlumnoDTO.getEdadAlumno());
		alumno.setPeso(AlumnoDTO.getPesoAlumno());
		alumno.setApoderado(AlumnoDTO.getRepresentante());
		alumno.setTelefono(AlumnoDTO.getNumeroTelf());
		alumno.setDireccion(AlumnoDTO.getDomicilio());
		alumno.setFaltas(AlumnoDTO.getFaltasAlumno());
		alumno.setConducta(AlumnoDTO.getConductaAlumno());
		repository.save(alumno);
	}

	@Override
	public void actualizar(AlumnoDTORequest AlumnoDTO) {
		Alumno alumno=new Alumno();
		alumno.setIdAlumno(AlumnoDTO.getCodigoAlumno());
		alumno.setEstado(AlumnoDTO.getActivo());
		alumno.setNombre(AlumnoDTO.getNombreAlumno());
		alumno.setDni(AlumnoDTO.getDocumento());
		alumno.setEdad(AlumnoDTO.getEdadAlumno());
		alumno.setPeso(AlumnoDTO.getPesoAlumno());
		alumno.setApoderado(AlumnoDTO.getRepresentante());
		alumno.setTelefono(AlumnoDTO.getNumeroTelf());
		alumno.setDireccion(AlumnoDTO.getDomicilio());
		alumno.setFaltas(AlumnoDTO.getFaltasAlumno());
		alumno.setConducta(AlumnoDTO.getConductaAlumno());
		repository.saveAndFlush(alumno);
		
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public List<AlumnoDTOResponse> listar() {
		List<AlumnoDTOResponse> listar=new ArrayList<>();
		AlumnoDTOResponse dto=null;
		List<Alumno> b=repository.findAll();
		
		for(Alumno alumno:b) {
			dto=new AlumnoDTOResponse();
			dto.setCodigoAlumno(alumno.getIdAlumno());
			dto.setActivo(alumno.getEstado());
			dto.setNombreAlumno(alumno.getNombre());
			dto.setDocumento(alumno.getDni());
			dto.setEdadAlumno(alumno.getEdad());
			dto.setPesoAlumno(alumno.getPeso());
			dto.setRepresentante(alumno.getApoderado());
			dto.setNumeroTelf(alumno.getTelefono());
			dto.setDomicilio(alumno.getDireccion());
			dto.setFaltasAlumno(alumno.getFaltas());
			dto.setConductaAlumno(alumno.getConducta());
			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public AlumnoDTOResponse obtenerById(Integer id) {
		Alumno alumno=repository.findById(id).orElse(null);
		AlumnoDTOResponse dto=null;
		dto=new AlumnoDTOResponse();
		dto.setCodigoAlumno(alumno.getIdAlumno());
		dto.setActivo(alumno.getEstado());
		dto.setNombreAlumno(alumno.getNombre());
		dto.setDocumento(alumno.getDni());
		dto.setEdadAlumno(alumno.getEdad());
		dto.setPesoAlumno(alumno.getPeso());
		dto.setRepresentante(alumno.getApoderado());
		dto.setNumeroTelf(alumno.getTelefono());
		dto.setDomicilio(alumno.getDireccion());
		dto.setFaltasAlumno(alumno.getFaltas());
		dto.setConductaAlumno(alumno.getConducta());
		return dto;
	}

}
