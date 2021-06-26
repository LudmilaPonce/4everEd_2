package Modelo;

import java.util.ArrayList;
import java.util.Calendar;

public class Curso {
	private int ano;
	private int numero;
	private int alumnosMax;
	private String dias;
	private String turno;
	private static Calendar fechaInicio;
	
	private int clasesTotal;
	
//	private Inscripcion[] inscripciones = new Inscripcion[10]; composicion
	private ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
	
//	private Clase[] clases= new Clase[20]; //composicion
	private ArrayList<Clase> clases = new ArrayList<Clase>();
	 
	private Materia materia; //agregacion
	
	public Curso(Calendar fechaInicio,int ano, int numero, int alumnosMax, String dias, String turno, int clasesTotal, Materia materia) {
		super();
		this.fechaInicio = fechaInicio;
		this.ano = ano;
		this.numero = numero;
		this.alumnosMax = alumnosMax;
		this.dias = dias;
		this.turno = turno;
		this.clasesTotal = clasesTotal;
		
		this.materia = materia;
	}	
	
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getAlumnosMax() {
		return alumnosMax;
	}
	public void setAlumnosMax(int alumnosMax) {
		this.alumnosMax = alumnosMax;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public int getClasesTotal() {
		return clasesTotal;
	}
	public void setClasesTotal(int clasesTotal) {
		this.clasesTotal = clasesTotal;
	}
	
	public ArrayList<Inscripcion> getInscripciones() {
		return inscripciones;
	}


	public void setInscripciones(Calendar fecha, String observacion, Persona alumno, int i) {
		this.inscripciones.get(i).setFecha(fecha);
		this.inscripciones.get(i).setObservacion(observacion);
		this.inscripciones.get(i).setAlumno(alumno);;
	}


	public ArrayList<Clase> getClases() {
		return clases;
	}


	public void setClases(String tipoClase, String temas, int i, int numeroClase, Calendar fecha){
		this.clases.get(i).setTipoClase(tipoClase);
		this.clases.get(i).setTemas(temas);
		this.clases.get(i).setFecha(fecha);
		this.clases.get(i).setNumeroClase(numeroClase);
	}


	public ArrayList<Persona> getAlumnosInscriptos() {//Esta funcion revisa en inscripcion los alumnos aceptados y los devuelve.
	//	Persona[] alumnos = new Alumno[50];
		
		ArrayList<Persona> alumnos = new ArrayList<Persona>();
	
		int i=0;
		for (Inscripcion ins : inscripciones) {
			if (ins.isAceptada()) {
			//	alumnos[i]=ins.getAlumno();
				alumnos.add(ins.getAlumno());
				
		
				i++;
			}
		}
		return alumnos;
	}

	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}


	public static Calendar getFechaInicio() {
		return fechaInicio;
	}

	public static void setFechaInicio(Calendar fechaInicio) {
		Curso.fechaInicio = fechaInicio;
	}
	
	
	
	
	
}
