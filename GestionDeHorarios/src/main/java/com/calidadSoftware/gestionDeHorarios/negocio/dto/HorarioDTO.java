package com.calidadSoftware.gestionDeHorarios.negocio.dto;

import java.util.Date;

public class HorarioDTO {
	
	private Integer id;
	private Date horInicio;
	private Date horTermino;
	private Integer dia;
	private String nombreDia;
	private Integer idCurso;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getHorInicio() {
		return horInicio;
	}
	public void setHorInicio(Date horInicio) {
		this.horInicio = horInicio;
	}
	public Date getHorTermino() {
		return horTermino;
	}
	public void setHorTermino(Date horTermino) {
		this.horTermino = horTermino;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public String getNombreDia() {
		return nombreDia;
	}
	public void setNombreDia(String nombreDia) {
		this.nombreDia = nombreDia;
	}
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
}
