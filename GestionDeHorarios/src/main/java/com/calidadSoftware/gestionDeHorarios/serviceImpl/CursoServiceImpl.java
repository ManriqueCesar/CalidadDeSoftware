package com.calidadSoftware.gestionDeHorarios.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CursoServiceImpl implements CursoService{
	@Autowired
	private CursoDAO cursoDAO;
	@Override
	public List<TipoCursoDTO> listarTipo() {
		return cursoDAO.listarTipo();
	}
	@Override
	public void registrar(CursoDTO cur) {
		cursoDAO.registrarCurso(cur);
		Util.mensaje(1,"El curso se registr� satisfactoriamente.");
	}
	
	@Override
	public List<CursoDTO> buscarCursosxNombre(String inputBusqueda) {
		return cursoDAO.buscarCursosxNombre(inputBusqueda);
		
	}
	
	@Override
	public List<CursoDTO> buscarCursosxCateg(Integer tipo) {
		return cursoDAO.buscarCursosxCateg(tipo);
	}
	@Override
	public void actualizar(CursoDTO cur) {
		cursoDAO.actualizarCurso(cur);
		Util.mensaje(1, "El curso ha sido modificado satisfactoriamente.");
	}
	
	public void registrarTipoCurso(TipoCursoDTO tipoCurso){
		cursoDAO.registrarTipoCurso(tipoCurso);
		Util.mensaje(1,"El tipo de curso se registr� satisfactoriamente.");
	}
	
	public void eliminarTipoCurso(TipoCursoDTO tipoCurso){
		try{
			cursoDAO.eliminarTipoCurso(tipoCurso);
			Util.mensaje(1,"El tipo de curso se elimin� satisfactoriamente.");
		}
		catch(Exception e){
			Util.mensaje(3,"No se puede eliminar este Tipo de Curso. Existen cursos con este tipo.");
		}
	}
	
	public void modificarTipoCurso(TipoCursoDTO tipoCurso){
		cursoDAO.modificarTipoCurso(tipoCurso);
		Util.mensaje(1,"El tipo de curso se modific� satisfactoriamente.");
	}
}
