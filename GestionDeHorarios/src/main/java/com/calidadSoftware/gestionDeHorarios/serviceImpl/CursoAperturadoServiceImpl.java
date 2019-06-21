package com.calidadSoftware.gestionDeHorarios.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoAperturadoServiceImpl implements CursoAperturadoService {
	@Autowired
	CursoAperturadoDAO cursoAperturadoDAO;
	
	public List<CursoDTO> obtenerListaCurso(String campoBusqueda,Integer idCampoBusqueda,Integer opcionBusqueda){
		List<CursoDTO> listaCurso=new ArrayList<CursoDTO>();
		if(campoBusqueda.isEmpty() && (idCampoBusqueda==null ||  idCampoBusqueda.equals(0))){
			Util.mensaje(3, "No se ha ingresado ning�n dato al campo de b�queda.");
		}else{
			listaCurso=cursoAperturadoDAO.obtenerListaCurso(campoBusqueda,idCampoBusqueda,opcionBusqueda);
		}
		return listaCurso;	
	}
	
	public List<EspecialidadDTO> obtenerListaEspecialidad(){
		List<EspecialidadDTO> listaEspecialidad;
		listaEspecialidad=cursoAperturadoDAO.obtenerListaEspecialidad();
		return listaEspecialidad;
	}
	
	public List<DocenteDTO> obtenerListaDocente(String campoBusqueda,Integer idCampoBusqueda,Integer opcionBusqueda){
		List<DocenteDTO> listaDocente=new ArrayList<DocenteDTO>();
		if(campoBusqueda.isEmpty() && (idCampoBusqueda==null ||  idCampoBusqueda.equals(0))){
			Util.mensaje(3, "No se ha ingresado ning�n dato al campo de b�queda.");
		}else{
			listaDocente=cursoAperturadoDAO.obtenerListaDocente(campoBusqueda,idCampoBusqueda,opcionBusqueda);
		}
		return listaDocente;	
	}
	
	public List<HorarioDTO> agregarHorario(List<HorarioDTO> listaHorario,HorarioDTO horario){
		if(horario.getDia().equals(0) || horario.getHorInicio()==null || horario.getHorTermino()==null){
			Util.mensaje(3, "Debe ingresar todos los campos para poder agregar un horario al curso.");
		}else{
			switch(horario.getDia()){
				case 1:
						horario.setNombreDia("LUNES");
						break;
				case 2:
						horario.setNombreDia("MARTES");
						break;
				case 3:
						horario.setNombreDia("MI�RCOLES");
						break;
				case 4:
						horario.setNombreDia("JUEVES");
						break;
				case 5:
						horario.setNombreDia("VIERNES");
						break;
				case 6:
						horario.setNombreDia("S�BADO");
						break;
				case 7:
						horario.setNombreDia("DOMINGO");
						break;	
			}
			listaHorario.add(horario);
		}
		
		return listaHorario;
	}
	
	public List<HorarioDTO> eliminarHorario(List<HorarioDTO> listaHorario, HorarioDTO horario){
		for(int i=0;i<listaHorario.size();i++){
			if(listaHorario.get(i)==horario){
				listaHorario.remove(i);
				break;
			}
		}
		return listaHorario;
	}
	
	public Boolean validarDatosCursoAperturado(String aula,DocenteDTO docente,Date fecInicio,Date fecTermino,List<HorarioDTO> horario){
		Boolean flag=true;
		Integer compFechas;
		if(aula.isEmpty()){
			Util.mensaje(3,"Debe ingresar el aula donde se realizar� el curso.");
			flag=false;
		}
		
		if(docente==null){
			Util.mensaje(3,"Debe ingresar un docente para el curso.");
			flag=false;
		}
		
		if(fecInicio==null){
			Util.mensaje(3,"Debe ingresar la fecha de incio del curso.");
			flag=false;
		}
		
		if(fecTermino==null){
			Util.mensaje(3,"Debe ingresar la fecha de termino del curso.");
			flag=false;
		}
		
		if(fecInicio!= null && fecTermino!= null){
			compFechas=fecInicio.compareTo(fecTermino);
			if(compFechas>0){
				Util.mensaje(3,"La fecha de termino debe ser despues de la fecha de inicio.");
				flag=false;
			}
		}
		
		if(horario.isEmpty()){
			Util.mensaje(3,"Debe ingresar un horario para el curso.");
			flag=false;
		}
		
		return flag;
	}
	
	@Transactional
	public void aperturarCurso(String aula,DocenteDTO docente,Date fecInicio,Date fecTermino, List<HorarioDTO> horario,CursoDTO curso){
		CursoAperturadoDTO cursoAperturado=new CursoAperturadoDTO();
		Integer idCursoAperturado;
		cursoAperturado.setFecInicio(fecInicio);
		cursoAperturado.setFecTermino(fecTermino);
		cursoAperturado.setVacante(curso.getVacante());
		cursoAperturado.setAula(aula);
		cursoAperturado.setIdCurso(curso.getId());
		cursoAperturado.setIdDocente(docente.getId());
		cursoAperturadoDAO.insertarCursoAperturado(cursoAperturado);
		idCursoAperturado=cursoAperturadoDAO.obtenerUltimoCursoAperturado();
		for(int i=0;i<horario.size();i++){
			horario.get(i).setIdCurso(idCursoAperturado);
			cursoAperturadoDAO.insertarHorario(horario.get(i));
		}
		Util.mensaje(1,"Se ha aperturado el curso satisfactoriamente.");
	}
	
	public List<TipoCursoDTO> obtenerListaTipoCurso(){
		List<TipoCursoDTO> listaTipoCurso;
		listaTipoCurso=cursoAperturadoDAO.obtenerListaTipoCurso();
		return listaTipoCurso;
	}
	
	public List<AlumnoDTO> obtenerListaAlumnosCursoAperturado(Integer idCursoAperturado){
		List<AlumnoDTO> listaAlumno;
		listaAlumno=cursoAperturadoDAO.obtenerListaAlumnosCursoAperturado(idCursoAperturado);
		return listaAlumno;
	}
	
	@Transactional
	public List<CursoAperturadoDTO> obtenerListaCursoAperturado(String campoBusqueda,Integer idCampoBusqueda,Integer opcionBusqueda,Integer estado){
		List<CursoAperturadoDTO> listaCursoAperturado=new ArrayList<CursoAperturadoDTO>();
		List<HorarioDTO> horario=new ArrayList<HorarioDTO>();
		SimpleDateFormat formatoDeHora = new SimpleDateFormat("hh:mm a");
		String cadenaHorario;
		if(campoBusqueda.isEmpty() && (idCampoBusqueda==null ||  idCampoBusqueda.equals(0))){
			Util.mensaje(3, "No se ha ingresado ning�n dato al campo de b�queda.");
		}else{
			listaCursoAperturado=cursoAperturadoDAO.obtenerListaCursoAperturado(campoBusqueda,idCampoBusqueda,opcionBusqueda,estado);
			for(int i=0;i<listaCursoAperturado.size();i++){
				horario=cursoAperturadoDAO.obtenerHorarioCursoAperturado(listaCursoAperturado.get(i).getId());
				cadenaHorario="";
				if(horario.isEmpty()){
					cadenaHorario="No se ha ingresado horario.";
				}else{
					for(int j=0;j<horario.size();j++){
						switch(horario.get(j).getDia()){
							case 1:
									horario.get(j).setNombreDia("LUNES");
									break;
							case 2:
									horario.get(j).setNombreDia("MARTES");
									break;
							case 3:
									horario.get(j).setNombreDia("MI�RCOLES");
									break;
							case 4:
									horario.get(j).setNombreDia("JUEVES");
									break;
							case 5:
									horario.get(j).setNombreDia("VIERNES");
									break;
							case 6:
									horario.get(j).setNombreDia("S�BADO");
									break;
							case 7:
									horario.get(j).setNombreDia("DOMINGO");
									break;	
						}
						cadenaHorario+=horario.get(j).getNombreDia()+"    "+formatoDeHora.format(horario.get(j).getHorInicio())+" - "+formatoDeHora.format(horario.get(j).getHorTermino());
						if(j!=horario.size()-1){
							cadenaHorario+="\n";
						}
					}
				}
				listaCursoAperturado.get(i).setHorario(cadenaHorario);
			}
		}
		return listaCursoAperturado;
	}
	
	public List<HorarioDTO> obtenerListaHorario(Integer idCursoAperturado){
		List<HorarioDTO> listaHorario;
		listaHorario=cursoAperturadoDAO.obtenerHorarioCursoAperturado(idCursoAperturado);
		for(int i=0;i<listaHorario.size();i++){
			switch(listaHorario.get(i).getDia()){
			case 1:
				listaHorario.get(i).setNombreDia("LUNES");
				break;
			case 2:
				listaHorario.get(i).setNombreDia("MARTES");
				break;
			case 3:
				listaHorario.get(i).setNombreDia("MI�RCOLES");
				break;
			case 4:
				listaHorario.get(i).setNombreDia("JUEVES");
				break;
			case 5:
				listaHorario.get(i).setNombreDia("VIERNES");
				break;
			case 6:
				listaHorario.get(i).setNombreDia("S�BADO");
				break;
			case 7:
				listaHorario.get(i).setNombreDia("DOMINGO");
				break;	
			}
		}
		return listaHorario;
	}
	
	@Transactional
	public void modificarCursoAperturado(CursoAperturadoDTO cursoAperturado, List<HorarioDTO> horarios){
		List<HorarioDTO> horariosActuales= new ArrayList<HorarioDTO>();
		Boolean flag;
		if(horarios.isEmpty()){
			Util.mensaje(2,"No se ha agregado ning�n horario al curso.");
		}
		cursoAperturadoDAO.modificarDatosCursoAperturado(cursoAperturado);
		for(int i=0;i<horarios.size();i++){
			if(horarios.get(i).getId()==null){
				horarios.get(i).setIdCurso(cursoAperturado.getId());
				cursoAperturadoDAO.insertarHorario(horarios.get(i));
			}
		}
		horariosActuales=cursoAperturadoDAO.obtenerHorarioCursoAperturado(cursoAperturado.getId());
		for(int i=0;i<horariosActuales.size();i++){
			flag=true;
			for(int j=0;j<horarios.size();j++){
				if(horarios.get(j).getId()!=null && horariosActuales.get(i).getId().equals(horarios.get(j).getId())){
					flag=false;
					break;
				}
			}
			if(flag.equals(true)){
				cursoAperturadoDAO.eliminarHorario(horariosActuales.get(i).getId());
			}
		}
		Util.mensaje(1,"Se ha modificado el curso aperturado satisfactoriamente.");
	}
	
	public void cambiarEstadoCursoAperturado(Integer idCursoAperturado,Boolean estado){
		cursoAperturadoDAO.cambiarEstadoCursoAperturado(idCursoAperturado,!estado);
	}
	
	public Boolean validarDatosAlumnosCursosAperturado(List<AlumnoDTO> alumnos){
		Boolean flag;
		flag=true;
		
		for(int i=0;i<alumnos.size();i++){
			if(alumnos.get(i).getNotaCurso()==null){
				flag=false;
				Util.mensaje(3, "Debe ingresar todas las notas a los alumnos.");
				break;
			}
		}
		
		if(alumnos.isEmpty()){
			flag=false;
			Util.mensaje(3, "No puede clausurar un curso que no tenga ningun alumno matriculados.");
		}
		return flag;
	}
	
	@Transactional
	public void clausurarCursoAperturado(List<AlumnoDTO> alumnos,CursoAperturadoDTO cursoAperturado){
		for(int i=0;i<alumnos.size();i++){
			cursoAperturadoDAO.actualizarNotaAlumnoCursoAperturado(alumnos.get(i).getNotaCurso(),alumnos.get(i).getId(),cursoAperturado.getId());
		}
		cursoAperturadoDAO.cambiarEstadoCursoAperturado(cursoAperturado.getId(),!cursoAperturado.getEstado());	
	}
	
	public List<CursoAperturadoDTO> obtenerCursoPorTipo(Integer inputTipoCurso) {
		List<CursoAperturadoDTO> listaCursoAperturado=new ArrayList<CursoAperturadoDTO>();
		List<HorarioDTO> horario=new ArrayList<HorarioDTO>();
		SimpleDateFormat formatoDeHora = new SimpleDateFormat("hh:mm a");
		String cadenaHorario;
		
		if(!inputTipoCurso.equals(null)){
			listaCursoAperturado=cursoAperturadoDAO.obtenerCursoPorTipo(inputTipoCurso);
			
			for(int i=0;i<listaCursoAperturado.size();i++){
				horario=cursoAperturadoDAO.obtenerHorarioCursoAperturado(listaCursoAperturado.get(i).getId());
				cadenaHorario="";
				if(horario.isEmpty()){
					cadenaHorario="No se ha ingresado horario.";
				}else{
					for(int j=0;j<horario.size();j++){
						switch(horario.get(j).getDia()){
							case 1:
									horario.get(j).setNombreDia("LUNES");
									break;
							case 2:
									horario.get(j).setNombreDia("MARTES");
									break;
							case 3:
									horario.get(j).setNombreDia("MI�RCOLES");
									break;
							case 4:
									horario.get(j).setNombreDia("JUEVES");
									break;
							case 5:
									horario.get(j).setNombreDia("VIERNES");
									break;
							case 6:
									horario.get(j).setNombreDia("S�BADO");
									break;
							case 7:
									horario.get(j).setNombreDia("DOMINGO");
									break;	
						}
						cadenaHorario+=horario.get(j).getNombreDia()+"    "+formatoDeHora.format(horario.get(j).getHorInicio())+" - "+formatoDeHora.format(horario.get(j).getHorTermino());
						if(j!=horario.size()-1){
							cadenaHorario+="\n";
						}
					}
				}
				listaCursoAperturado.get(i).setHorario(cadenaHorario);				
			}
			return listaCursoAperturado;
		}else{
			return null;
		}
		
	}

	@Transactional
	public void matricularAlumno(Integer idAlumno, Integer idCurApe, Integer idUsu) {
		if(idAlumno.equals(null)||idCurApe.equals(null)||idUsu.equals(null)){
			Util.mensaje(3, "No se ha podido matricular al alumno.");
		}else{
			cursoAperturadoDAO.matricularAlumno(idAlumno, idCurApe, idUsu);
			cursoAperturadoDAO.actualizarVacanteCursoAperturado(idCurApe);
		}
		
	}
}