package json.Ejemplo;

import java.time.LocalDate;
import java.util.List;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)

public class Empleado {
	//tipo basico
	private String id;
	private String nombre;
	@SerializedName(value="departamento") //nombre se salida para 
	private String dept;
	private float sueldo;
	//Tipos complejos
	@JsonAdapter(LocalDateTexto.class) //adaptador de la clase
	private LocalDate fecha;

}
