package json.Ejercicio.JsonProvincias;

import java.util.List;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Localidades {
	
	@Singular
	@SerializedName(value="localidad")
	private List<Localidad>localidades;
	
	

	public void addLocalidad(Localidad localidad) {

		localidades.add(localidad);
	}
	
	 public List<Localidad> getLocalidades() {
	        return localidades;
	    }
	 



}
