package xml.Ejercicio.Sevilla;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Override
	public LocalTime unmarshal(String v) throws Exception {

		return (v == null || v.isEmpty()) ? null : LocalTime.parse(v, formatter);
	}

	@Override
	public String marshal(LocalTime v) throws Exception {

		return v == null ? null : v.format(formatter);
	}

}
