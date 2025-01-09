package bbdd.prueba.ejercicio1;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Alumno {
	
	private String nia;
	private String nombre;
	private LocalDate fechaNacimiento;
	private boolean beca;

}
