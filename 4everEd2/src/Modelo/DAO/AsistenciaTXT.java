package Modelo.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import Modelo.Curso;
import validador.Validador;

public class AsistenciaTXT implements Datos {
// Asistencia.txt		ancho fijo
// numeroCurso	numeroClase		fechaClase		nombreAlumno	dniAlumno	presenteono
//4 - 4- 10 - 40 - 9 - 5
	
	private static final String asistencia = path + "Asistencia.txt";

	public static void agregarAsistencia(Curso curso, int clase, int alumno) throws FileNotFoundException {
		File file = new File(asistencia);
		FileOutputStream stream = new FileOutputStream(file, true);
		PrintWriter writer = new PrintWriter(stream);
		StringBuilder builder = new StringBuilder();
		
		builder.append(String.format("%4d", curso.getNumero()));				// 4 dígitos
		builder.append(String.format("%4d", curso.getClases().get(clase).getNumeroClase()));	// 4 dígitos
		builder.append(String.format("%10s", 
				Validador.formatoFecha(curso.getClases().get(clase).getFecha()))); 				// 10 caracteres (dd/mm/aaaa)
		builder.append(String.format("%50s",curso.getClases().get(clase).getAsistencias().get(alumno).getAlumno().getApellido()+" "+ curso.getClases().get(clase).getAsistencias().get(alumno).getAlumno().getNombre() ));	// 50 caracteres
		builder.append(String.format("%9d",curso.getClases().get(clase).getAsistencias().get(alumno).getAlumno().getDni())); // 9 digitos
		builder.append(String.format("%5s", curso.getClases().get(clase).getAsistencias().get(alumno).getPresente())); // 5 caracteres
		
		writer.println(builder.toString());
		writer.close();
	}
	
	
	/*
	public static void agregarAsistencia(Curso curso, int clase, int alumno) throws FileNotFoundException {
		File file = new File(asistencia);
		FileOutputStream stream = new FileOutputStream(file, true);
		PrintWriter writer = new PrintWriter(stream);
		StringBuilder builder = new StringBuilder();
		
		builder.append(String.format("%4d", curso.getNumero()));				// 4 dígitos
		builder.append(String.format("%4d", curso.getClase()[clase].getNumeroClase()));	// 4 dígitos
		builder.append(String.format("%10s", 
				Validador.formatoFecha(curso.getClase()[clase].getFecha()))); 				// 10 caracteres (dd/mm/aaaa)
		builder.append(String.format("%50s", curso.getClase()[clase].getAsistencias()[alumno].getAlumno().getApellido()+" "+ curso.getClase()[clase].getAsistencias()[alumno].getAlumno().getNombre() ));	// 50 caracteres
		builder.append(String.format("%9d", curso.getClase()[clase].getAsistencias()[alumno].getAlumno().getDni())); // 9 digitos
		builder.append(String.format("%5s", curso.getClase()[clase].getAsistencias()[alumno].getPresente())); // 5 caracteres
		
		writer.println(builder.toString());
		writer.close();
	}
	*/
}