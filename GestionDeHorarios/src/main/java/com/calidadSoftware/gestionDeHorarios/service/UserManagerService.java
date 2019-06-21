package com.calidadSoftware.gestionDeHorarios.service;

import java.util.List;

import com.calidadSoftware.gestionDeHorarios.negocio.dto.UsuarioDTO;
import pe.edu.unmsm.sistemas.sgmceups.negocio.dto.PerfilDTO;


public interface UserManagerService {
	
	public UsuarioDTO getUsuarioIniciado(String usuario);
	public String getDireccionMenu();
	public List<PerfilDTO> obtenerTodosPerfiles();
	public List<PerfilDTO> agregarPerfil(List<PerfilDTO> listaPerfil,Integer idPerfil);
	public List<PerfilDTO> eliminarPerfil(List<PerfilDTO> listaPerfil,Integer idPerfil);
	public Boolean validarDatosNuevoUsuario(UsuarioDTO usuario,String confirmContrasenia, List<PerfilDTO> perfiles);
	public void registrarNuevoUsuario(UsuarioDTO usuario,List<PerfilDTO> perfiles,Boolean validacion);
	public  List<UsuarioDTO> obtenerListaUsuario(String campoBusqueda,Integer opcionBusqueda);
	public void cambiarEstadoUsuario(Integer id,Boolean estado);
	public Boolean validarCambioContrasenia(Integer id,String contraseniaActual,String nuevaContrasenia,String confirmacionNuevaContrasenia);
	public void cambiarContraseniaUsuario(Integer id,String contrasenia);
	public List<PerfilDTO> obtenerPerfilesUsuario(Integer id);
	public Boolean validarDatosModificarUsuario(UsuarioDTO usuario);
	public void modificarUsuario(UsuarioDTO usuario,List<PerfilDTO> perfiles);
}
