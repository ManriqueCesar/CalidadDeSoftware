package com.calidadSoftware.gestionDeHorarios.controller.mantenimiento;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller
@Scope("view")
public class MantenimientoDocenteController {
	private DocenteDTO docenteIngresado;
	private DocenteDTO docenteModificado;
	private Boolean validarDocente;
	private Boolean validarModificarDocente;
	private List<EspecialidadDTO> listaEspecialidad;
	private List<EspecialidadDTO> filtroListaEspecialidad;
	private Integer opcionBusquedaDocente;
	private String campoBusquedaDocente;
	private Integer idCampoBusquedaDocente;
	private Integer opcionBusquedaDocenteGuardado;
	private String campoBusquedaDocenteGuardado;
	private Integer idCampoBusquedaDocenteGuardado;
	private List<DocenteDTO> listaDocente;
	private EspecialidadDTO especialidadIngresada;
	private EspecialidadDTO especialidadSeleccionada;
	
	
	@Autowired
	DocenteService docenteService;

	@PostConstruct
	public void init(){
		docenteIngresado=new DocenteDTO();
		docenteModificado=new DocenteDTO();
		especialidadIngresada=new EspecialidadDTO();
		especialidadSeleccionada=new EspecialidadDTO();
		setOpcionBusquedaDocente(1);
		setListaEspecialidad(docenteService.obtenerListaEspecialidad());
		setValidarDocente(false);
		setValidarModificarDocente(false);
		
	}
	
	public void validarDatosDocente(){
		setValidarDocente(docenteService.validarDatosNuevoDocente(getDocenteIngresado()));
	}
	
	public void validarDatosModificarDocente(){
		setValidarModificarDocente(docenteService.validarDatosModificarDocente(getDocenteModificado()));
	}
	
	public void limpiarCampoBusquedaDocente(){
		setCampoBusquedaDocente("");
		setIdCampoBusquedaDocente(0);
	}
	
	public void modificar(){
		docenteService.modificarDocente(getDocenteModificado());
		setListaDocente(docenteService.obtenerListaDocente(getCampoBusquedaDocenteGuardado(),getIdCampoBusquedaDocenteGuardado(),getOpcionBusquedaDocenteGuardado()));
	}
	
	public void registrar(){
		docenteService.registrarNuevoDocente(getDocenteIngresado());
		init();
	}
	
	public void buscarDocente(){
		setListaDocente(docenteService.obtenerListaDocente(getCampoBusquedaDocente(),getIdCampoBusquedaDocente(),getOpcionBusquedaDocente()));	
		setCampoBusquedaDocenteGuardado(getCampoBusquedaDocente());
		setIdCampoBusquedaDocenteGuardado(getIdCampoBusquedaDocente());
		setOpcionBusquedaDocenteGuardado(getOpcionBusquedaDocente());
	
	}
	
	public void llenarEspecialidado(){
		setListaEspecialidad(docenteService.obtenerListaEspecialidad());
		setFiltroListaEspecialidad(docenteService.obtenerListaEspecialidad());
	}
	
	public void registrarEspecialidad(){
		if(!getEspecialidadIngresada().getNombre().equals(""))
			docenteService.registrarEspecialidad(getEspecialidadIngresada());
		setEspecialidadIngresada(new EspecialidadDTO());
		llenarEspecialidado();
	}
	
	public void eliminarEspecialidad(){
		docenteService.eliminarEspecialidad(especialidadSeleccionada);
		llenarEspecialidado();
	}
	
	public void modificarEspecialidad(){
		docenteService.modificarEspecialidad(especialidadSeleccionada);
		llenarEspecialidado();
	}

	public DocenteDTO getDocenteIngresado() {
		return docenteIngresado;
	}

	public void setDocenteIngresado(DocenteDTO docenteIngresado) {
		this.docenteIngresado = docenteIngresado;
	}

	public Boolean getValidarDocente() {
		return validarDocente;
	}

	public void setValidarDocente(Boolean validarDocente) {
		this.validarDocente = validarDocente;
	}

	public List<EspecialidadDTO> getListaEspecialidad() {
		return listaEspecialidad;
	}

	public void setListaEspecialidad(List<EspecialidadDTO> listaEspecialidad) {
		this.listaEspecialidad = listaEspecialidad;
	}

	public Integer getOpcionBusquedaDocente() {
		return opcionBusquedaDocente;
	}

	public void setOpcionBusquedaDocente(Integer opcionBusquedaDocente) {
		this.opcionBusquedaDocente = opcionBusquedaDocente;
	}

	public String getCampoBusquedaDocente() {
		return campoBusquedaDocente;
	}

	public void setCampoBusquedaDocente(String campoBusquedaDocente) {
		this.campoBusquedaDocente = campoBusquedaDocente;
	}

	public Integer getIdCampoBusquedaDocente() {
		return idCampoBusquedaDocente;
	}

	public void setIdCampoBusquedaDocente(Integer idCampoBusquedaDocente) {
		this.idCampoBusquedaDocente = idCampoBusquedaDocente;
	}

	public List<DocenteDTO> getListaDocente() {
		return listaDocente;
	}

	public void setListaDocente(List<DocenteDTO> listaDocente) {
		this.listaDocente = listaDocente;
	}

	public DocenteDTO getDocenteModificado() {
		return docenteModificado;
	}

	public void setDocenteModificado(DocenteDTO docenteModificado) {
		this.docenteModificado = docenteModificado;
	}

	public Boolean getValidarModificarDocente() {
		return validarModificarDocente;
	}

	public void setValidarModificarDocente(Boolean validarModificarDocente) {
		this.validarModificarDocente = validarModificarDocente;
	}

	public Integer getOpcionBusquedaDocenteGuardado() {
		return opcionBusquedaDocenteGuardado;
	}

	public void setOpcionBusquedaDocenteGuardado(
			Integer opcionBusquedaDocenteGuardado) {
		this.opcionBusquedaDocenteGuardado = opcionBusquedaDocenteGuardado;
	}

	public String getCampoBusquedaDocenteGuardado() {
		return campoBusquedaDocenteGuardado;
	}

	public void setCampoBusquedaDocenteGuardado(String campoBusquedaDocenteGuardado) {
		this.campoBusquedaDocenteGuardado = campoBusquedaDocenteGuardado;
	}

	public Integer getIdCampoBusquedaDocenteGuardado() {
		return idCampoBusquedaDocenteGuardado;
	}

	public void setIdCampoBusquedaDocenteGuardado(
			Integer idCampoBusquedaDocenteGuardado) {
		this.idCampoBusquedaDocenteGuardado = idCampoBusquedaDocenteGuardado;
	}

	public EspecialidadDTO getEspecialidadIngresada() {
		return especialidadIngresada;
	}

	public void setEspecialidadIngresada(EspecialidadDTO especialidadIngresada) {
		this.especialidadIngresada = especialidadIngresada;
	}

	public EspecialidadDTO getEspecialidadSeleccionada() {
		return especialidadSeleccionada;
	}

	public void setEspecialidadSeleccionada(EspecialidadDTO especialidadSeleccionada) {
		this.especialidadSeleccionada = especialidadSeleccionada;
	}

	public List<EspecialidadDTO> getFiltroListaEspecialidad() {
		return filtroListaEspecialidad;
	}

	public void setFiltroListaEspecialidad(
			List<EspecialidadDTO> filtroListaEspecialidad) {
		this.filtroListaEspecialidad = filtroListaEspecialidad;
	}
}
