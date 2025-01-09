package json.Ejercicio.JsonPaises;

import java.util.List;

import com.google.gson.annotations.JsonAdapter;

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

public class Pais {
	
	private String nombre;
	@JsonAdapter(EnumContinenteAdapter.class)
	private Continente continente;
	private String capital;
	private String textoCapital;
	private List<String>ciudadImportante;

}
