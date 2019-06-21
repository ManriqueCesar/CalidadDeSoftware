package com.calidadSoftware.gestionDeHorarios.service;

import java.util.List;

import com.calidadSoftware.gestionDeHorarios.negocio.dto.DocenteDTO;
import com.calidadSoftware.gestionDeHorarios.negocio.dto.EspecialidadDTO;



public interface DocenteService {
	public Boolean validarDatosNuevoDocente(DocenteDTO docente);
	public void registrarNuevoDocente(DocenteDTO docente);
	public Boolean validarDatosModificarDocente(DocenteDTO docente);
	public void modificarDocente(DocenteDTO docente);
	public List<EspecialidadDTO> obtenerListaEspecialidad();
	public List<DocenteDTO> obtenerListaDocente(String campoBusqueda,Integer idCampoBusqueda,Integer opcionBusqueda);
	public void registrarEspecialidad(EspecialidadDTO especialidad);
	public void modificarEspecialidad(EspecialidadDTO especialidad);
	public void eliminarEspecialidad(EspecialidadDTO especialidad);
}
