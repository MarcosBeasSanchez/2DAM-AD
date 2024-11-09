package json.Ejercicio.JsonProvincias;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Root {
	
	@SerializedName("lista")
	private   Lista lista;

}
