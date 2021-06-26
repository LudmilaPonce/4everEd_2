package Controlador;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import Controlador.Controlador;
import Modelo.Alumno;
import Modelo.Curso;
import Modelo.Distancia;
import Modelo.Docente;
import Modelo.Inscripcion;
import Modelo.Materia;
import Modelo.Persona;
import Modelo.DAO.Modelo;
import Vista.vista;
import validador.Validador;

//Esta clase contendrï¿½ todos los mï¿½todos de solicitud de acciones y peticiï¿½n
//de datos provenientes de la vista y las gestionarï¿½ a travï¿½s del modelo

public class Controlador {

	private vista vista;

	static ControlMaterias controlMaterias;
	static ControlPersonas controlPersonas;

//	private static Curso cursos[] = new Curso[15];
	private static ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	public static Controlador conectar(vista vista) {
		Controlador controlador;
		try {
			controlador = new Controlador(vista);
		} catch (FileNotFoundException e) {
			controlador = null;
		}
		return controlador;
	}

	// Esta clase solamente puede instanciarse a travï¿½s del mï¿½todo estï¿½tico
	// conectar()
	private Controlador(vista vista) throws FileNotFoundException {
		this.vista = vista;
		controlPersonas = new ControlPersonas(); //lee el JSON y devuelve los docentes y alumnos
		controlMaterias = new ControlMaterias(); // Lee las materias del txt y devuelve arraylist.
		
	}
	
	
		
	public static void PruebaCurso(){
		//(Calendar fechaInicio,int ano, int numero, int alumnosMax, String dias, String turno, int clasesTotal, Materia materia)
		
		Calendar fecha= Calendar.getInstance();

		Curso c = new Curso(fecha, 2021, 1, 20, "Lunes", "MaÃ±ana", 10, controlMaterias.getMaterias().get(0));
		Curso c1 = new Curso(fecha, 2021, 2, 20, "Martes", "Tarde", 10, controlMaterias.getMaterias().get(1));
		Curso c2 = new Curso(fecha, 2021, 3, 20, "Miercoles", "Noche", 10, controlMaterias.getMaterias().get(0));
		Curso c3 = new Curso(fecha, 2021, 4, 20, "Jueves", "MaÃ±ana", 10, controlMaterias.getMaterias().get(1));
		Curso c4 = new Curso(fecha, 2021, 5, 20, "Viernes", "MaÃ±ana", 10, controlMaterias.getMaterias().get(0));
		
		cursos.add(c);
		cursos.add(c1);
		cursos.add(c2);
		cursos.add(c3);
		cursos.add(c4);
		
		cursos.get(0).setInscripciones(fecha, "", controlPersonas.getPersonas().get(0), 0);
		cursos.get(0).setInscripciones(fecha, "", controlPersonas.getPersonas().get(0), 1);
		cursos.get(0).setInscripciones(fecha, "", controlPersonas.getPersonas().get(0), 2);
		cursos.get(0).setInscripciones(fecha, "", controlPersonas.getPersonas().get(0), 3);	
		
		for(Curso cur:cursos){
			System.out.println("Numero de curso: "+ cur.getNumero());
			System.out.println("nombre docente: "+ cur.getMateria().getDocente().getNombre());
		}
		
	}
	public void generarCursos() { // GENERA LOS CURSOS
		boolean existe = false;
		int indiceMateria = 0;

		vista.mostrarTexto("Fecha de inicio");
		Calendar fechaInicio = Validador.leerFecha();
		
		
		for (Curso cur : cursos) {
			vista.mostrarTexto("ingrese aï¿½o lectivo");
			int anio = Validador.leerInt(2020);

			vista.mostrarTexto("ingrese codigo para el curso");
			int numeroCurso = Validador.leerInt();

			vista.mostrarTexto("ingrese codigo materia");
			int codigoMateria = Validador.leerInt();

			do {
				if (controlMaterias.buscarPosicionMateria(codigoMateria) > -1) { // si el indice es mayor a -1 es porque
																					// existe
					indiceMateria = (controlMaterias.buscarPosicionMateria(codigoMateria)); // guardo el indice
					existe = true;
				} else {
					vista.mostrarTexto("No existe ese codigo de materia, vuelva a ingresar");
					codigoMateria = Validador.leerInt();
				}
			} while (existe = false);

			vista.mostrarTexto("Cantidad de alumnos  maximo");
			int maxAlum = Validador.leerInt(5);

			vista.mostrarTexto("Dias de cursada");
			String dias = Validador.leerString(false);

			vista.mostrarTexto("Cantidad de clases");
			int clases = Validador.leerInt(1);

			vista.mostrarTexto("turno");
			vista.mostrarTexto("1. Maï¿½ana	2.Tarde		3.Noche");
			int turno = Validador.leerInt(1, 3);

			String turnoElegido = null;

			switch (turno) {
			case 1:
				turnoElegido = "Maï¿½ana";
				break;
			case 2:
				turnoElegido = "Tarde";
				break;
			case 3:
				turnoElegido = "Noche";
				break;
			}

			Curso c = new Curso(fechaInicio, anio, numeroCurso, maxAlum, dias, turnoElegido, clases,
					controlMaterias.getMaterias().get(indiceMateria));
			cursos.add(c);
			try {
				Modelo.agregarCurso(c);// guardarlo en cursostxt
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		}
		
		for(Curso c: cursos) {
			if (c==null) {
				break;
			}
			System.out.println("Cursos cargado: "+ c.getNumero());
		}
	}

	public void datosAlumnoPrueba() {
		Calendar fecha = Calendar.getInstance();
		fecha.set(2021, 05, 13);
		
		
		cursos.get(0).setInscripciones(fecha, " nada ", controlPersonas.getPersonas().get(3), 0);
		cursos.get(0).setInscripciones(fecha,  " nada ",controlPersonas.getPersonas().get(4), 1);
		cursos.get(0).setInscripciones(fecha,  " nada ", controlPersonas.getPersonas().get(5), 2);
		cursos.get(0).setInscripciones(fecha,  " nada ", controlPersonas.getPersonas().get(6), 3);
		cursos.get(0).setInscripciones(fecha,  " nada ", controlPersonas.getPersonas().get(7), 4);
		
		cursos.get(0).setClases("teorica", "tema 1", 0, 1, fecha);
		
		cursos.get(0).getClases().get(0).setAsistencia(null, controlPersonas.getPersonas().get(3), 0);
		cursos.get(0).getClases().get(0).setAsistencia(null, controlPersonas.getPersonas().get(4), 1);
		cursos.get(0).getClases().get(0).setAsistencia(null, controlPersonas.getPersonas().get(5), 2);
		cursos.get(0).getClases().get(0).setAsistencia(null, controlPersonas.getPersonas().get(6), 3);
		cursos.get(0).getClases().get(0).setAsistencia(null, controlPersonas.getPersonas().get(7), 4);
		
		for (Inscripcion insc : cursos.get(0).getInscripciones()) {
			if (insc.getAlumno()!=null) {
				System.out.println("Alumno inscripto nombre: "+insc.getAlumno().getNombre());
				System.out.println("Alumno inscripto: apellido  "+insc.getAlumno().getApellido());
			}
			
		}
		
		
	}
	public void inscribirAlumnos() {

		boolean existeCurso = false;
		boolean existeAlumno = false;
		int posCurso = -1;

		if (cursos.isEmpty() == false && controlPersonas.getPersonas().isEmpty() == false) { // compruebo que al menos hay 1 curso para poder inscribir

			vista.mostrarTexto("Fecha de inscripcion");
			Calendar fechaInscripcion = Validador.leerFecha();

			vista.mostrarTexto("Codigo de curso");
			int codigo = Validador.leerInt(1);

			do {
				if (ControlCursos.buscarCurso(codigo, cursos) > -1) {
					posCurso = ControlCursos.buscarCurso(codigo, cursos);
					existeCurso = true;
				} else {
					vista.mostrarTexto("No existe ese codigo de materia, vuelva a ingresar");
					codigo = Validador.leerInt();
				}
			} while (existeCurso = false);

			vista.mostrarTexto("DNI alumno");
			long dni = Validador.leerLong();

			int posicionAlumno = -1;
			do {
				if (controlPersonas.buscarAlumno(dni, controlPersonas.getPersonas()) > -1) {
					posicionAlumno = (controlPersonas.buscarAlumno(dni, controlPersonas.getPersonas()));
					existeAlumno = true;
				} else {
					vista.mostrarTexto("No existe alumno con ese dni, vuelva a ingresar");
					dni = Validador.leerLong();
				}
			} while (existeAlumno == false);

			vista.mostrarTexto("Observacion");
			String observacion = Validador.leerString(false);

			Calendar inicio = Curso.getFechaInicio();

			Calendar dosDias = Calendar.getInstance();
			
			dosDias.set(inicio.get(Calendar.YEAR),inicio.get(Calendar.MONTH),inicio.get(Calendar.DATE));
			dosDias.add(Calendar.DATE, -2);
			
			int inscripcion = 0;
			System.out.println("poscurso: "+posCurso);
			for (int i = 0; i < cursos.get(posCurso).getInscripciones().size(); i++) { // Recorro el curso al cual voy a
				System.out.println("estoy en el for");																	// inscribir
				if (cursos.get(posCurso).getInscripciones().get(i).getAlumno() == null) { // si la posicion es nula osea que esta vacia

					cursos.get(posCurso).getInscripciones().get(i).setAlumno(controlPersonas.getPersonas().get(posicionAlumno));

					vista.mostrarTexto("Abonar matricula?\n(S/N)");
					boolean pago = Validador.leerSiNo();

					((Alumno) cursos.get(posCurso).getInscripciones().get(i).getAlumno()).setPago(pago);// SETEO SI ABONO LA
																								// MATRICULA

					Calendar fechaPago = null;

					if (pago == true) {
						fechaPago = Validador.leerFecha();
						((Alumno) cursos.get(posCurso).getInscripciones().get(i).getAlumno()).setFechaPago(fechaPago);
						System.out.println("Estoy dentro del if del pago.\nFecha de matricula: "+Validador.formatoFecha(fechaPago)+"\nFecha de inicio del curso: "+Validador.formatoFecha(cursos.get(posCurso).getFechaInicio()));
						System.out.println("Fecha hace dos dias: "+Validador.formatoFecha(dosDias));
						if (fechaPago.before(dosDias)) { // si la fecha de pago es anterior a la fecha de hace dos dias
							cursos.get(posCurso).setInscripciones(fechaInscripcion, observacion, controlPersonas.getPersonas().get(posicionAlumno), i); // agrego
																															// la
																															// inscripcion

							inscripcion = i; // me guardo la posicion de inscripcion para enviarla al txt
							cursos.get(posCurso).getInscripciones().get(i).setAceptada(true); // Termine el proceso y acepto
							System.out.println("Inscripcion Exitosa :-) ");
							break;
						}
					}
					break;
				}
			}

			if (cursos.get(posCurso).getInscripciones().get(inscripcion).isAceptada() == true) {
				try {
					Modelo.crearRegistros(cursos.get(posCurso), inscripcion);// guardarlo en registros TXT, envio el curso
																			// al cual inscribo
					// y la posicion de inscripcion
					// que hice
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else {
				vista.mostrarTexto("NO fue aceptada su inscripcion");
			}
		} else {
			vista.mostrarTexto("No hay cursos o alumnos cargados en el sistema");
		}
	}

	public void ControlarAsistencia() {
		int posCurso = -1;

		boolean existeCurso = false;
		boolean existeAlumno = false;

		vista.mostrarTexto("Ingrese codigo de curso");
		int codigo = Validador.leerInt(1);

		do {
			if (cursos.isEmpty() == false) { // compruebo que al menos hay 1

				if (ControlCursos.buscarCurso(codigo, cursos) > -1) {
					posCurso = ControlCursos.buscarCurso(codigo, cursos);

					for (int i = 0; i < cursos.get(posCurso).getClases().size(); i++) { // recorro las clases del curso que
			
						if (cursos.get(posCurso).getClases().get(i).getNumeroClase() != 0) {
							vista.mostrarTexto("Clase" + (i+1));
																					// indique

						for (int j = 0; j < cursos.get(posCurso).getClases().get(i).getAsistencias().size(); j++) { // recorro
																										// las
																											// asistencias
						if (cursos.get(posCurso).getClases().get(i).getAsistencias().get(j).getAlumno() != null) {						
							
							vista.mostrarTexto("Alumno: "+cursos.get(posCurso).getClases().get(i).getAsistencias().get(j).getAlumno().getApellido() + " "
									+ cursos.get(posCurso).getClases().get(i).getAsistencias().get(j).getAlumno().getNombre());

							vista.mostrarTexto("1. Presente  2. Ausente");
							int opcion = Validador.ElegirInt(0, 3);
							boolean presente = (opcion == 1 ? true : false);

							cursos.get(posCurso).getClases().get(i).getAsistencias().get(j).setPresente(presente);

							try {
								Modelo.agregarAsistencia(cursos.get(posCurso), i, j);// le paso el curso, la posicion de la
																					// clase, y la posicion de la
																					// asistencia que agregue
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
						}else {
							vista.mostrarTexto("No hay mas alumnos para tomar asistencia");
							break;
						}	}
					}else{
						vista.mostrarTexto("No hay mas clases cargadas en sistema");
						break;
					}	}
					existeCurso = true;
				} else {
					vista.mostrarTexto("No existe ese codigo del curso, vuelva a ingresar");
					codigo = Validador.leerInt();
				}
			} else {
				vista.mostrarTexto("No hay cursos cargados");
			}

		} while (existeCurso = false);
	}

	public void agregarTemas() {
		int posCurso = -1;

		boolean existeCurso = false;
		boolean existeAlumno = false;

		vista.mostrarTexto("Ingrese codigo de curso");
		int codigo = Validador.leerInt(1);

		do {
			if (cursos.isEmpty() == false) { // compruebo que al menos hay 1

				if (ControlCursos.buscarCurso(codigo, cursos) > -1) {
					posCurso = ControlCursos.buscarCurso(codigo, cursos);

					for (int i = 0; i < cursos.get(posCurso).getClases().size(); i++) { // recorro las clases del curso que
																					// indique

						vista.mostrarTexto("Ingrese fecha");
						Calendar fecha = Validador.leerFecha();

						vista.mostrarTexto("Tipo de clase");
						vista.mostrarTexto("1. Teorico	2.Practico	3.Evaluativo");
						int clase = Validador.leerInt(1, 3);

						String TipoClase = null;

						switch (clase) {
						case 1:
							TipoClase = "Teorico";
							break;
						case 2:
							TipoClase = "Practico";
							break;
						case 3:
							TipoClase = "Evaluativo";
							break;
						}

						vista.mostrarTexto("Ingrese tema dado");

						String temaDado = Validador.leerString(false);

						cursos.get(posCurso).setClases(TipoClase, temaDado, i, (i + 1), fecha);

						try {
							Modelo.agregarTema(cursos.get(posCurso), i);// le paso el curso, la posicion de la clase
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}

					}
					existeCurso = true;
				} else {
					vista.mostrarTexto("No existe ese codigo del curso, vuelva a ingresar");
					codigo = Validador.leerInt();
				}
			} else {
				vista.mostrarTexto("No hay cursos cargados");
			}
			
			for (int i=0; i < cursos.get(posCurso).getClases().size();i++) {
				vista.mostrarTexto("Tema dado en la clase "+(i+1) +" "+ cursos.get(posCurso).getClases().get(i).getTemas());
			}

		} while (existeCurso = false);
	}

	public void resumenPresentismo() {

		for (Curso c : cursos) { // recorro los cursos
			int totalClases = c.getClasesTotal();
			int totalPresentes = 0;
			int iClase = 0;

			for (int i = 0; i < c.getAlumnosInscriptos().size(); i++) { // recorro los alumnos
				if (c.getAlumnosInscriptos().isEmpty() == false ) {
					
					for (int j = 0; j < c.getClases().size(); j++) { // recorro las clases
						iClase = j;
						if (c.getClases().get(j) != null) {
							
							for (int a = 0; a < c.getClases().get(j).getAsistencias().size(); a++) { // recorro asistencias de cada clase																							
							
								if(c.getClases().get(j).getAsistencias().get(a)!= null) {

									if (c.getAlumnosInscriptos().get(i).getDni() == c.getClases().get(j).getAsistencias().get(a)
											.getAlumno().getDni()) { // busco al alumno

										if (c.getClases().get(j).getAsistencias().get(a).getPresente() == true) {
											totalPresentes++; // Si esta presente sumo 1
										}
										break;
									}
								}
								System.out.println("total presentes de " + c.getAlumnosInscriptos().get(i).getNombre()
										+ " = " + totalPresentes++);
							}

						}

					}
					int minimoAsistencia = (70 * totalClases) / 100; // calculo el 70% de asistencias

					if (totalPresentes < minimoAsistencia) { // si no cumple le paso al JSON los datos para guardar
						try {
							Modelo.ControlAsistencia(c, c.getAlumnosInscriptos().get(i), iClase);// le paso el curso
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}
	}

	public void librosTemas() {
		vista.mostrarTexto("Ingrese nombre de una materia");
		String materia = Validador.leerString(false);

		for (Curso c : cursos) { // recorro cursos
			if (c.getMateria().getNombre().equalsIgnoreCase(materia)) { // si la materia ingresada coincide con la
																		// materia del curso
				for (int i = 0; i < c.getClases().size() ; i++) { // recorro las clases del curso

					if (c.getClases().get(i).getTemas() != null) {
						vista.mostrarTexto("Temas dados: " + c.getClases().get(i)
								.getTemas()); // muestro los temas de la
																							// clase
					} else {
						vista.mostrarTexto("No se han registrados temas");
						break;
					}
				}
			}
		}
	}

	public void controlDeAsistencia(String[] args) {

		for (String num : args) { // recorro los numeros que tengo como arg de aplicacion
			int arg = Integer.parseInt(num); // los paso a entero porque vienen como String

			for (Curso c : cursos) { // recorro los cursos

				if (c.getNumero() == arg) { // si el numero de curso coincide

					int totalClases = c.getClasesTotal();
					int totalPresentes = 0;
					double porcentajeAsistencia = 0;

					for (int i = 0; i < c.getAlumnosInscriptos().size(); i++) { // recorro los alumnos
						for (int j = 0; j < c.getClases().size(); j++) { // recorro las clases
							for (int a = 0; a < c.getClases().get(j).getAsistencias().size(); a++) { // recorro asistencias
																								// de cada clase
								if (c.getAlumnosInscriptos().get(i).getDni() == c.getClases().get(j).getAsistencias().get(a)
										.getAlumno().getDni()) { // busco al alumno
									if (c.getClases().get(j).getAsistencias().get(a).getPresente() == true) {
										totalPresentes++; // Si esta presente sumo 1
									}
									break;
								}

							}
						}

						porcentajeAsistencia = (totalPresentes * 100) / totalClases; // calculo el % de asistencias
						vista.mostrarTexto("El porcentaje de asistencia de: "
								+ c.getAlumnosInscriptos().get(i).getApellido() + " es " + porcentajeAsistencia + " %");
					}

				}

			}
		}

	}

	public void alumnosSinCursar() {
		boolean inscripto = false;

		for (Persona p : controlPersonas.getPersonas()) {
			if (p instanceof Alumno) { // recorro los alumnos
				inscripto = false;
				for (Curso c : cursos) { // recorro el curso

					if (c != null) {

						if (c.getFechaInicio().YEAR == Calendar.getInstance().YEAR) { // si el aï¿½o de inicio es igual
																						// a el
																						// aï¿½o actual
							for (int j = 0; j < c.getAlumnosInscriptos().size(); j++) { // recorro los alumnos
																						// inscriptos en el curso

								if (c.getAlumnosInscriptos().isEmpty() == false ) {
									if (p.getDni() == c.getAlumnosInscriptos().get(j).getDni()) { // si el alumno esta
																								// inscripto
										inscripto = true; // pongo el true
									}
								}
							}
						}

					}
				}

				if (inscripto == false) { // si el bool termina en false no esta inscripto
					vista.mostrarTexto("nombre: " + p.getNombre());
					vista.mostrarTexto("DNI " + p.getDni());
				}
			}
		}
	}

	public void mujeres() {
		int alumnas = 0;
		int promedioInscriptos = 0;
		int contadorCursos = 0;
		int contadorAlumnos = 0;
		int contadorCursosFinal = 0;

		for (Curso c : cursos) {
			if (c != null) {
				contadorCursos++;

				for (int i = 0; i < c.getAlumnosInscriptos().size(); i++) { // recorro los alumnos inscriptos
					if (c.getAlumnosInscriptos().isEmpty() == false) {
						if (c.getAlumnosInscriptos().get(i).getSexo() == 'F') { // si son mujeres sumo
							alumnas++;
						}
					}
				}

				for (int i = 0; i < c.getAlumnosInscriptos().size(); i++) { // recorro los alumnos inscriptos
					if (c.getAlumnosInscriptos().get(i) != null) {
						contadorAlumnos++;
					}
				}

			}

			promedioInscriptos = contadorAlumnos / contadorCursos;

			if (alumnas > promedioInscriptos) {
				contadorCursosFinal++;
			}

		}

		vista.mostrarTexto(
				"Cantidad de cursos donde la cantidad de alumnas mujeres supera el promedio de inscriptos es "
						+ contadorCursos);

	}

	public void profesoresVirtuales() {
		int alumnos = 0;

		for (Persona p : controlPersonas.getPersonas()) {

			if (p != null) {

				if (p instanceof Docente) {
					alumnos = 0;
					for (Curso c : cursos) {
						if (c != null) {
							if (c.getMateria().getDocente().getDni() == p.getDni()) {
								if ((c.getMateria() instanceof Distancia)
										&& (((Docente) p).getAnioIngreso() < (Calendar.getInstance().YEAR - 3))) {
									for (int i = 0; i < c.getAlumnosInscriptos().size(); i++) {
										if (Validador.edad(c.getAlumnosInscriptos().get(i).getFechaNac()) < 35) {
											alumnos++;
										}
									}
								}

							}
						}
					}

					vista.mostrarTexto(
							"Docente " + p.getApellido() + "   Cantidad de alumnos con menos de 35 años " + alumnos);
				}
			}
		}

	}

	public void guardarCursosCompletos() {
		// TODO Auto-generated method stub
		// numero curso , nombre de la materia, turno. fecha inicio de clases.
		// plataforma.
		boolean asistencias = true;

		// año lectivo generado al azar
		Random aleatorio = new Random();
		int anioAzar = 2000+ aleatorio.nextInt( (Calendar.getInstance().DAY_OF_YEAR+1) - 2000); //entre el 2000 y el año actual

		for (Curso c : cursos) {
			boolean distancia = false;

			if (c != null) {
				if (c.getAno() == anioAzar) {

					for (int i = 0; i < c.getClases().size(); i++) { // recorro la clase
						for (int j = 0; j < c.getClases().get(i).getAsistencias().size(); j++) { // recorro las asistencias
							if (c.getClases().get(i).getAsistencias().get(j).getPresente() == false) { // verifico las
																								// asistencias
								asistencias = false;
								break;
							}
						}

						if (asistencias == true) {
							if ((c.getMateria() instanceof Distancia)) {
								distancia = true;
							}

							try {
								Modelo.AgregarCursoCompleto(c, distancia);// le paso el curso
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}

						}

					}
				}
			}
		}
	}
	
	public void calificaciones() {
		/* 
		 * considerando que la cursada del mismo se aprueba cuando el promedio de las 
calificaciones (mínimo 2) obtenidas sea a partir de 6, junto con el 76% del presentismo. 

Pero, para aprobar una materia es requisito la rendición de un examen final, donde el 
alumno tiene 3 oportunidades para realizarlo. Ciertas materias, pueden ser promocionadas 
si el promedio alcanza los 9 puntos. Esta información está incluida en el archivo 
Materias.txt.
		 */
		
		
		
		
		
	}

	public void guardarPresentismo() {
		// Para cada materia dictada, incluir el número de curso, año lectivo y el
		// porcentaje total de asistencia en el archivo Presentismo.csv (separado por
		// “;”).
		for (int i = 0; i < controlMaterias.getMaterias().size(); i++) {
			for (int j = 0; j < cursos.size(); j++) {

				int contadorPresente = 0;
				
				if (cursos.get(j).getMateria().getCodigo() == controlMaterias.getMaterias().get(i).getCodigo()) {

					for (int p = 0; p < cursos.get(j).getClases().size(); p++) {
						for (int a = 0; a < cursos.get(j).getClases().get(p).getAsistencias().size(); a++) {
							if (cursos.get(j).getClases().get(p).getAsistencias().get(a).getPresente() == true) {
								contadorPresente++;
							}

						}
						double asistencia = contadorPresente * 100 / cursos.get(j).getClasesTotal();

						try {
							Modelo.agregarPresentismo(cursos.get(j), asistencia);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}