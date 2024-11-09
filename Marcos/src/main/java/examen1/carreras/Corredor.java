package examen1.carreras;

import java.time.LocalTime;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;

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

public class Corredor {

	@CsvBindByPosition(position=0)
	private String nombre;
	@CsvBindByPosition(position=1)
	private String dni;
	@CsvBindByPosition(position=2)
	private int edad;
	@CsvCustomBindByPosition(position = 3,converter = CategoriaConverter.class)
	private boolean categoria;
	@CsvCustomBindByPosition(position = 4,converter = LocalTimeAdapter.class)
	private LocalTime tiempo;

}
