package examen1.superheroes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class PowersJsonAdapter extends TypeAdapter<List<String>> {

	@Override
	public void write(JsonWriter out, List<String> value) throws IOException {

		if (value.size() == 1) {
			out.value(value.get(0)); // Si es un solo poder, escribe como cadena
		} else {
			out.beginArray();
			for (String power : value) {
				out.value(power);
			}
			out.endArray();
		}

	}

	@Override
	public List<String> read(JsonReader in) throws IOException {

		List<String> lista = new ArrayList();

		if (in.peek() == JsonToken.BEGIN_ARRAY) {
			in.beginArray();
			while (in.hasNext()) {
				lista.add(in.nextString());
			}
			in.endArray();
		} else if (in.peek() == JsonToken.STRING) {
			lista.add(in.nextString());
		} else {
			in.skipValue();
		}

		return lista;
	}

}
