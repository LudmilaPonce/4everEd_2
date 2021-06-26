package validador;

/*
 * Esta clase contiene m�todos est�ticos
 * para ingreso y validaci�n de datos,
 * selecci�n de opciones, formatos
 * y otros m�todos de uso general
 * */

import java.util.Calendar;
import java.util.Scanner;

public abstract class Validador {
	
	private static Scanner in = new Scanner(System.in);
	
	// Lee una entrada del teclado y valida que sea un n�mero entero
	public static int leerInt() {
		int num;
		while(!in.hasNextInt()) {
			System.out.print("Debe ser un entero: ");
			in.nextLine();
		}
		num = in.nextInt();
		in.nextLine();
		return num;
	}
	
	public static long leerLong() {
		long num;
		while(!in.hasNextLong()) {
			System.out.print("Debe ser un entero: ");
			in.nextLine();
		}
		num = in.nextLong();
		in.nextLine();
		return num;
	}
	
	// Lee una entrada del teclado y valida que sea un n�mero entero
	// mayor o igual a min
	public static int leerInt(int min) {
		int num = leerInt();
		while(num < min) {
			System.out.print("Debe ser al menos " + min + ": ");
			num = leerInt();
		}
		return num;
	}
	
	// Lee una entrada del teclado y valida que sea un n�mero entero
	// comprendido entre min y max
	public static int ElegirInt(int min, int max) {
		int num = leerInt();
		while(num == min || num == max) {
			System.out.print("Debe ser " + min + " o " + max + ": ");
			num = leerInt();
		}
		return num;
	}
	
	public static int leerInt(int min, int max) {
		int num = leerInt();
		while(num < min || num > max) {
			System.out.print("Debe estar entre " + min + " y " + max + ": ");
			num = leerInt();
		}
		return num;
	}
	
	// Lee una entrada del teclado y valida que sea un n�mero entero
	// no menor que cero
	public static int leerIndice() {
		return leerInt(0);
	}
	
	// Lee una entrada del teclado y valida que sea un n�mero entero
	// no menor que cero y menor que tam
	public static int leerIndice(int tam) {
		return leerInt(0, tam-1);
	}
	
	// Lee una entrada del teclado y valida que sea un n�mero
	public static double leerDouble() {
		double num;
		while(!in.hasNextDouble()) {
			System.out.print("Debe ser un n�mero: ");
			in.nextLine();
		}
		num = in.nextDouble();
		in.nextLine();
		return num;
	}
	
	// Lee una entrada del teclado y valida que sea un n�mero
	// comprendido entre min y max
	public static double leerDouble(double min, double max) {
		double num = leerDouble();
		while(num < min || num > max) {
			System.out.print("Debe estar entre " + min + " y " + max + ": ");
			num = leerDouble();
		}
		return num;
	}
	
	
	
	
	// Lee una entrada del teclado y valida que sea un n�mero
	// mayor o igual a min
	public static double leerDouble(double min) {
		double num = leerDouble();
		while(num < min) {
			System.out.print("Debe ser al menos " + min + ": ");
			num = leerDouble();
		}
		return num;
	}
	
	// Lee texto del teclado. 
	// Si vacio es true acepta un texto vacio,
	// de lo contrario lo solicita nuevamente
	public static String leerString(boolean vacio) {
		String str = in.nextLine();
		while(!vacio && str.isEmpty()) {
			System.out.print("No puede estar vac�o: ");
			str = in.nextLine();
		}
		return str;
	}

	// Lee d�a, mes y a�o del teclado
	// y retorna una fecha
	public static Calendar leerFecha() {
		System.out.print("D�a: ");
		int d = leerInt(1, 31);
		System.out.print("Mes: ");
		int m = leerInt(1, 12) - 1;
		System.out.print("A�o: ");
		int a = leerInt();
		Calendar date = Calendar.getInstance();
		date.set(a, m, d);
		return date;
	}

	// Lee d�a, mes y a�o del teclado
	// entre los a�os desde y hasta
	// y retorna una fecha 
	public static Calendar leerFecha(int desde, int hasta) {
		System.out.print("D�a: ");
		int d = leerInt(1, 31);
		System.out.print("Mes: ");
		int m = leerInt(1, 12) - 1;
		System.out.print("A�o: ");
		int a = leerInt(desde, hasta);
		Calendar date = Calendar.getInstance();
		date.set(a, m, d);
		return date;
	}

	// Lee d�a, mes y a�o del teclado
	// entre el a�o desde y el a�o actual
	// y retorna una fecha 
	public static Calendar leerFecha(int desde) {
		return leerFecha(desde, Calendar.getInstance().get(Calendar.YEAR));
	}

	// Retorna un string con formato dd/mm/aaaa a partir de Calendar
	public static String formatoFecha(Calendar fecha) {
		return String.format("%02d/%02d/%4d", fecha.get(Calendar.DATE), fecha.get(Calendar.MONTH)+1,fecha.get(Calendar.YEAR));
	}
	
	// Retorna Calendar a partir de un string con formato dd/mm/aaaa
	public static Calendar formatoFecha(String fecha) {
		Calendar calendar = Calendar.getInstance();
		String[] dma = fecha.split("/");
		int d = Integer.parseInt(dma[0]);
		int m = Integer.parseInt(dma[1]) - 1;
		int a = Integer.parseInt(dma[2]);
		calendar.set(a, m, d);
		return calendar;
	}

	// Retorna la cantidad de a�os completos transcurridos
	// desde la fecla del par�metro hasta hoy
	public static int edad(Calendar desde) {
		Calendar hoy = Calendar.getInstance();
		int a = hoy.get(Calendar.YEAR) - desde.get(Calendar.YEAR);
		int m = hoy.get(Calendar.MONTH) - desde.get(Calendar.MONTH);
		if(m < 0 || (m == 0 && hoy.get(Calendar.DATE) < desde.get(Calendar.DATE))) {
			a--;
		}
		return a;
	}
	
	// Lee las opciones op1 y op2 de un �nico car�cter
	// aceptando may�scula y min�scula.
	// Retorna y valida la opci�n elegida.
	public static String leerOpcion(String op1, String op2) {
		return leerOpcion(new String[] { op1, op2 });
	}
	
	// Lee las opciones de un �nico car�cter
	// aceptando may�scula y min�scula.
	// Retorna y valida la opci�n elegida en may�scula.
	public static String leerOpcion(String[] opciones) {
		String opcion =  in.nextLine();
		while((opcion = buscarOpcion(opcion, opciones)) == null) {
			System.out.println ("Debe ser " + listaOpciones(opciones) + ": ");
			opcion = in.nextLine();
		}
		return opcion.toString();
	}
	
	// Busca una opci�n entre las opciones
	// y la retorna si la hall� o null si no.
	private static String buscarOpcion(String opcion, String[] opciones) {
		int i = opciones.length;
		while(--i >= 0 && opciones[i].compareToIgnoreCase(opcion) != 0);
		return i < 0 ? null : opciones[i];
	}
	
	// Retorna un String con la lista de opciones separadas por comas
	public static String listaOpciones(String[] opciones) {
		StringBuffer sb = new StringBuffer(opciones[0]);
		int i = 0;
		while(++i < opciones.length - 1) {
			sb.append(", " + opciones[i]);
		}
		sb.append(" o " + opciones[i]);
		return sb.toString();
	}

	// Lee y valida las opciones S y N
	// y retorna true si se eligi� S
	public static boolean leerSiNo() {
		return leerOpcion("S", "N").equalsIgnoreCase("S");
		
	}
	
	public static boolean leerPago(String rta) {
		boolean respuesta=false;
		
		if(rta.equalsIgnoreCase("True")) {
			respuesta = true;
		}else {
			respuesta=false;
		}
		return respuesta;
	}
	
	// Pide, valida y retorna una opci�n entre F y M
	public static String leerSexo() {
		System.out.print("Sexo (F/M): ");
		return leerOpcion("F", "M");
	}

}
