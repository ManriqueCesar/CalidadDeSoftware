package com.calidadSoftware.gestionDeHorarios.service;

import java.util.Date;
import java.util.List;

import pe.edu.unmsm.sistemas.sgmceups.negocio.dto.AlumnoDTO;
import pe.edu.unmsm.sistemas.sgmceups.negocio.dto.CursoAperturadoDTO;
import pe.edu.unmsm.sistemas.sgmceups.negocio.dto.CursoDTO;
import pe.edu.unmsm.sistemas.sgmceups.negocio.dto.DocenteDTO;
import pe.edu.unmsm.sistemas.sgmceups.negocio.dto.EspecialidadDTO;
import pe.edu.unmsm.sistemas.sgmceups.negocio.dto.HorarioDTO;
import pe.edu.unmsm.sistemas.sgmceups.negocio.dto.TipoCursoDTO;

public interface CursoAperturadoService {
	public List<CursoDTO> obtenerListaCurso(String campoBusqueda,Integer idCampoBusqueda,Integer opcionBusqueda);
	public List<EspecialidadDTO> obtenerListaEspecialidad();
	public List<DocenteDTO> obtenerListaDocente(String campoBusqueda,Integer idCampoBusqueda,Integer opcionBusqueda);
	public List<HorarioDTO> agregarHorario(List<HorarioDTO> listaHorario,HorarioDTO horario);
	public List<HorarioDTO> eliminarHorario(List<HorarioDTO> listaHorario, HorarioDTO horario);
	public Boolean validarDatosCursoAperturado(String aula,DocenteDTO docente,Date fecInicio,Date fecTermino, List<HorarioDTO> horario);
	public void aperturarCurso(String aula,DocenteDTO docente,Date fecInicio,Date fecTermino, List<HorarioDTO> horario,CursoDTO curso);
	public List<TipoCursoDTO> obtenerListaTipoCurso();
	public List<AlumnoDTO> obtenerListaAlumnosCursoAperturado(Integer idCursoAperturado);
	public List<CursoAperturadoDTO> obtenerListaCursoAperturado(String campoBusqueda,Integer idCampoBusqueda,Integer opcionBusqueda,Integer estado);
	public List<HorarioDTO> obtenerListaHorario(Integer idCursoAperturado);
	public void modificarCursoAperturado(CursoAperturadoDTO cursoAperturado, List<HorarioDTO> horario);
	public void cambiarEstadoCursoAperturado(Integer idCursoAperturado,Boolean estado);
	public Boolean validarDatosAlumnosCursosAperturado(List<AlumnoDTO> alumnos);
	public void clausurarCursoAperturado(List<AlumnoDTO> alumnos,CursoAperturadoDTO cursoAperturado);
	public List<CursoAperturadoDTO> obtenerCursoPorTipo(Integer inputTipoCurso);
	public void matricularAlumno(Integer idAlumno, Integer idCurApe, Integer idUsu);
}