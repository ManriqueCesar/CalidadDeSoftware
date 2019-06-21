package pe.edu.unmsm.sistemas.sgmceups.negocio.dto;

import java.util.Date;

public class ConsultaAlumnoDTO {
	private Integer idAlumo;
	private Integer idCurso;
	private String nombreTipoCurso; 
	private String nombreCurso;
	private Integer numHorasCurso;
	private String aula;
	private Integer idDocente;
	private String nombreDocente;
	private String apPaternoDocente;
	private String apMaternoDocente;
	private Date fecInicio;
	private Date fecTermino;	
	private Integer idMatricula;
	private Integer nota;
	private String horario;
	private String observacion;
	private Integer estadoCurso;
	
	public ConsultaAlumnoDTO() {
		
	}
	
	public ConsultaAlumnoDTO(String nombreTipoCurso, String nombreCurso,
			Integer numHorasCurso, String aula, String nombreDocente,
			Date fecInicio, Date fecTermino, Integer nota) {
		super();
		this.nombreTipoCurso = nombreTipoCurso;
		this.nombreCurso = nombreCurso;
		this.numHorasCurso = numHorasCurso;
		this.aula = aula;
		this.nombreDocente = nombreDocente;
		this.fecInicio = fecInicio;
		this.fecTermino = fecTermino;
		
		this.nota = nota;
	}
	
	public Integer getIdAlumo() {
		return idAlumo;
	}
	public void setIdAlumo(Integer idAlumo) {
		this.idAlumo = idAlumo;
	}
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public String getNombreTipoCurso() {
		return nombreTipoCurso;
	}
	public void setNombreTipoCurso(String nombreTipoCurso) {
		this.nombreTipoCurso = nombreTipoCurso;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public Integer getNumHorasCurso() {
		return numHorasCurso;
	}
	public void setNumHorasCurso(Integer numHorasCurso) {
		this.numHorasCurso = numHorasCurso;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	public Integer getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(Integer idDocente) {
		this.idDocente = idDocente;
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
	public Integer getIdMatricula() {
		return idMatricula;
	}
	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Integer getEstadoCurso() {
		return estadoCurso;
	}
	public void setEstadoCurso(Integer estadoCurso) {
		this.estadoCurso = estadoCurso;
	}
}
