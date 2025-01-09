package json.Ejercicio.JsonToXml3;

import java.util.List;
import java.util.function.Consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import json.Ejemplo.LocalDateAdapter;
import xml.Ejercicio.Cartelera.profe.Pelicula;

import java.io.*;
import java.time.LocalDate;

public class AppImbd {
	
	private final static Consumer<Object>ESCRIBIDOR=System.out::println;
	
public static void main(String[] args) {
	
	List<Movie>pelis = null;
	
	try {
		//LECTOR
		Reader reader = new FileReader("imbd.json");
		Gson gsonLector = new GsonBuilder()
				.registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
				.registerTypeAdapter(new TypeToken<List<Genres>>(){}.getType(), new GenresAdapter())
				.create();
		TypeToken<List<Movie>> listaPelis = new TypeToken<List<Movie>>() {};
		pelis = gsonLector.fromJson(reader, listaPelis);
		
		//ESCRITURA sin formato;
		pelis.forEach(ESCRIBIDOR);
		
		//ESCRITURA 
		Gson gsonEscribidor = new GsonBuilder().setPrettyPrinting().create();
		String json = gsonEscribidor.toJson(pelis);
		System.out.println(json);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	
}
}
