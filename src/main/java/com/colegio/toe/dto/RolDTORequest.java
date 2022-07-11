package com.colegio.toe.dto;

public class RolDTORequest {
	private Integer codigoRol;
	private String rol;
	private String accesos;
	public Integer getCodigoRol() {
		return codigoRol;
	}
	public void setCodigoRol(Integer codigoRol) {
		this.codigoRol = codigoRol;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getAccesos() {
		return accesos;
	}
	public void setAccesos(String accesos) {
		this.accesos = accesos;
	}
}
