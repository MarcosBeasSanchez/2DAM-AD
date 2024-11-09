package json.Ejercicio.JsonProvincias;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Nombre {
	@SerializedName(value="__cdata")
	private String nombre;

}
