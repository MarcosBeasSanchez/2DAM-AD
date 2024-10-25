package csv.Ejercicio.Instituto;

import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contacto {
	@CsvBindByPosition(position=0)
	private String empresa;
	@CsvBindByPosition(position=1)
	private String numero;
	@CsvBindByPosition(position=2)
	private String os;
	
}
