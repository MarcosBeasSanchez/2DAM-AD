package csv.Ejercicio.Instituto;

import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Vehiculo {
	@CsvBindByPosition(position=0)
	private String matricula;
	@CsvBindByPosition(position=0)
	private String modelo;
	@CsvBindByPosition(position=0)
	private String color;

}
