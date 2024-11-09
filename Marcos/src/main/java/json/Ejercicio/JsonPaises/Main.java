package json.Ejercicio.JsonPaises;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import daw.com.Teclado;


public interface Main {

	final static Consumer<String> ESCRIBELO = System.out::println;
	
	public static void main(String[] args) {
		
		List<Pais>paises = null;
		
		try {
			//Lectura
			Gson gsonlector = new Gson();
			TypeToken<List<Pais>> paisLista = new TypeToken<List<Pais>>(){}; // hay que usarlo porque empieza siendo []
			Reader reader = new FileReader("./paises.json"); //Leer este archivo
			paises = gsonlector.fromJson(reader,paisLista); // almacenar 
			
			//Escritura
			Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create(); // para escribir json bonito
			String json= gsonBuilder.toJson(paises); // lo almacenanos en un String
			System.out.println(json);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("error fichero no encontrado: " + e );
		}
		
		System.out.println("\nMostrar ciudades importantes de españa que empiezan por \"M\"");
		paises.stream()
		.filter(pais->"España".equalsIgnoreCase(pais.getNombre()))
		.flatMap(importante-> importante.getCiudadImportante().stream())
		.filter(ciudad-> ciudad.startsWith("M"))
		.forEach(ESCRIBELO);
		
		System.out.println("\n----------------------------------------");
		System.out.println("\nMostrar nombre de todas los paises,orden alfabetico inverso");
		paises.stream()
		.map(Pais::getNombre)
		.distinct() //elimina repetidos "Tailandia"
		.sorted(Comparator.reverseOrder())
		.forEach(ESCRIBELO);
		
		System.out.println("\n----------------------------------------");
		System.out.println("\nMostrar ciudad Cali");
		paises.stream()
		.filter(p -> "Colombia".equalsIgnoreCase(p.getNombre()))
		.flatMap(t -> t.getCiudadImportante().stream())
		.filter(t -> "Cali".equalsIgnoreCase(t))
		.forEach(ESCRIBELO);
		
		System.out.println("\n________________________________________");
		System.out.println("\nPedir por consola ciudad y que muestre nombre del pais");
		String res = Teclado.leerString("Nombre de la ciudad solicitada: ");
		paises.stream()
		.filter(pais->pais.getCiudadImportante().contains(res))
		.findFirst()
		.ifPresentOrElse(
				pais -> ESCRIBELO.accept("La ciudad " + res + " pertenece a: " + pais.getNombre()),
                () -> ESCRIBELO.accept("No se encontró un país que contenga la ciudad: " + res)
                );

	}
}
