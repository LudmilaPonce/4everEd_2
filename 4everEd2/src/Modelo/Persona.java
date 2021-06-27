package Modelo;

import java.util.Calendar;

public class Persona implements Comparable <Persona> {
	protected long dni;
	protected String nombre;
	protected String apellido;
	protected char sexo;
	protected Calendar fechaNac;

	public Persona(long dni, String nombre, String apellido, char sexo, Calendar fechaNac) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
	}

	public Persona() {

	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {// solo registro si mandan F o M
		if((sexo=='M')||(sexo=='m')||(sexo=='F')||(sexo=='f')) {
			sexo = Character.toUpperCase(sexo);
		}
		this.sexo = sexo;
	}

	public Calendar getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Calendar fechaNac) {
		this.fechaNac = fechaNac;
	}

	@Override
	public int compareTo(Persona p) {
		int lastCmp = apellido.compareTo(p.apellido);
		return (lastCmp != 0 ? lastCmp : nombre.compareTo(p.nombre));
	}
}
