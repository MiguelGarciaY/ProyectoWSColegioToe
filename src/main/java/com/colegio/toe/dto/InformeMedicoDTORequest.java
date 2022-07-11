package com.colegio.toe.dto;

public class InformeMedicoDTORequest {
	private Integer codigoInforme;
	private String fechaInforme;
	private String detalleInforme;
	public Integer getCodigoInforme() {
		return codigoInforme;
	}
	public void setCodigoInforme(Integer codigoInforme) {
		this.codigoInforme = codigoInforme;
	}
	public String getFechaInforme() {
		return fechaInforme;
	}
	public void setFechaInforme(String fechaInforme) {
		this.fechaInforme = fechaInforme;
	}
	public String getDetalleInforme() {
		return detalleInforme;
	}
	public void setDetalleInforme(String detalleInforme) {
		this.detalleInforme = detalleInforme;
	}
}
