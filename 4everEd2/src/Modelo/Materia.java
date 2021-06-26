package Modelo;

public class Materia {
	protected int codigo;
	protected String nombre;
	protected int horas;
	protected Persona docente; //agrega
	protected boolean promocionable;

	public Materia(int codigo, String nombre, int horas, Persona docente, boolean promocionable) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.horas = horas;
		if (docente instanceof Docente) {//Verifico que me hayan mandado un docente.
			this.docente = docente;
		}
		this.promocionable = promocionable;
	}	

	public boolean isPromocionable() {
		return promocionable;
	}

	public void setPromocionable(boolean promocionable) {
		this.promocionable = promocionable;
	}





	public Materia() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public Persona getDocente() {
		return docente;
	}

	public void setDocente(Persona docente) {
		if (docente instanceof Docente) {//Verifico que me hayan mandado un docente.
			this.docente = docente;
		}
		
	}

}
