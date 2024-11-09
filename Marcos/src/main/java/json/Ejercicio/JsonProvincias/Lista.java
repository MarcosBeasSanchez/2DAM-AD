package json.Ejercicio.JsonProvincias;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Lista {
	
	@SerializedName("provincia")
	private List<Provincia>provincias;

}
