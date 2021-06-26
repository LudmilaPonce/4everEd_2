package Modelo;

public class Titulo {
	private String titulo;
	private int anio;
	private String lugar;

	public Titulo(String titulo, int anio, String lugar) {
		super();
		this.titulo = titulo;
		this.anio = anio;
		this.lugar = lugar;
	}

	public Titulo() {

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

}
