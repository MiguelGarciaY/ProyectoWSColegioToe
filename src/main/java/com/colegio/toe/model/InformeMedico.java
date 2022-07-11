package com.colegio.toe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="informe_medico")
public class InformeMedico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInforme;
	private String fecha;
	private String descripcion;
	public Integer getIdInforme() {
		return idInforme;
	}
	public void setIdInforme(Integer idInforme) {
		this.idInforme = idInforme;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
