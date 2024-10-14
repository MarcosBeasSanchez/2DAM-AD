package ejercicio.institutoOpencsv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class AppInsituto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Instituto> departamentos = cargarDatosCSV();
		departamentos.forEach(System.out::println);

		// guardarDatosCSV(departamentos);
	}

	private static List<Instituto> cargarDatosCSV() {
	    List<Instituto> departs = new ArrayList<>();
	    try {
	        // Crear el parser con separador ':'
	        departs = new CsvToBeanBuilder<Instituto>(new FileReader("instituto.csv"))
	                .withType(Instituto.class)
	                .withSeparator(':') // Separador personalizado
	                .build()
	                .parse();
	    } catch (IllegalStateException | FileNotFoundException e1) {
	        System.out.println("Error leyendo fichero: " + e1.getMessage());
	    }

	    return departs;
	}


	private static void guardarDatosCSV(List<Instituto> departamentos) {
		// TODO Auto-generated method stub

	}

}
