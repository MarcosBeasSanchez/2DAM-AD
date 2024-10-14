package ejercicio.institutoOpencsv;

import java.util.List;

import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Contacto {
	private static final String SEPARADOR = "?";//SEPARADOR DE UN Contacto CON OTRO
	@CsvBindByPosition(position = 0)
	private String compañia;
	@CsvBindByPosition(position = 1)
	private String numeroTlf;
	@CsvBindByPosition(position = 2)
	private String so;

	public Contacto() {
		this("");
	}

	public Contacto(String compañia) {
		this.compañia = compañia;
		this.numeroTlf = "";
		this.so = "";
	}
	
	
	
}
