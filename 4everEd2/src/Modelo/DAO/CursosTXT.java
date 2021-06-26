package Modelo.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;

import Modelo.Curso;

public class CursosTXT implements Datos  {

	private static final String archivo = path + "Cursos.txt";
	
//	Cursos.txt		(a elecci�n)
//	a�o codigoMateria	numeroCurso	   cantidadAlumnosMax	diasCursada	    turno	     fechaInicio

	public static void agregarCurso(Curso curso) throws FileNotFoundException {
		File file = new File(archivo);
		FileOutputStream stream = new FileOutputStream(file, true);
		PrintWriter writer = new PrintWriter(stream);
		StringBuilder builder = new StringBuilder();
		builder.append(curso.getAno());
		builder.append(";" + curso.getMateria().getCodigo());
		builder.append(";" + curso.getNumero());
		builder.append(";" + curso.getAlumnosMax()); 
		builder.append(";" + curso.getDias());
		builder.append(";" + curso.getTurno()); 
		builder.append(";" + curso.getFechaInicio().get(Calendar.DATE)+ "/"+(curso.getFechaInicio().get(Calendar.MONTH) + 1) + "/" +curso.getFechaInicio().get(Calendar.YEAR));
		
		writer.println(builder.toString());
		writer.close();
	}
	
	
}
