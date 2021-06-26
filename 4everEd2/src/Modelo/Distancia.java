package Modelo;

public class Distancia extends Materia {
	private String tutor;
	private String plataforma;

	public Distancia(int codigo, String nombre, int horas, Persona docente, String tutor, String plataforma) {
		super(codigo, nombre, horas, docente);
		this.tutor = tutor;
		this.plataforma = plataforma;
	}

	public Distancia() {

	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

}
