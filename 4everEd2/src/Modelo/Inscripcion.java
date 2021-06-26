package Modelo;

import java.util.Calendar;

public class Inscripcion {
	private Calendar fecha;
	private String observacion;
	private Persona alumno; //agregacion
	private boolean aceptada;
	
	public Inscripcion(Calendar fecha, String observacion, Persona alumno) {
		this.fecha = fecha;
		this.observacion = observacion;
		if (alumno instanceof Alumno) {
			this.alumno = alumno;
		}
		
	}

	public Inscripcion() {

	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Persona getAlumno() {
		return alumno;
	}

	public void setAlumno(Persona alumno) {
		if (alumno instanceof Alumno) {
			this.alumno = alumno;
		}
	}

	public boolean isAceptada() {
		return aceptada;
	}

	public void setAceptada(boolean aceptada) {
		this.aceptada = aceptada;
	}

}
