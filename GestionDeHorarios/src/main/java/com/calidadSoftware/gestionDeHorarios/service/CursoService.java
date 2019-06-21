package com.calidadSoftware.gestionDeHorarios.service;

import java.util.List;

import com.calidadSoftware.gestionDeHorarios.negocio.dto.CursoDTO;
import com.calidadSoftware.gestionDeHorarios.negocio.dto.TipoCursoDTO;

public interface CursoService {
	public void registrar(CursoDTO cur);
	public List<TipoCursoDTO> listarTipo();
	public List<CursoDTO> buscarCursosxNombre(String inputBusqueda );
	public List<CursoDTO> buscarCursosxCateg(Integer tipo);
	public void actualizar(CursoDTO cur);
	public void registrarTipoCurso(TipoCursoDTO tipoCurso);
	public void eliminarTipoCurso(TipoCursoDTO tipoCurso);
	public void modificarTipoCurso(TipoCursoDTO tipoCurso);
}
