package com.colegio.toe.dto;

public class UsuarioDTORequest {
	private Integer codigoUser;
	private boolean activo;
	private String login;
	private String contrasenia;
	private String perfil;
	private String nombreCompleto;
	private String nroDocumento;
	private String email;
	private String numeroTelf;
	private String horario;
	public Integer getCodigoUser() {
		return codigoUser;
	}
	public void setCodigoUser(Integer codigoUser) {
		this.codigoUser = codigoUser;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumeroTelf() {
		return numeroTelf;
	}
	public void setNumeroTelf(String numeroTelf) {
		this.numeroTelf = numeroTelf;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
}
