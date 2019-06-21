package com.calidadSoftware.gestionDeHorario.controller.mantenimiento;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("view")
public class MantenimientoUsuarioController{
	private UsuarioDTO usuarioIngresado;
	private String confirmacionContrasenia;
	private List<PerfilDTO> listaTodosPerfiles;
	private List<PerfilDTO> listaPerfilesIngresados;
	private Integer idPerfilIngresado;
	private PerfilDTO perfilIngresadoEliminado;
	private Boolean validarUsuario;
	private String campoBusqueda;
	private String campoBusquedaGuardado;
	private Integer opcionBusqueda;
	private Integer opcionBusquedaGuardado;
	private List<UsuarioDTO> listaUsuario;
	private UsuarioDTO usuarioModificado;
	private Boolean validarContrasenia;
	private String contraseniaActual;
	private String nuevaContrasenia;
	private String confirmacionNuevaContrasenia;
	private List<PerfilDTO> listaPerfilesModificados;
	private Integer idPerfilModificado;
	private PerfilDTO perfilModificadoEliminado;
	private Boolean validarModificarUsuario;
	
	
	@Autowired
	UserManagerService userManagerService;
	
	@PostConstruct
	public void init(){
		usuarioIngresado=new UsuarioDTO();
		usuarioModificado=new UsuarioDTO();
		listaPerfilesIngresados= new ArrayList<PerfilDTO>();
		listaPerfilesModificados= new ArrayList<PerfilDTO>();
		setListaTodosPerfiles(userManagerService.obtenerTodosPerfiles());
		setValidarUsuario(false);
		setValidarContrasenia(false);
		setOpcionBusqueda(1);
	}
	public void validarDatosUsuario(){
		setValidarUsuario(userManagerService.validarDatosNuevoUsuario(getUsuarioIngresado(),getConfirmacionContrasenia(),getListaPerfilesIngresados()));
	}
	
	public void agregarPerfilIngresado(){
		setListaPerfilesIngresados(userManagerService.agregarPerfil(getListaPerfilesIngresados(),getIdPerfilIngresado()));
	}
	
	public void eliminarPerfilIngresado(){
		setListaPerfilesIngresados(userManagerService.eliminarPerfil(getListaPerfilesIngresados(),getPerfilIngresadoEliminado().getId()));
	}
	
	public void registrar(){
		userManagerService.registrarNuevoUsuario(getUsuarioIngresado(),getListaPerfilesIngresados(),getValidarUsuario());
		init();
	}
	
	public void buscar(){
		setListaUsuario(userManagerService.obtenerListaUsuario(getCampoBusqueda(),getOpcionBusqueda()));
		setCampoBusquedaGuardado(getCampoBusqueda());
		setOpcionBusquedaGuardado(getOpcionBusqueda());
	}
	
	public void cambiarEstado(){
		userManagerService.cambiarEstadoUsuario(getUsuarioModificado().getId(),getUsuarioModificado().getEstado());
		setListaUsuario(userManagerService.obtenerListaUsuario(getCampoBusquedaGuardado(),getOpcionBusquedaGuardado()));
	}
	
	public void validarContraseniaUsuario(){
		setValidarContrasenia(userManagerService.validarCambioContrasenia(usuarioModificado.getId(), getContraseniaActual(), getNuevaContrasenia(), getConfirmacionNuevaContrasenia()));
	}
	
	public void cambiarContrasenia(){
		userManagerService.cambiarContraseniaUsuario(usuarioModificado.getId(),getNuevaContrasenia());
	}
	
	public void limpiarCampoBusqueda(){
		setCampoBusqueda("");
	}
	
	public void validarDatosModificarUsuario(){
		setValidarModificarUsuario(userManagerService.validarDatosModificarUsuario(getUsuarioModificado()));
	}
	
	public void modificar(){
		userManagerService.modificarUsuario(getUsuarioModificado(),getListaPerfilesModificados());
		setListaUsuario(userManagerService.obtenerListaUsuario(getCampoBusquedaGuardado(),getOpcionBusquedaGuardado()));
	}
	
	public void obtenerPerfiles(){
		setListaPerfilesModificados(userManagerService.obtenerPerfilesUsuario(usuarioModificado.getId()));
	}
	
	public void agregarPerfilModificado(){
		setListaPerfilesModificados(userManagerService.agregarPerfil(getListaPerfilesModificados(),getIdPerfilModificado()));
	}
	
	public void eliminarPerfilModificado(){
		setListaPerfilesModificados(userManagerService.eliminarPerfil(getListaPerfilesModificados(),getPerfilModificadoEliminado().getId()));
	}
	
	public UsuarioDTO getUsuarioIngresado() {
		return usuarioIngresado;
	}
	public void setUsuarioIngresado(UsuarioDTO usuarioIngresado) {
		this.usuarioIngresado = usuarioIngresado;
	}
	public String getConfirmacionContrasenia() {
		return confirmacionContrasenia;
	}
	public void setConfirmacionContrasenia(String confirmacionContrasenia) {
		this.confirmacionContrasenia = confirmacionContrasenia;
	}
	public List<PerfilDTO> getListaTodosPerfiles() {
		return listaTodosPerfiles;
	}
	public void setListaTodosPerfiles(List<PerfilDTO> listaTodosPerfiles) {
		this.listaTodosPerfiles = listaTodosPerfiles;
	}
	public List<PerfilDTO> getListaPerfilesIngresados() {
		return listaPerfilesIngresados;
	}
	public void setListaPerfilesIngresados(List<PerfilDTO> listaPerfilesIngresados) {
		this.listaPerfilesIngresados = listaPerfilesIngresados;
	}
	public Integer getIdPerfilIngresado() {
		return idPerfilIngresado;
	}
	public void setIdPerfilIngresado(Integer idPerfilIngresado) {
		this.idPerfilIngresado = idPerfilIngresado;
	}
	public PerfilDTO getPerfilIngresadoEliminado() {
		return perfilIngresadoEliminado;
	}
	public void setPerfilIngresadoEliminado(PerfilDTO perfilIngresadoEliminado) {
		this.perfilIngresadoEliminado = perfilIngresadoEliminado;
	}
	public Boolean getValidarUsuario() {
		return validarUsuario;
	}
	public void setValidarUsuario(Boolean validarUsuario) {
		this.validarUsuario = validarUsuario;
	}
	public String getCampoBusqueda() {
		return campoBusqueda;
	}
	public void setCampoBusqueda(String campoBusqueda) {
		this.campoBusqueda = campoBusqueda;
	}
	public Integer getOpcionBusqueda() {
		return opcionBusqueda;
	}
	public void setOpcionBusqueda(Integer opcionBusqueda) {
		this.opcionBusqueda = opcionBusqueda;
	}
	public List<UsuarioDTO> getListaUsuario() {
		return listaUsuario;
	}
	public void setListaUsuario(List<UsuarioDTO> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	public UsuarioDTO getUsuarioModificado() {
		return usuarioModificado;
	}
	public void setUsuarioModificado(UsuarioDTO usuarioModificado) {
		this.usuarioModificado = usuarioModificado;
	}
	public String getCampoBusquedaGuardado() {
		return campoBusquedaGuardado;
	}
	public void setCampoBusquedaGuardado(String campoBusquedaGuardado) {
		this.campoBusquedaGuardado = campoBusquedaGuardado;
	}
	public Integer getOpcionBusquedaGuardado() {
		return opcionBusquedaGuardado;
	}
	public void setOpcionBusquedaGuardado(Integer opcionBusquedaGuardado) {
		this.opcionBusquedaGuardado = opcionBusquedaGuardado;
	}
	public String getContraseniaActual() {
		return contraseniaActual;
	}
	public void setContraseniaActual(String contraseniaActual) {
		this.contraseniaActual = contraseniaActual;
	}
	public String getNuevaContrasenia() {
		return nuevaContrasenia;
	}
	public void setNuevaContrasenia(String nuevaContrasenia) {
		this.nuevaContrasenia = nuevaContrasenia;
	}
	public String getConfirmacionNuevaContrasenia() {
		return confirmacionNuevaContrasenia;
	}
	public void setConfirmacionNuevaContrasenia(String confirmacionNuevaContrasenia) {
		this.confirmacionNuevaContrasenia = confirmacionNuevaContrasenia;
	}
	public Boolean getValidarContrasenia() {
		return validarContrasenia;
	}
	public void setValidarContrasenia(Boolean validarContrasenia) {
		this.validarContrasenia = validarContrasenia;
	}
	public List<PerfilDTO> getListaPerfilesModificados() {
		return listaPerfilesModificados;
	}
	public void setListaPerfilesModificados(List<PerfilDTO> listaPerfilesModificados) {
		this.listaPerfilesModificados = listaPerfilesModificados;
	}
	public Integer getIdPerfilModificado() {
		return idPerfilModificado;
	}
	public void setIdPerfilModificado(Integer idPerfilModificado) {
		this.idPerfilModificado = idPerfilModificado;
	}
	public PerfilDTO getPerfilModificadoEliminado() {
		return perfilModificadoEliminado;
	}
	public void setPerfilModificadoEliminado(PerfilDTO perfilModificadoEliminado) {
		this.perfilModificadoEliminado = perfilModificadoEliminado;
	}
	public Boolean getValidarModificarUsuario() {
		return validarModificarUsuario;
	}
	public void setValidarModificarUsuario(Boolean validarModificarUsuario) {
		this.validarModificarUsuario = validarModificarUsuario;
	}
}