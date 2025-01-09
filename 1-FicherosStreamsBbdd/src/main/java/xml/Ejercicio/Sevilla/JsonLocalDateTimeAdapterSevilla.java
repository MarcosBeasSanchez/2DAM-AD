package xml.Ejercicio.Sevilla;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class JsonLocalDateTimeAdapterSevilla extends TypeAdapter<LocalDateTime> {

	@Override
	public void write(JsonWriter out, LocalDateTime value) throws IOException {
		if (value != null) {
			out.value(value.toString());
		}else {
			out.nullValue();
		}
		
	}

	@Override
	public LocalDateTime read(JsonReader in) throws IOException {
		String serp = in.nextString();
		return LocalDateTime.parse(serp);
	}

}
