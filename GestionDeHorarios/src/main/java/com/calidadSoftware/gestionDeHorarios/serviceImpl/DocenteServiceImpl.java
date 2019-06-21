package com.calidadSoftware.gestionDeHorarios.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.calidadSoftware.gestionDeHorarios.integracion.dao.DocenteDAO;
import com.calidadSoftware.gestionDeHorarios.negocio.dto.DocenteDTO;

import ch.qos.logback.classic.pattern.Util;


public class DocenteServiceImpl {
	@Resource
	DocenteDAO docenteDAO;
	
	public Boolean validarDatosNuevoDocente(DocenteDTO docente){
		Boolean flag;
		DocenteDTO validarDocenteDni;
		flag=true;
		validarDocenteDni=docenteDAO.validarDniDocenteIngresado(docente.getDni());
		
		if(docente.getNombre().isEmpty()){
			Util.mensaje(3,"Debe ingresar el nombre del docente.");
			flag=false;
		}
		
		if(docente.getApPaterno().isEmpty()){
			Util.mensaje(3,"Debe ingresar el apellido paterno del docente.");
			flag=false;
		}
		
		if(docente.getApMaterno().isEmpty()){
			Util.mensaje(3,"Debe ingresar el apellido materno del docente.");
			flag=false;
		}
		
		if(docente.getDni().isEmpty()){
			Util.mensaje(3,"Debe ingresar el DNI del docente.");
			flag=false;
		}
		
		if(validarDocenteDni!=null){
			Util.mensaje(3,"Ya existe un docente registrado con ese DNI. Ingrese otro DNI por favor.");
			flag=false;
		}
		
		if(docente.getEmail().isEmpty()){
			Util.mensaje(3,"Debe ingresar el correo electrónico del docente.");
			flag=false;
		}
				
		if(docente.getIdEspecialidad().equals(0)){
			Util.mensaje(3,"Debe seleccionar una especialidad para el docente.");
			flag=false;
		}
		
		if(docente.getFecNacimiento()==null){
			Util.mensaje(3,"Debe ingresar la fecha de nacimiento del docente.");
			flag=false;
		}
		
		return flag;
	}
	
	public Boolean validarDatosModificarDocente(DocenteDTO docente){
		Boolean flag;
		DocenteDTO validarDocenteDni;
		flag=true;
		validarDocenteDni=docenteDAO.validarDniDocenteModificado(docente.getId(),docente.getDni());
		
		if(docente.getNombre().isEmpty()){
			Util.mensaje(3,"Debe ingresar el nombre del docente.");
			flag=false;
		}
		
		if(docente.getApPaterno().isEmpty()){
			Util.mensaje(3,"Debe ingresar el apellido paterno del docente.");
			flag=false;
		}
		
		if(docente.getApMaterno().isEmpty()){
			Util.mensaje(3,"Debe ingresar el apellido materno del docente.");
			flag=false;
		}
		
		if(docente.getDni().isEmpty()){
			Util.mensaje(3,"Debe ingresar el DNI del docente.");
			flag=false;
		}
		
		if(validarDocenteDni!=null){
			Util.mensaje(3,"Ya existe un docente registrado con ese DNI. Ingrese otro DNI por favor.");
			flag=false;
		}
		
		if(docente.getEmail().isEmpty()){
			Util.mensaje(3,"Debe ingresar el correo electrónico del docente.");
			flag=false;
		}
				
		if(docente.getIdEspecialidad().equals(0)){
			Util.mensaje(3,"Debe seleccionar una especialidad para el docente.");
			flag=false;
		}
		
		if(docente.getFecNacimiento()==null){
			Util.mensaje(3,"Debe ingresar la fecha de nacimiento del docente.");
			flag=false;
		}
		
		return flag;
	}
	
	public void registrarNuevoDocente(DocenteDTO docente){
		docenteDAO.insertarDocente(docente);
		Util.mensaje(1,"El docente se ha registrado satisfactoriamente.");
	}
	
	public void modificarDocente(DocenteDTO docente){
		docenteDAO.modificarDatosDocente(docente);
		Util.mensaje(1,"El docente se ha modificado satisfactoriamente.");
	}
	
	public List<EspecialidadDTO> obtenerListaEspecialidad(){
		List<EspecialidadDTO> listaEspecialidad;
		listaEspecialidad=docenteDAO.obtenerListaEspecialidad();
		return listaEspecialidad;
	}
	
	public List<DocenteDTO> obtenerListaDocente(String campoBusqueda,Integer idCampoBusqueda,Integer opcionBusqueda){
		List<DocenteDTO> listaDocente=new ArrayList<DocenteDTO>();
		if(campoBusqueda.isEmpty() && (idCampoBusqueda==null ||  idCampoBusqueda.equals(0))){
			Util.mensaje(3, "No se ha ingresado ningún dato al campo de búqueda.");
		}else{
			listaDocente=docenteDAO.obtenerListaDocente(campoBusqueda,idCampoBusqueda,opcionBusqueda);
		}
		return listaDocente;	
	}
	
	public void registrarEspecialidad(EspecialidadDTO especialidad){
		docenteDAO.registrarEspecialidad(especialidad);
		Util.mensaje(1,"La especialidad se registró satisfactoriamente.");
	}
	
	public void modificarEspecialidad(EspecialidadDTO especialidad){
		docenteDAO.modificarEspecialidad(especialidad);
		Util.mensaje(1,"La especialidad se modificó satisfactoriamente.");	
	}
	
	public void eliminarEspecialidad(EspecialidadDTO especialidad){
		try{
			docenteDAO.eliminarEspecialidad(especialidad);
			Util.mensaje(1,"La especialidad se eliminó satisfactoriamente.");
		}
		catch(Exception e){
			Util.mensaje(3,"No se puede eliminar esta especialidad. Existen docentes que tienen asignada esta especialidad.");
		}
	}
}
