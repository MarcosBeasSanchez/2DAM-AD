package csv.Ejercicio.Instituto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.opencsv.bean.CsvDate;

import csv.Ejercicio.EmpleYDep.profe.OptionalToText;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona {
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 0)
	private String nif;

	@CsvBindByPosition(position = 1)
	private String nombre; // Añadir esta línea para manejar el nombre en Persona

	@CsvBindByPosition(position = 2)
	@CsvDate("yyyy-MM-dd")
	private LocalDate fechaNacimiento;

	@CsvBindAndSplitByPosition(position = 3, 
	elementType = Contacto.class, // tipo de elemento de la colección
	splitOn = "ç", // Separador de Contactos
	converter = ContactotoText.class, // Clase convertidora
	writeDelimiter = "ç")
	@Singular
	List<Contacto> contactos;
	
	@CsvCustomBindByPosition(position=4,converter=TextToOptionalVehiculo.class)
	//@Builder.Default
	private Optional<Vehiculo> vehiculo;

}
