package xml.Ejercicio.Sevilla;

import java.io.IOException;
import java.time.LocalTime;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalTimeAdapterSevillaJson extends TypeAdapter<LocalTime> {

	@Override
	public void write(JsonWriter out, LocalTime value) throws IOException {
		
		if (value != null) {
			out.value(value.toString());
		}else {
			out.nullValue();
		}	
	}

	@Override
	public LocalTime read(JsonReader in) throws IOException {
		String sig = in.nextString();
		return LocalTime.parse(sig);
	}

}
