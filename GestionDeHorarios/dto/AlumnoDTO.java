package pe.edu.unmsm.sistemas.sgmceups.negocio.dto;

import java.util.Date;

public class AlumnoDTO {
	private Integer id;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String dni;
	private Date fecNacimiento;
	private String telefono;
	private String direccion;
	private String email;
	private Integer notaCurso;
	
	public AlumnoDTO(){
		
	}
	
	public AlumnoDTO(String nombre, String apPaterno,
			String apMaterno, String dni, Date fecNacimiento, String telefono,
			String direccion, String email) {
		super();
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.dni = dni;
		this.fecNacimiento = fecNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getNotaCurso() {
		return notaCurso;
	}
	public void setNotaCurso(Integer notaCurso) {
		this.notaCurso = notaCurso;
	}
}
