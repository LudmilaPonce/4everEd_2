package Controlador;

import java.util.ArrayList;

import Modelo.Curso;


public class ControlCursos {

	public static int buscarCurso(int codigo, ArrayList<Curso> cursos) {
		int i = cursos.size();
		while(--i >= 0 && cursos.get(i).getNumero() != codigo);
		return i < 0 ? -1 : i;	
	
}
}
