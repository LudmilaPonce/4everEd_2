package Modelo;

import java.util.ArrayList;
import java.util.Calendar;

public class Docente extends Persona {
	private int anioIngreso;
//	private Titulo titulos[]= new Titulo[2];
	private ArrayList<Titulo> titulos = new ArrayList<Titulo>(); //COMPOSICION

	public Docente(long dni, String nombre, String apellido, char sexo, Calendar fechaNac, int anioIngreso) {
		super(dni, nombre, apellido, sexo, fechaNac);
		this.anioIngreso = anioIngreso;
	}

	public Docente() {
	}

	public int getAnioIngreso() {
		return anioIngreso;
	}

	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;
	}

	

	public ArrayList<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(int pos, String titulo, int anio, String lugar) {
	
		this.titulos.get(pos).setLugar(lugar);
		this.titulos.get(pos).setTitulo(titulo);
		this.titulos.get(pos).setAnio(anio);
	}

}
