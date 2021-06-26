package Modelo.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import Modelo.Curso;
import validador.Validador;

public class LibrosTemasTXT implements Datos  {
	
//	LibroTemas.txt		ancho fijo
//	numeroCurso		numeroClase		fechaClase		tipoClase		temaDado

	private static final String libroTemas = path + "LibroTemas.txt";

	public static void agregarTema(Curso curso, int clase) throws FileNotFoundException {
		File file = new File(libroTemas);
		FileOutputStream stream = new FileOutputStream(file, true);
		PrintWriter writer = new PrintWriter(stream);
		StringBuilder builder = new StringBuilder();
		
		builder.append(String.format("%4d", curso.getNumero()));				// 4 dígitos
		builder.append(String.format("%4d", curso.getClases().get(clase).getNumeroClase()));	// 4 dígitos	
		
		builder.append(String.format("%10s", 
				Validador.formatoFecha(curso.getClases().get(clase).getFecha()))); 			// 10 caracteres (dd/mm/aaaa)
		builder.append(String.format("%50s", curso.getClases().get(clase).getTipoClase()));	// 50 caracteres
		builder.append(String.format("%50s", curso.getClases().get(clase).getTemas()));	// 50 caracteres
		
		writer.println(builder.toString());
		writer.close();
	}
	
	
	
	
}
