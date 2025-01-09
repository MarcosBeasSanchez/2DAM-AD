package examen1.carreras;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.io.Reader;
import java.time.LocalTime;

import com.opencsv.bean.CsvToBeanBuilder;

public class AppCarreras {

	private static final Consumer<Object>ESCRIBELO = System.out::println;
	
	public static void main(String[] args) {
		List<Carrera> carreras = leerCarreras();
		System.out.println(carreras);
		
		//no me da tiempo a hacer las query
		System.out.println("\nQuery 1:Mostrar nombre de las carreras las cuales el no se haya gastado el cupo de corredores");
		carreras.stream().filter(t -> t.getCorredores().size() < t.getCupoCorredores())
		.map(Carrera::getNombre)
		.collect(Collectors.toList())
		.forEach(ESCRIBELO);
		
		System.out.println("\nQuery 2:Nombre y edad de corredores, que han realizado carreras de mas de 2000m en menos de 1H:30M:00S");
		carreras.stream()
		  .filter(t -> t.getMetros() > 2000)
		  .flatMap(c -> c.getCorredores().stream())
		  .filter(t -> t.getTiempo().isBefore(LocalTime.of(01, 30, 00)))
		  .map(t -> t.getNombre() + " , " + t.getEdad())
		  .forEach(System.out::println); 
		
		System.out.println("\nQuery 3:Listado de los dni de corredores que han participado en mas de una carrera");
		Map<String, Long> dniCount = carreras.stream()  //todas las carreras
				.flatMap(c -> c.getCorredores().stream()) // todos los corredores
				.map(Corredor::getDni) // todos dni
				.collect(Collectors.groupingBy(dni -> dni, Collectors.counting())); 
		//Lista de todos los dni con sus apariciones 
		System.out.println(dniCount);
		
		dniCount.entrySet().stream()
        .filter(entry -> entry.getValue() > 1)  // Solo los que han participado en más de una carrera
        .map(Map.Entry::getKey)  // Obtenemos solo el DNI
        .forEach(ESCRIBELO);
		
	}

	private static List<Carrera> leerCarreras() {
		List<Carrera>beans = null;
		try {
			FileReader reader = new FileReader("carrera.csv");
			beans = new CsvToBeanBuilder((reader))
			.withType(Carrera.class)
			.withSeparator(',')
			.build()
			.parse(); //stream
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return beans;
	}

	

}
