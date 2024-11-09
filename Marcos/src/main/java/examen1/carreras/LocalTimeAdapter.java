package examen1.carreras;

import java.time.LocalTime;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class LocalTimeAdapter extends AbstractBeanField<String, LocalTime>{

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		return value!=null? LocalTime.parse(value) : null;
		}
	}


