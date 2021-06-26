package Modelo.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import Modelo.Curso;
import Modelo.Distancia;
import validador.Validador;

public class CursosCompletosTXT {

	public static void agregarCurso(Curso curso,boolean plataforma) throws FileNotFoundException {
		
		String nombre = "CursosCompletos"+ curso.getAno()+".txt";
		
		File file = new File(nombre);
		FileOutputStream stream = new FileOutputStream(file, true);
		PrintWriter writer = new PrintWriter(stream);
		StringBuilder builder = new StringBuilder();
		
		builder.append(String.format("%4d", curso.getNumero()));				// 4 dígitos
		builder.append(String.format("%30s", curso.getMateria().getNombre()));	// 30 letras
		builder.append(String.format("%15s", curso.getTurno()));	// 15 letras
		
		builder.append(String.format("%10s", 
				Validador.formatoFecha(curso.getFechaInicio()))); 			// 10 caracteres (dd/mm/aaaa)
		
	if(plataforma == true) {
		builder.append(String.format("%20s", ((Distancia) curso.getMateria()).getPlataforma())); // 20 caracteres
	}
		
		writer.println(builder.toString());
		writer.close();
	}
}
