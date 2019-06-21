package com.calidadSoftware.gestionDeHorarios.negocio.dto;

public class CursoDTO {
	private Integer id;
	private String nombre;
	private String nivel;
	private Integer vacante;
	private Integer numHoras;
	private Integer estado;
	private Integer idTipoCurso;
	private String nombreTipoCurso;
		
	public CursoDTO(){	
	}
	
	public CursoDTO(String nombre, String nivel,Integer vacante, Integer numHoras,
			Integer estado, Integer idTipoCurso) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.vacante = vacante;
		this.numHoras = numHoras;
		this.estado = estado;
		this.idTipoCurso = idTipoCurso;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getVacante() {
		return vacante;
	}
	public void setVacante(Integer vacante) {
		this.vacante = vacante;
	}
	public Integer getNumHoras() {
		return numHoras;
	}
	public void setNumHoras(Integer numHoras) {
		this.numHoras = numHoras;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Integer getIdTipoCurso() {
		return idTipoCurso;
	}
	public void setIdTipoCurso(Integer idTipoCurso) {
		this.idTipoCurso = idTipoCurso;
	}
	public String getNombreTipoCurso() {
		return nombreTipoCurso;
	}
	public void setNombreTipoCurso(String nombreTipoCurso) {
		this.nombreTipoCurso = nombreTipoCurso;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
}
