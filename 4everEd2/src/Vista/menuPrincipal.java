package Vista;

import java.io.FileNotFoundException;
import java.util.Calendar;

import Controlador.Controlador;
import validador.Validador;

public class menuPrincipal implements vista  {
	private Controlador controlador; //Se conecta con el controlador
	
	public menuPrincipal(String[] args) {
		controlador = null;
	}
	
	public void iniciar() {
		controlador = Controlador.conectar(this);
		if(controlador == null) {
			System.out.println("No se puede iniciar el sistema");
		} else {
			System.out.println("Conexi�n exitosa");
			menu();
		}
	}
	
	private int mostrarMenu() {
		System.out.println("\nMEN� PRINCIPAL");
		System.out.println("0. Salir");
		System.out.println("1. Generar curso ");
		System.out.println("2. Inscribir alumno al curso");
		System.out.println("3. Asistencia ingreso");
		System.out.println("4. Agregar temas de las clases en TXT");
		System.out.println("5. Resumen presentismo en JSON ");
		System.out.println("6. CONSULTA: Libro de temas ");
		System.out.println("7. CONSULTA: Control Asistencia parametro de la app ");
		System.out.println("8. CONSULTA: Alumnos sin cursar");
		
		System.out.println("9. CONSULTA: cantidad cursos donde la cantidad de alumnas mujeres supere el promedio de inscriptos");
		System.out.println("10. CONSULTA: Profesores que dictan materias virtuales con antiguedad de mas de 3 a�os ");
		System.out.println("11. CONSULTA: Guardar cursos completos y presentismo");
		
		return Validador.leerInt(0, 12);
	}
	
	private void menu() {
		int opcion;
		
		while((opcion = mostrarMenu()) != 0) {
			switch(opcion) {
			case 1:
			controlador.generarCursos(); //TERMINADO 
				break; 
			case 2:
				controlador.inscribirAlumnos(); //TERMINADO
				break;
			case 3:
			controlador.ControlarAsistencia(); //TERMINADO
				break;
			case 4:
			controlador.agregarTemas(); //TERMINADO
				break;
			case 5:
				controlador.resumenPresentismo(); // TERMINADO
				break;
			case 6:
				controlador.librosTemas();//TERMINADO
				break;
			case 7:
			//controlador.controlDeAsistencia(args);
				break;
			case 8:
				controlador.alumnosSinCursar(); // TERMINADO
				break;
			case 9:
				controlador.mujeres(); //TERMINADO
				break;
			case 10:
				controlador.profesoresVirtuales();
				break;
			case 11:
				controlador.guardarCursosCompletos();
				controlador.guardarPresentismo();
				break;
			}
		}
		
		System.out.println("\nFin del programa");
	}
	
	
	// funciones para mostrar en la vista
	
	

	@Override
	public void mostrarTexto(String mensaje) {
		System.out.println(mensaje);
	}

	@Override
	public void mostrarFecha(Calendar fecha) {
		System.out.println(Validador.formatoFecha(fecha));
	}

	@Override
	public int pedirCodigo() {
		return Validador.leerInt(0);
	}

	@Override
	public String pedirTexto() {
		return Validador.leerString(true);
	}

	@Override
	public String pedirNombre() {
		return Validador.leerString(false);
	}

	@Override
	public String pedirOpcion(String opc1, String opc2) {
		return Validador.leerOpcion(opc1, opc2);
	}

	@Override
	public int pedirRango(int desde, int hasta) {
		return Validador.leerInt(desde, hasta);
	}

	
	
	
}
