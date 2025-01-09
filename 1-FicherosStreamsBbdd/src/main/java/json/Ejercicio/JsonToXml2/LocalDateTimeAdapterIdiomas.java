package json.Ejercicio.JsonToXml2;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalDateTimeAdapterIdiomas extends TypeAdapter<LocalDateTime>{
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

	@Override
	public void write(JsonWriter out, LocalDateTime value) throws IOException {
		out.value(value.format(formatter));
		
	}

	@Override
	public LocalDateTime read(JsonReader in) throws IOException {
		String fecha = in.nextString();
		
		return LocalDateTime.parse(fecha,formatter);
	}

}
