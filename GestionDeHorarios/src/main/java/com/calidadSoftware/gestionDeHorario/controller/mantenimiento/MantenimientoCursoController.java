package com.calidadSoftware.gestionDeHorario.controller.mantenimiento;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller
@Scope("view")
public class MantenimientoCursoController {

	private String nombre;
	private String nivel;
	private Integer vacante;
	private Integer tipo;
	private Integer numHoras;

	private CursoDTO curdto;
	private List<CursoDTO> listaCursos;
	private String inputBusqueda;
	private Integer radioBusqueda;
	private Integer tipoSeleccionadoS;
	private CursoDTO cursoSeleccionado;

	private Integer tipoCursoS;
	private String nombreCursoS;
	private Integer inputTipoCursoS;
	private Integer tipoSeleccionado;
	
	private TipoCursoDTO tipoCursoIngresado;
	private TipoCursoDTO tipoCursoSeleccionado;

	private List<TipoCursoDTO> listaTipoCurso;
	private List<TipoCursoDTO> filtroListaTipoCurso;
	@Resource
	CursoService cursoService;

	public MantenimientoCursoController(){

	}

	@PostConstruct
	public void init(){
		setTipoCursoIngresado(new TipoCursoDTO());
		setCursoSeleccionado(new CursoDTO());
		setRadioBusqueda(0);
		llenarTipoCurso();
	}

	public void buscarCurso(){
		if(radioBusqueda==0){
			setListaCursos(cursoService.buscarCursosxCateg(tipoSeleccionadoS));
		}
		if(radioBusqueda==1){
			if(!nombreCursoS.equals(""))
				setListaCursos(cursoService.buscarCursosxNombre(nombreCursoS));
		}
	}

	public void cambiarBusqueda(){
		nombreCursoS="";
		tipoSeleccionado=null;
	}

	public void editarCurso(){
		cursoService.actualizar(cursoSeleccionado);
	}

	public void llenarTipoCurso(){
		setListaTipoCurso(cursoService.listarTipo());
		setFiltroListaTipoCurso(cursoService.listarTipo());
	}
	
	public void guardarCurso(){
		setCurdto(new CursoDTO(nombre,nivel,vacante,numHoras,1,tipoSeleccionado));
		cursoService.registrar(curdto);
		limpiarRegistrarCurso();
	}
	
	public void limpiarRegistrarCurso(){
		setNombre(null);
		setVacante(null);
		setTipo(null);
		setNumHoras(null);
	}
	
	public void registrarTipoCurso(){
		if(!getTipoCursoIngresado().getNombre().equals(""))
			cursoService.registrarTipoCurso(getTipoCursoIngresado());
		setTipoCursoIngresado(new TipoCursoDTO());
		llenarTipoCurso();
	}
	
	public void eliminarTipoCurso(){
		cursoService.eliminarTipoCurso(tipoCursoSeleccionado);
		llenarTipoCurso();
	}
	
	public void modificarTipoCurso(){
		cursoService.modificarTipoCurso(tipoCursoSeleccionado);
		llenarTipoCurso();
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getVacante() {
		return vacante;
	}

	public void setVacante(Integer vacante) {
		this.vacante = vacante;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getNumHoras() {
		return numHoras;
	}

	public void setNumHoras(Integer numHoras) {
		this.numHoras = numHoras;
	}

	public CursoDTO getCurdto() {
		return curdto;
	}

	public void setCurdto(CursoDTO curdto) {
		this.curdto = curdto;
	}

	public List<CursoDTO> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<CursoDTO> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public String getInputBusqueda() {
		return inputBusqueda;
	}

	public void setInputBusqueda(String inputBusqueda) {
		this.inputBusqueda = inputBusqueda;
	}

	public Integer getRadioBusqueda() {
		return radioBusqueda;
	}

	public void setRadioBusqueda(Integer radioBusqueda) {
		this.radioBusqueda = radioBusqueda;
	}

	public Integer getTipoSeleccionadoS() {
		return tipoSeleccionadoS;
	}

	public void setTipoSeleccionadoS(Integer tipoSeleccionadoS) {
		this.tipoSeleccionadoS = tipoSeleccionadoS;
	}

	public CursoDTO getCursoSeleccionado() {
		return cursoSeleccionado;
	}

	public void setCursoSeleccionado(CursoDTO cursoSeleccionado) {
		this.cursoSeleccionado = cursoSeleccionado;
	}

	public Integer getTipoCursoS() {
		return tipoCursoS;
	}

	public void setTipoCursoS(Integer tipoCursoS) {
		this.tipoCursoS = tipoCursoS;
	}

	public String getNombreCursoS() {
		return nombreCursoS;
	}

	public void setNombreCursoS(String nombreCursoS) {
		this.nombreCursoS = nombreCursoS;
	}

	public Integer getInputTipoCursoS() {
		return inputTipoCursoS;
	}

	public void setInputTipoCursoS(Integer inputTipoCursoS) {
		this.inputTipoCursoS = inputTipoCursoS;
	}

	public Integer getTipoSeleccionado() {
		return tipoSeleccionado;
	}

	public void setTipoSeleccionado(Integer tipoSeleccionado) {
		this.tipoSeleccionado = tipoSeleccionado;
	}

	public List<TipoCursoDTO> getFiltroListaTipoCurso() {
		return filtroListaTipoCurso;
	}

	public void setFiltroListaTipoCurso(List<TipoCursoDTO> filtroListaTipoCurso) {
		this.filtroListaTipoCurso = filtroListaTipoCurso;
	}

	public List<TipoCursoDTO> getListaTipoCurso() {
		return listaTipoCurso;
	}

	public void setListaTipoCurso(List<TipoCursoDTO> listaTipoCurso) {
		this.listaTipoCurso = listaTipoCurso;
	}

	public TipoCursoDTO getTipoCursoIngresado() {
		return tipoCursoIngresado;
	}

	public void setTipoCursoIngresado(TipoCursoDTO tipoCursoIngresado) {
		this.tipoCursoIngresado = tipoCursoIngresado;
	}

	public TipoCursoDTO getTipoCursoSeleccionado() {
		return tipoCursoSeleccionado;
	}

	public void setTipoCursoSeleccionado(TipoCursoDTO tipoCursoSeleccionado) {
		this.tipoCursoSeleccionado = tipoCursoSeleccionado;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
}
