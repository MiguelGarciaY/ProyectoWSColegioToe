package com.colegio.toe.dto;

public class GradoDTORequest {
	private Integer codigoGrado;
	private String gradoAlumno;
	private String seccionAlumno;
	private String turnoAlumno;
	public Integer getCodigoGrado() {
		return codigoGrado;
	}
	public void setCodigoGrado(Integer codigoGrado) {
		this.codigoGrado = codigoGrado;
	}
	public String getGradoAlumno() {
		return gradoAlumno;
	}
	public void setGradoAlumno(String gradoAlumno) {
		this.gradoAlumno = gradoAlumno;
	}
	public String getSeccionAlumno() {
		return seccionAlumno;
	}
	public void setSeccionAlumno(String seccionAlumno) {
		this.seccionAlumno = seccionAlumno;
	}
	public String getTurnoAlumno() {
		return turnoAlumno;
	}
	public void setTurnoAlumno(String turnoAlumno) {
		this.turnoAlumno = turnoAlumno;
	}
}
