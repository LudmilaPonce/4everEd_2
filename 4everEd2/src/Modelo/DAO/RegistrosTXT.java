package Modelo.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;

import Modelo.Curso;

public class RegistrosTXT implements Datos {

//	Registros.txt 			TAB
//	numeroCurso	dniAlumno		fechaInscripcion		observaciones

	private static final String registros= path + "Registros.txt";
	
	public static void agregarRegistro(Curso curso, int i) throws FileNotFoundException {
		
			File file = new File(registros);
			FileOutputStream stream = new FileOutputStream(file, true);
			PrintWriter writer = new PrintWriter(stream);
		
				StringBuilder builder = new StringBuilder();
				
				
				builder.append(curso.getNumero());
				builder.append("\t" + curso.getInscripciones().get(i).getAlumno().getDni());
				builder.append("\t" + curso.getInscripciones().get(i).getFecha().get(Calendar.DATE)+ "/"+(curso.getInscripciones().get(i).getFecha().get(Calendar.MONTH) + 1) + "/" +curso.getInscripciones().get(i).getFecha().get(Calendar.YEAR)        )      ;
				builder.append("\t" + curso.getInscripciones().get(i).getObservacion());
				
				writer.println(builder.toString());
			
			writer.close();
		
	}
	
}