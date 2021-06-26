package Modelo.DAO;

import java.io.*;
import java.util.*;
import javax.json.*;

import Modelo.Alumno;
import Modelo.Docente;
import Modelo.Persona;
import validador.Validador;

public class PersonasJSON implements Datos  {
	
	private static final String docentes = path + "Docente.JSON";
	private static final String alumnos = path + "Alumnos.JSON";
	
	private static ArrayList<Persona> listaPersonas = new ArrayList<>();
	
	public static ArrayList<Persona> getListaPersonas() {
		return listaPersonas;
	}
	
//	Personas.JSON
//	dni	nombre	apellido	sexo	nacimiento	matriculaAlumno tituloProfe a�oTitulo  lugarTitulo

	public static ArrayList<Persona>  leerPersonas()  throws FileNotFoundException { //lee los docentes completos
		
		File aJson = new File(docentes);
		FileInputStream fsInJSon = new FileInputStream(aJson);
		
		JsonReader rdrJson = Json.createReader(fsInJSon);
		JsonObject objJson = rdrJson.readObject();

		JsonArray personas = objJson.getJsonArray("persona"); //creo un array de personas
		
			int index = 0;
			
			for(int i=0 ; i < personas.size();i++) { //lleno el array con los datos
				Persona persona= new Docente();
				JsonObject objsonPersona = personas.getJsonObject(i);
				((Docente)persona).setNombre(objsonPersona.getString("nombre"));		
				persona.setDni(objsonPersona.getInt("dni"));
				persona.setApellido(objsonPersona.getString("apellido"));
				persona.setSexo(objsonPersona.getString("sexo").charAt(0));
				persona.setFechaNac(Validador.formatoFecha(objsonPersona.getString("nacimiento")));
				
				JsonArray jsonArray = objsonPersona.getJsonArray("titulos");
				int indexT = 0;

				if(jsonArray!= null) {
				for(int t=0 ; t < jsonArray.size();t++) { //composicion
					JsonObject objsonTitulos = jsonArray.getJsonObject(t);			
					((Docente)persona).setTitulos(indexT, objsonTitulos.getString("titulo"),Integer.parseInt(objsonTitulos.getString("anio")), objsonTitulos.getString("lugar"));		
					indexT++;
				}		
				}		
				
			listaPersonas.add(persona);
			}
			
			leerPersonasAlumnos(); //llama a la funcion que agrega a los alumnos al array
			return listaPersonas;
		
	}
	
	public static void leerPersonasAlumnos()  throws FileNotFoundException { //lee los alumnos completos
	
		File aJson = new File(alumnos);
		FileInputStream fsInJSon = new FileInputStream(aJson);
		
		JsonReader rdrJson = Json.createReader(fsInJSon);
		JsonObject objJson = rdrJson.readObject();

		JsonArray personas = objJson.getJsonArray("persona");
		
		int index = 0;

		for(int i=0 ; i < personas.size();i++) { //composicion
			Persona persona= new Alumno();
			JsonObject objsonPersona = personas.getJsonObject(i);
			((Alumno)persona).setNombre(objsonPersona.getString("nombre"));		
			persona.setDni(objsonPersona.getInt("dni"));
			persona.setApellido(objsonPersona.getString("apellido"));
			persona.setSexo(objsonPersona.getString("sexo").charAt(0));
			persona.setFechaNac(Validador.formatoFecha(objsonPersona.getString("nacimiento")));
			((Alumno)persona).setPago(Validador.leerPago(objsonPersona.getString("pago")));			
			((Alumno)persona).setFechaPago(Validador.formatoFecha(objsonPersona.getString("fechaPago")));				
	
		listaPersonas.add(persona);
		}
		
	}
	
	public static Persona  leerPersona()  throws FileNotFoundException { //LEE 1 solo objeto
		File aJson = new File(docentes);
		FileInputStream fsInJSon = new FileInputStream(aJson);
		
		JsonReader rdrJson = Json.createReader(fsInJSon);
		JsonObject objJson = rdrJson.readObject();
		
		Persona persona= new Docente();
	
		persona.setDni(objJson.getInt("dni"));
		persona.setNombre(objJson.getString("nombre"));
		persona.setApellido(objJson.getString("apellido"));
		persona.setSexo(objJson.getString("sexo").charAt(0));
		persona.setFechaNac(Validador.formatoFecha(objJson.getString("nacimiento")));
		
		JsonArray jsonArray = objJson.getJsonArray("titulos");
		int index = 0;

		if(jsonArray!= null) {
		for(int i=0 ; i < jsonArray.size();i++) { //composicion
			JsonObject objsonTitulos = jsonArray.getJsonObject(i);			
			((Docente)persona).setTitulos(index, objsonTitulos.getString("titulo"),Integer.parseInt(objsonTitulos.getString("anio")), objsonTitulos.getString("lugar"));		
			index++;
		}		
		}
		return persona;		
		}
	
}
