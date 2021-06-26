package Modelo.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import Modelo.Curso;
import Modelo.Persona;
import validador.Validador;
public class AusentesJSON implements Datos {

//ausentes.JSON
//	nombreAlumno	apellidoAlumno	nombreMateria	numeroClase 		fechaClase
	
	private static final String Ausentes = path + "Ausentes.json";
	
	
	public static void controlAsistencia(Curso c, Persona alumno, int num)  throws FileNotFoundException { // genera un array de ausencias
		File file = new File(Ausentes);
		FileOutputStream stream = new FileOutputStream(file, true);
		
		JsonObjectBuilder builder = Json.createObjectBuilder();// crea un objeto
		
		JsonArrayBuilder array = Json.createArrayBuilder(); //crea un array
		
	
		builder.add("Ausentes", array.build());
	//	array.add(agregarControlAsistencia(c, alumno, num)); //agrego el objeto al array
		
		JsonWriter jsonWriter = Json.createWriter(stream);
        jsonWriter.writeObject(builder.build());
        jsonWriter.close();
		
	}
	
	public static void agregarControlAsistencia(Curso c, Persona alumno, int num) throws FileNotFoundException {
	
		File file = new File(Ausentes);
		FileOutputStream stream = new FileOutputStream(file, true);
		
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("nombre", alumno.getNombre());
		builder.add("apellido", alumno.getApellido());
		builder.add("materia", c.getMateria().getNombre());
		builder.add("numeroClase", c.getClases().get(num).getNumeroClase());
		builder.add("fechaClase", Validador.formatoFecha(c.getClases().get(num).getFecha()));
		
		JsonWriter jsonWriter = Json.createWriter(stream);
        jsonWriter.writeObject(builder.build());
        jsonWriter.close();
	}
}