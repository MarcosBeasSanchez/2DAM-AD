package json.Ejercicio.JsonProvincias;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

public class Localidad {
	@SerializedName(value="_c")
	private String c;
	@SerializedName(value="__cdata")
	private String cdata;

}
