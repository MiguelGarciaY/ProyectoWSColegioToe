package com.colegio.toe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seguimiento")
public class Seguimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSeguimiento;
	private String descripcion;
	private String fecha;
	public Integer getIdSeguimiento() {
		return idSeguimiento;
	}
	public void setIdSeguimiento(Integer idSeguimiento) {
		this.idSeguimiento = idSeguimiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
