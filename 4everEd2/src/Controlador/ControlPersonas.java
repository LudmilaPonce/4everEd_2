package Controlador;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import Modelo.Persona;
import Modelo.DAO.Modelo;

public class ControlPersonas {
	
	static ArrayList<Persona> personas;
	
	public static int buscarAlumno(long dni, ArrayList<Persona> alumnos) {
		int i = alumnos.size();
		while(--i >= 0 && alumnos.get(i).getDni() != dni);
		return i < 0 ? -1 : i;
	}
	
	public static int buscarDocente(long dni, ArrayList<Persona> docente) {
		int i = docente.size();
		while(--i >= 0 && docente.get(i).getDni() != dni);
		return i < 0 ? -1 : i;
	}

	
	ControlPersonas() throws FileNotFoundException {
		personas = Modelo.leerPersonas();
	}

public static ArrayList<Persona> getPersonas() {
	return personas;
}	

}
