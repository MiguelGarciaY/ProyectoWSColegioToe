package com.colegio.toe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aliado")
public class Aliado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAliado;
	private String descripcion;
	private String correo;
	private String telefono;
	public Integer getIdAliado() {
		return idAliado;
	}
	public void setIdAliado(Integer idAliado) {
		this.idAliado = idAliado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
