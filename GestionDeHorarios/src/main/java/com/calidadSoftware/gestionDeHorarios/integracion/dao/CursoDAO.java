package com.calidadSoftware.gestionDeHorarios.integracion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CursoDAO {
	public List<TipoCursoDTO> listarTipo();
	public void registrarCurso(CursoDTO cur);
	public List<CursoDTO> buscarCursosxNombre(@Param("inputBusq")String inputBusq);
	public List<CursoDTO> buscarCursosxCateg(@Param("inputCateg")Integer inputCateg);
	public void actualizarCurso(CursoDTO cur);
	public void registrarTipoCurso(TipoCursoDTO tipoCurso);
	public void eliminarTipoCurso(TipoCursoDTO tipoCurso);
	public void modificarTipoCurso(TipoCursoDTO tipoCurso);
}
