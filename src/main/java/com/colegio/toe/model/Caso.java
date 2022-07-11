package com.colegio.toe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="caso")
public class Caso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCaso;
	private String descripcion;
	private String fecha;
	private String tutor;
	private String estado;
	private String prioridad;
	public Integer getIdCaso() {
		return idCaso;
	}
	public void setIdCaso(Integer idCaso) {
		this.idCaso = idCaso;
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
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
}
