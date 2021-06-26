package Modelo.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle.Control;
import java.util.Scanner;
import Controlador.*;
import Controlador.Controlador;
import Modelo.Calificaciones;
import Modelo.Curso;
import Modelo.Alumno;
import validador.Validador;

public class NotasTXT implements Datos {
	
	//dni;codigoMateria;fechaexamen; tipoexamen; nota

	private static final String archivo = path + "Notas.txt";
	
	public static ArrayList<Calificaciones> leerCalificaciones() throws FileNotFoundException {
		ArrayList<Calificaciones> calificaciones = new ArrayList<>();
		Scanner scanner = null;
		File file = new File(archivo);
		scanner = new Scanner(new FileInputStream(file));
		String[] campos = null;

		while(scanner.hasNext()) {
			campos = scanner.nextLine().split(";");			
	
			int dni = Integer.parseInt(campos[0]);
		
			int codigo = Integer.parseInt(campos[1]);
			
			int materia = ControlMaterias.buscarPosicionMateria(codigo); // posicion de la materia
					
			Calendar fecha= Validador.formatoFecha(campos[2]);
			
			String tipo= campos[3];
			
			int nota= Integer.parseInt(campos[4]);
			
			int alumno = ControlPersonas.buscarAlumno(dni, ControlPersonas.getPersonas()); //busco posicion del alumno
			
			for(Curso c: Controlador.getCurso()) { //recorro los cursos
				if(c.getMateria().getCodigo() == codigo) { //busco el curso de la materia del codigo
					
		((Alumno)c.getAlumnosInscriptos().get(ControlPersonas.buscarAlumno(dni, ControlPersonas.getPersonas()))).
		setCalificaciones(nota, tipo, fecha); //busco al alumno y le seteo la calificacion
					
				}
			}
		}
		scanner.close();
		return calificaciones;
	}
}
