package Controlador;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import Modelo.Materia;
import Modelo.DAO.Modelo;

public class ControlMaterias {

	private ArrayList<Materia> materias;
	
	ControlMaterias() throws FileNotFoundException {
		materias = Modelo.leerMaterias();
	}
	
	public ArrayList<Materia> getMaterias() {
		return materias;
	}
	
	public int buscarPosicionMateria(int codigo) {
		int i = materias.size();//50
		while((--i >= 0) && (materias.get(i).getCodigo() != codigo));
		return i < 0 ? -1 : i;
	}
	
	
	public Materia buscarMateriaCompleta(int codigo) {
		int i = materias.size();
		while(--i >= 0 && materias.get(i).getCodigo() != codigo);
		return i < 0 ? null : materias.get(i);
	}
	
	
	
	
}
