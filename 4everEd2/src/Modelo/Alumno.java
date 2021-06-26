package Modelo;

import java.util.ArrayList;
import java.util.Calendar;

public class Alumno extends Persona {
	private boolean pago;
	private Calendar fechaPago;

	private ArrayList<Calificaciones> calificaciones = new ArrayList<Calificaciones>();

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public Alumno(long dni, String nombre, String apellido, char sexo, Calendar fechaNac, boolean pago) {
		super(dni, nombre, apellido, sexo, fechaNac);
		this.pago = pago;
	}

	public Alumno() {

	}

	public Calendar getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Calendar fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	

}
