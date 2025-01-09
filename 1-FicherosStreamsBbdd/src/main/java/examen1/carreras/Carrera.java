package examen1.carreras;

import java.util.List;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder

public class Carrera {
	@CsvBindByPosition(position=0)
	private String nombre;
	@CsvBindByPosition(position=1)
	private int metros;
	@CsvBindByPosition(position=2)
	private int cupoCorredores;
	@CsvBindAndSplitByPosition(elementType= Corredor.class,
			splitOn = "&", 
			converter = CorredorConverter.class ,
			writeDelimiter = "&", 
			position = 3)
	private List<Corredor>corredores;

}
