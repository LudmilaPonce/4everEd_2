package Modelo;

import java.util.ArrayList;
import java.util.Calendar;

public class Alumno extends Persona {
	private boolean pago;
	private Calendar fechaPago;

	private ArrayList<Calificaciones> calificaciones = new ArrayList<Calificaciones>();
	
	private boolean aprobado;
	private double porcentajeAsistencia;
	
	

	public double getPorcentajeAsistencia() {
		return porcentajeAsistencia;
	}

	public void setPorcentajeAsistencia(double porcentajeAsistencia) {
		this.porcentajeAsistencia = porcentajeAsistencia;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public Alumno(long dni, String nombre, String apellido, char sexo, Calendar fechaNac, boolean pago,boolean aprobado ) {
		super(dni, nombre, apellido, sexo, fechaNac);
		this.pago = pago;
		this.aprobado= aprobado;
	}

	public Alumno() {

	}
	
	

	public boolean isAprobado() {
		return aprobado;
	}

	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}

	public void setCalificaciones(ArrayList<Calificaciones> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Calendar getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Calendar fechaPago) {
		this.fechaPago = fechaPago;
	}

	public ArrayList<Calificaciones> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(int calificacion, String instancia, Calendar fecha) {
		this.calificaciones.add(new Calificaciones(calificacion, instancia, fecha));
	}

}
