package pe.edu.unmsm.sistemas.sgmceups.negocio.dto;

import java.util.Date;

public class CursoAperturadoDTO {
	private Integer id;
	private Date fecInicio;
	private Date fecTermino;
	private Integer vacante;
	private String aula;
	private Boolean estado;
	private Integer idCurso;
	private String nombreCurso;
	private String nivelCurso;
	private Integer numHorasCurso;
	private String vacanteCurso;
	private Integer idTipoCurso;
	private String nombreTipoCurso;
	private Integer idDocente;
	private String nombreDocente;
	private String apPaternoDocente;
	private String apMaternoDocente;
	private String horario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFecInicio() {
		return fecInicio;
	}
	public void setFecInicio(Date fecInicio) {
		this.fecInicio = fecInicio;
	}
	public Date getFecTermino() {
		return fecTermino;
	}
	public void setFecTermino(Date fecTermino) {
		this.fecTermino = fecTermino;
	}
	public Integer getVacante() {
		return vacante;
	}
	public void setVacante(Integer vacante) {
		this.vacante = vacante;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
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
	public Integer getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(Integer idDocente) {
		this.idDocente = idDocente;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	public String getVacanteCurso() {
		return vacanteCurso;
	}
	public void setVacanteCurso(String vacanteCurso) {
		this.vacanteCurso = vacanteCurso;
	}
	public String getNombreDocente() {
		return nombreDocente;
	}
	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}
	public String getApPaternoDocente() {
		return apPaternoDocente;
	}
	public void setApPaternoDocente(String apPaternoDocente) {
		this.apPaternoDocente = apPaternoDocente;
	}
	public String getApMaternoDocente() {
		return apMaternoDocente;
	}
	public void setApMaternoDocente(String apMaternoDocente) {
		this.apMaternoDocente = apMaternoDocente;
	}
	public Integer getNumHorasCurso() {
		return numHorasCurso;
	}
	public void setNumHorasCurso(Integer numHorasCurso) {
		this.numHorasCurso = numHorasCurso;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getNivelCurso() {
		return nivelCurso;
	}
	public void setNivelCurso(String nivelCurso) {
		this.nivelCurso = nivelCurso;
	}
}
