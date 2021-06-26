package Modelo;

import java.util.ArrayList;
import java.util.Calendar;

public class Clase {
	private int numeroClase;
	private Calendar fecha;
	private String tipoClase;
	private String temas;
	
//	private Asistencia[] asistencias = new Asistencia[10]; //composicion
	private ArrayList<Asistencia> asistencias = new ArrayList<Asistencia>();

	
	public Clase(String tipoClase, String temas, Asistencia[] asistencias, int numeroClase, Calendar fecha) {
		super();
		this.tipoClase = tipoClase;
		this.temas = temas;
		this.fecha = fecha;
		this.numeroClase = numeroClase;
	}
	
	public Clase() {
	}

	public String getTipoClase() {
		return tipoClase;
	}

	public void setTipoClase(String tipoClase) {
		this.tipoClase = tipoClase;
	}

	public String getTemas() {
		return temas;
	}

	public void setTemas(String temas) {
		this.temas = temas;
	}

	
  


	public ArrayList<Asistencia> getAsistencias() {
		return asistencias;
	}

	//CHEQUUEAR COMPOSICION
	public void setAsistencia(Boolean presente, Persona alumno, int i) {
		this.asistencias.get(i).setAlumno(alumno);
		this.asistencias.get(i).setPresente(presente);
	}
	
	public int getNumeroClase() {
		return numeroClase;
	}
	public void setNumeroClase(int numeroClase) {
		this.numeroClase = numeroClase;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
}
