package com.calidadSoftware.gestionDeHorarios.negocio.dto;

public class TipoCursoDTO {
	private Integer id;
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}