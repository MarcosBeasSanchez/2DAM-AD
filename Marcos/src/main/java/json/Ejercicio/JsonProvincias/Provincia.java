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

public class Provincia {
	
	@SerializedName(value="nombre")
	private Nombre nombre;
	
	@SerializedName(value="localidades")
	private Localidades localidades;
	
	@SerializedName(value="_id")
	private String id;
	
	

}
