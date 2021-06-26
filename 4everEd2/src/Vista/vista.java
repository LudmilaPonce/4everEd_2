package Vista;

import java.util.Calendar;

public interface vista {
	// esta interfaz contendr� todos los m�todos
	// que el controlador puede ejecutar sobre la vista
		
	void mostrarTexto(String texto);
	void mostrarFecha(Calendar fecha);
	int pedirCodigo();
	int pedirRango(int desde, int hasta);
	String pedirTexto();
	String pedirNombre();
	String pedirOpcion(String opc1, String opc2);
	// etc
}
