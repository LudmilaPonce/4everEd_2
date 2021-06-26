package Modelo;

import java.util.Calendar;

public class Calificaciones {

	private int calificacion;
	private String instancia;
	private Calendar fecha;
	
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public String getInstancia() {
		return instancia;
	}
	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public Calificaciones(int calificacion, String instancia, Calendar fecha) {
		super();
		this.calificacion = calificacion;
		this.instancia = instancia;
		this.fecha = fecha;
	}
	
	public Calificaciones() {
		
	}
	
	
}
