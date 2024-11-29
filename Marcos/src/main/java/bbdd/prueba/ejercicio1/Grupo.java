package bbdd.prueba.ejercicio1;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Grupo {
	@EqualsAndHashCode.Include
	@NonNull
	private String nombre;
	private String tutor;
	private int curso;
	@Singular 
	private List<Alumno>alumnos;
}
