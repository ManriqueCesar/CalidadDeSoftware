package com.calidadSoftware.gestionDeHorarios.integracion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HorarioDAO {
	public List<CursoDTO> obtenerListaCurso(@Param("campoBusqueda") String campoBusqueda,@Param("idCampoBusqueda") Integer idCampoBusqueda,@Param("opcionBusqueda") Integer opcionBusqueda);
	public List<EspecialidadDTO> obtenerListaEspecialidad();
	public List<DocenteDTO> obtenerListaDocente(@Param("campoBusqueda") String campoBusqueda,@Param("idCampoBusqueda") Integer idCampoBusqueda,@Param("opcionBusqueda") Integer opcionBusqueda);
	public void insertarCursoAperturado(CursoAperturadoDTO cursoAperturado);
	public void insertarHorario(HorarioDTO horario);
	public void eliminarHorario(@Param("idHorario") Integer idHorario);
	public List<TipoCursoDTO> obtenerListaTipoCurso();
	public Integer obtenerUltimoCursoAperturado();
	public List<AlumnoDTO> obtenerListaAlumnosCursoAperturado(@Param("idCursoAperturado")Integer idCursoAperturado);
	public List<CursoAperturadoDTO> obtenerListaCursoAperturado(@Param("campoBusqueda") String campoBusqueda,@Param("idCampoBusqueda") Integer idCampoBusqueda,@Param("opcionBusqueda") Integer opcionBusqueda,@Param("estado") Integer estado);
	public List<HorarioDTO> obtenerHorarioCursoAperturado(@Param("idCursoAperturado")Integer idCursoAperturado);
	public void actualizarNotaAlumnoCursoAperturado(@Param("notaCurso")Integer notaCurso,@Param("idAlumno")Integer idAlumno,@Param("idCursoAperturado")Integer idCursoAperturado);
	public void modificarDatosCursoAperturado(CursoAperturadoDTO cursoAperturado);	
	public void cambiarEstadoCursoAperturado(@Param("idCursoAperturado")Integer idCursoAperturado,@Param("estadoCursoAperturado")Boolean estadoCursoAperturado);
	public List<CursoAperturadoDTO> obtenerCursoPorTipo(@Param("idTipoCurso") Integer idTipoCurso);
	public void matricularAlumno(@Param("idAlumno")Integer idAlumno, @Param("idCurApe") Integer idCurApe, @Param("idusu")Integer idUsu);
	public void actualizarVacanteCursoAperturado(@Param("idCursoAperturado")Integer idCursoAperturado);
}
