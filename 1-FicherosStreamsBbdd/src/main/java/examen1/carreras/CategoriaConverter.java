package examen1.carreras;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;


public class CategoriaConverter extends AbstractBeanField<String, Boolean> {

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		Boolean b = null;
		if (value.equalsIgnoreCase("Adulto")) {
			b = true;
		} else if (value.equalsIgnoreCase("Veterano")){
			b = false;
		}else {
			b = null;
		}
		return b;
	}

}
