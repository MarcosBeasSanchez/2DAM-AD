package ejercicio.institutoOpencsv;

import java.util.Optional;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class TextToOptionalVehiculo extends AbstractBeanField<Object, Object> {

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

		Optional<Vehiculo>vehiculo;
		String[] campos = value.split(";");
		
		return vehiculo = value.equals("SinVehiculo") ? Optional.empty()
				: Optional.of(Vehiculo.builder().matricula(campos[1]).modelo(campos[1]).color(campos[2]).build());
		
		/* 
		 * Otra forma
		if (value.equals("SinVehiculo")) {
			return Optional.empty();
		}else {
			String[] campos = value.split(";");
			
			//tiene que venir con todos los campos de vehiculos completados
			Vehiculo vehiculo = Vehiculo.builder()
					.matricula(campos[0])
					.modelo(campos[1])
					.color(campos[2])
					.build();
			return Optional.of(vehiculo);
		}*/

		
	}

}
