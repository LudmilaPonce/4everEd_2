package Modelo.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MateriasProfesoresTXT implements Datos  {

//	MateriasProfesores.txt	|
//	codigoMateria		dniProfesor
	//
	
	private static final String archivo = path + "MateriasProfesores.txt";
	
	
	static Long buscarDNI(int codigo) { //Busca el dni del docente teniendo como dato el codigo de la materia
		long dni = 0;
		Scanner scanner = null;
		try {
			File file = new File(archivo);
			scanner = new Scanner(new FileInputStream(file));
			String[] campos = null;
			boolean hallado = false;
			while(scanner.hasNext() && !hallado) {
				campos = scanner.nextLine().split("\\|");
				hallado = Integer.parseInt(campos[0]) == codigo;
			}
			if(hallado) {
				dni = Long.parseLong(campos[1]);
			}
		} catch (FileNotFoundException e) {
			
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
		return dni;
	}
	
	
	
	
}
