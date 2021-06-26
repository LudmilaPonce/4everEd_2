package Modelo.DAO;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import Modelo.Curso;
import Modelo.Materia;
import Modelo.Persona; 

// Esta clase abstracta contendr� los m�todos est�ticos que puede ejecutar el controlador
// y los gestiona a trav�s de las clases en DAO
public abstract class Modelo {
	
	public static ArrayList<Materia> leerMaterias() throws FileNotFoundException { //Clase modelo de modelo dao se conecta con la clase materiastxt para leer
		return MateriasTXT.leerMaterias();
	}
	
	public static void agregarCurso(Curso curso) throws FileNotFoundException {
		CursosTXT.agregarCurso(curso);
	}
	
	public static void crearRegistros (Curso curso, int i) throws FileNotFoundException {
		RegistrosTXT.agregarRegistro(curso, i);
	}
	
	public static void agregarAsistencia(Curso curso, int clase, int alumno) throws FileNotFoundException {
		AsistenciaTXT.agregarAsistencia(curso, clase, alumno);
	}
	
	public static void agregarTema(Curso curso, int clase) throws FileNotFoundException {
		LibrosTemasTXT.agregarTema(curso, clase);
	}

	public static void ControlAsistencia(Curso c, Persona alumno, int num) throws FileNotFoundException{
		AusentesJSON.agregarControlAsistencia(c, alumno, num);
	}

	public static ArrayList<Persona> leerPersonas() throws FileNotFoundException{
		return PersonasJSON.leerPersonas();
	}
	
	public static void AgregarCursoCompleto(Curso c, boolean distancia) throws FileNotFoundException{
		CursosCompletosTXT.agregarCurso(c, distancia);
	}

	public static void agregarPresentismo(Curso curso, double asistencia) throws FileNotFoundException {
		PresentismoCSV.agregarPresentismo(curso, asistencia);
	}
	
	
}
