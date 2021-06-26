package Modelo.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import Modelo.Curso;

public class PresentismoCSV {

	private static final String archivo = "Presentismo.csv";
	
//	Cursos.txt		(a elecci�n)
//	a�o codigoMateria	numeroCurso	   cantidadAlumnosMax	diasCursada	    turno	     fechaInicio

	public static void agregarPresentismo(Curso curso, double porcentaje) throws FileNotFoundException {
		File file = new File(archivo);
		FileOutputStream stream = new FileOutputStream(file, true);
		PrintWriter writer = new PrintWriter(stream);
		StringBuilder builder = new StringBuilder();
		builder.append(curso.getAno());
		builder.append(";" + curso.getNumero());
		builder.append(";" + curso.getAno());
		builder.append(";" + porcentaje); 
		
		writer.println(builder.toString());
		writer.close();
	}
}
