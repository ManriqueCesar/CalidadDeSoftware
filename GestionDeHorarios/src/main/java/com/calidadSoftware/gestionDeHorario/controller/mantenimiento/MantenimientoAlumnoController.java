package com.calidadSoftware.gestionDeHorario.controller.mantenimiento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("view")
public class MantenimientoAlumnoController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String dni;
	private Date fecNacimiento;
	private String telefono;
	private String direccion;
	private String email;	
	
	/*Atributos para la Busqueda*/
	private String radioBusqueda;
	private String inputBusqueda;
	private String dniS;
	private String nombreS;
	private String apPaternoS;
	private String apMaternoS;
	
	private AlumnoDTO alumno;
	private AlumnoDTO alumnoSeleccion;
	private List<AlumnoDTO> listaAlumnos;
	
	private String message;
	
	@Resource
	AlumnoService alumnoService;
	
	public MantenimientoAlumnoController(){
		listaAlumnos = new ArrayList<AlumnoDTO>();
		
	}
	@PostConstruct
	public void init(){
		nombre="";
		apPaterno="";
		apMaterno="";
		dni="";
		fecNacimiento=null;
		telefono="";
		direccion="";
		email="";	
		setRadioBusqueda("0");
	}
	
	
	public void registrarAlumno(){
		setAlumno(new AlumnoDTO(nombre,apPaterno,apMaterno,dni,fecNacimiento,telefono, direccion,email));

		if(!camposVacios()){
			alumnoService.registrarAlumno(alumno);
			Util.mensaje(1,"Alumno registrado");
			init();
			
			
			
		}else{
			Util.mensaje(3,"No se pudo registrar al alumno");
		}
	}
	
	
	public void cancelarCambios(){
		setAlumnoSeleccion(alumnoService.obtenerAlumnoxID(alumnoSeleccion.getId()));
		System.out.println("SE HIZO EL CAMBIO");
	}
	public void editarAlumno(){
		alumnoService.actualizarAlumno(alumnoSeleccion);
	}
	
	public void buscarAlumno(){
		inputBusqueda="";
		
		if(radioBusqueda.equals("0"))
			inputBusqueda=dniS;			
		
		if(radioBusqueda.equals("1"))
			inputBusqueda=nombreS;		
		
		if(radioBusqueda.equals("2"))
			inputBusqueda=apPaternoS;		
			
		if(radioBusqueda.equals("3"))
			inputBusqueda=apMaternoS;		
		
		System.out.println(radioBusqueda+" :"+inputBusqueda);
		setListaAlumnos(alumnoService.obtenerAlumno(radioBusqueda, inputBusqueda));
		Util.mensaje(1, "Lista cargada con �xito");
	
	}
	
	public void cambiarBusqueda(){
		dniS="";
		nombreS="";
		apPaternoS="";
		apMaternoS="";
	}
	public boolean camposVacios(){
		boolean error = false;		
		if(nombre.equals("") && apPaterno.equals("") && apMaterno.equals("") && dni.equals("") && fecNacimiento==null && telefono.equals("") && direccion.equals("") && email.equals(""))
			error=true;		
		return error; 
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApPaterno() {
		return apPaterno;
	}
	
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	
	public String getApMaterno() {
		return apMaterno;
	}
	
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public Date getFecNacimiento() {
		return fecNacimiento;
	}
	
	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRadioBusqueda() {
		return radioBusqueda;
	}
	
	public void setRadioBusqueda(String radioBusqueda) {
		this.radioBusqueda = radioBusqueda;
	}
	
	public String getInputBusqueda() {
		return inputBusqueda;
	}
	
	public void setInputBusqueda(String inputBusqueda) {
		this.inputBusqueda = inputBusqueda;
	}
	
	public String getDniS() {
		return dniS;
	}
	
	public void setDniS(String dniS) {
		this.dniS = dniS;
	}
	
	public String getNombreS() {
		return nombreS;
	}
	
	public void setNombreS(String nombreS) {
		this.nombreS = nombreS;
	}
	
	public String getApPaternoS() {
		return apPaternoS;
	}
	
	public void setAppS(String apPaternoS) {
		this.apPaternoS = apPaternoS;
	}
	
	public String getApMaternoS() {
		return apMaternoS;
	}
	
	public void setApMaternoS(String apMaternoS) {
		this.apMaternoS = apMaternoS;
	}
	
	public AlumnoDTO getAlumno() {
		return alumno;
	}
	
	public void setAlumno(AlumnoDTO alumno) {
		this.alumno = alumno;
	}
	
	public AlumnoDTO getAlumnoSeleccion() {
		return alumnoSeleccion;
	}
	
	public void setAlumnoSeleccion(AlumnoDTO alumnoSeleccion) {
		this.alumnoSeleccion = alumnoSeleccion;
	}
	
	public List<AlumnoDTO> getListaAlumnos() {
		return listaAlumnos;
	}
	
	public void setListaAlumnos(List<AlumnoDTO> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
