package com.calidadSoftware.gestionDeHorarios.integracion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DocenteDAO {
	public DocenteDTO validarDniDocenteIngresado(@Param("dniDocente") String dniDocente);
	public void insertarDocente(DocenteDTO docente);
	public DocenteDTO validarDniDocenteModificado(@Param("idDocente") Integer idDocente,@Param("dniDocente") String dniDocente);
	public void modificarDatosDocente(DocenteDTO docente);
	public List<EspecialidadDTO> obtenerListaEspecialidad();
	public List<DocenteDTO> obtenerListaDocente(@Param("campoBusqueda") String campoBusqueda,@Param("idCampoBusqueda") Integer idCampoBusqueda,@Param("opcionBusqueda") Integer opcionBusqueda);
	public void registrarEspecialidad(EspecialidadDTO especialidad);
	public void eliminarEspecialidad(EspecialidadDTO especialidadSeleccionada);
	public void modificarEspecialidad(EspecialidadDTO especialidadSeleccionada);
}
