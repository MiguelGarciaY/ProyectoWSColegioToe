package com.colegio.toe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.colegio.toe.dto.UsuarioDTOResponse;
import com.colegio.toe.dto.UsuarioDTORequest;
import com.colegio.toe.model.Usuario;
import com.colegio.toe.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	private UsuarioRepository repository;
	@Override
	public void guardar(UsuarioDTORequest UsuarioDTO) {
		Usuario usuario=new Usuario();
		usuario.setEstado(UsuarioDTO.isActivo());
		usuario.setUsuario(UsuarioDTO.getLogin());
		usuario.setClave(UsuarioDTO.getContrasenia());
		usuario.setRol(UsuarioDTO.getPerfil());
		usuario.setNombre(UsuarioDTO.getNombreCompleto());
		usuario.setDni(UsuarioDTO.getNroDocumento());
		usuario.setCorreo(UsuarioDTO.getEmail());
		usuario.setTelefono(UsuarioDTO.getNumeroTelf());
		usuario.setTurno(UsuarioDTO.getHorario());
		repository.save(usuario);			
	}

	@Override
	public void actualizar(UsuarioDTORequest UsuarioDTO) {
		Usuario usuario=new Usuario();
		usuario.setIdUsuario(UsuarioDTO.getCodigoUser());
		usuario.setEstado(UsuarioDTO.isActivo());
		usuario.setUsuario(UsuarioDTO.getLogin());
		usuario.setClave(UsuarioDTO.getContrasenia());
		usuario.setRol(UsuarioDTO.getPerfil());
		usuario.setNombre(UsuarioDTO.getNombreCompleto());
		usuario.setDni(UsuarioDTO.getNroDocumento());
		usuario.setCorreo(UsuarioDTO.getEmail());
		usuario.setTelefono(UsuarioDTO.getNumeroTelf());
		usuario.setTurno(UsuarioDTO.getHorario());
		repository.saveAndFlush(usuario);	
		
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);			
	}

	@Override
	public List<UsuarioDTOResponse> listar() {
		List<UsuarioDTOResponse> listar=new ArrayList<>();
		UsuarioDTOResponse dto=null;
		List<Usuario> b=repository.findAll();
		
		for(Usuario usuario:b) {
			dto=new UsuarioDTOResponse();
			dto.setCodigoUser(usuario.getIdUsuario());
			dto.setActivo(usuario.getEstado());
			dto.setLogin(usuario.getUsuario());
			dto.setContrasenia(usuario.getClave());
			dto.setPerfil(usuario.getRol());
			dto.setNombreCompleto(usuario.getNombre());
			dto.setNroDocumento(usuario.getDni());
			dto.setEmail(usuario.getCorreo());
			dto.setNumeroTelf(usuario.getTelefono());
			dto.setHorario(usuario.getTurno());
			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public UsuarioDTOResponse obtenerById(Integer id) {
		Usuario usuario=repository.findById(id).orElse(null);
		UsuarioDTOResponse dto=null;
		dto=new UsuarioDTOResponse();
		dto.setCodigoUser(usuario.getIdUsuario());
		dto.setActivo(usuario.getEstado());
		dto.setLogin(usuario.getUsuario());
		dto.setContrasenia(usuario.getClave());
		dto.setPerfil(usuario.getRol());
		dto.setNombreCompleto(usuario.getNombre());
		dto.setNroDocumento(usuario.getDni());
		dto.setEmail(usuario.getCorreo());
		dto.setNumeroTelf(usuario.getTelefono());
		dto.setHorario(usuario.getTurno());
		return dto;
	}

}

