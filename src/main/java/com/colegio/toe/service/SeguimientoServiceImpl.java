package com.colegio.toe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.colegio.toe.dto.SeguimientoDTOResponse;
import com.colegio.toe.dto.SeguimientoDTORequest;
import com.colegio.toe.model.Seguimiento;
import com.colegio.toe.repository.SeguimientoRepository;

@Service
public class SeguimientoServiceImpl implements SeguimientoService{
	private SeguimientoRepository repository;

	@Override
	public void guardar(SeguimientoDTORequest SeguimientoDTO) {
		Seguimiento seguimiento=new Seguimiento();
		seguimiento.setDescripcion(SeguimientoDTO.getDetalleSeguimiento());
		seguimiento.setFecha(SeguimientoDTO.getFechaSeguimiento());				
		repository.save(seguimiento);		
	}

	@Override
	public void actualizar(SeguimientoDTORequest SeguimientoDTO) {
		Seguimiento seguimiento=new Seguimiento();
		seguimiento.setIdSeguimiento(SeguimientoDTO.getCodigoSeguimiento());
		seguimiento.setDescripcion(SeguimientoDTO.getDetalleSeguimiento());
		seguimiento.setFecha(SeguimientoDTO.getFechaSeguimiento());	
		repository.saveAndFlush(seguimiento);			
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public List<SeguimientoDTOResponse> listar() {
		List<SeguimientoDTOResponse> listar=new ArrayList<>();
		SeguimientoDTOResponse dto=null;
		List<Seguimiento> b=repository.findAll();
		
		for(Seguimiento seguimiento:b) {
			dto=new SeguimientoDTOResponse();
			dto.setCodigoSeguimiento(seguimiento.getIdSeguimiento());
			dto.setDetalleSeguimiento(seguimiento.getDescripcion());
			dto.setFechaSeguimiento(seguimiento.getFecha());			
			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public SeguimientoDTOResponse obtenerById(Integer id) {
		Seguimiento seguimiento=repository.findById(id).orElse(null);
		SeguimientoDTOResponse dto=null;
		dto=new SeguimientoDTOResponse();
		dto.setCodigoSeguimiento(seguimiento.getIdSeguimiento());
		dto.setDetalleSeguimiento(seguimiento.getDescripcion());
		dto.setFechaSeguimiento(seguimiento.getFecha());
		return dto;
	}

}
