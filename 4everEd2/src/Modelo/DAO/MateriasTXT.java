package Modelo.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Controlador.ControlPersonas;
import Modelo.Distancia;
import Modelo.Docente;
import Modelo.Materia;
import Modelo.Persona;

public class MateriasTXT implements Datos  {

	private static final String archivo = path + "Materias.txt";
//	Materias.txt		ancho fijo
//	codigoMateria		nombreMateria	cantidadHoras		nombreTutor	plataforma
//3	/20/  3/  20/  15
	
	public static ArrayList<Materia> leerMaterias() throws FileNotFoundException {
		ArrayList<Materia> materias = new ArrayList<>();
		File file = new File(archivo);
		Scanner scanner = new Scanner(new FileInputStream(file));
		int posDocente = -1;
		Persona docente= null;	
		
		while (scanner.hasNext()) {
			
			String linea = scanner.nextLine();
			int codigo = Integer.parseInt(linea.substring(0, 3).trim());			// 3 d�gitos
			String nombre = linea.substring(3, 23).trim();							// 20 letras
			int horas = Integer.parseInt(linea.substring(23, 26).trim());			// 3 digitos
			String promocion = linea.substring(26, 35);

			boolean promocionable = false;

			if(promocion.trim().equalsIgnoreCase("True")) {
				promocionable = true;
			}
			
			
			if(linea.substring(35).length() != 0) {									// Agrego un comentario
				String nombreTutor = linea.substring(36, 57).trim();				// 20 letras
				String plataforma = linea.substring(57, 71).trim();					// 15 letras
						
				long dni = MateriasProfesoresTXT.buscarDNI(codigo); //BUSCO EL DNI DEL PROFESOR CON EL CODIGO DE LA MATERIA
		
				posDocente = ControlPersonas.buscarDocente(dni, ControlPersonas.getPersonas()); //busco entre las personas quien tiene ese dni				
			
				if (posDocente >= 0) {
					docente = ControlPersonas.getPersonas().get(posDocente);
			
				if(dni != 0) {		
				Materia materia = new Distancia(codigo, nombre, horas,docente, promocionable, nombreTutor, plataforma);			
				
				materias.add(materia);
				}		
					
				}
			}else {
				Materia materia = new Materia(codigo, nombre, horas, docente,  promocionable);
				materias.add(materia);
			}
		}
		scanner.close();
		return materias;
	}
}