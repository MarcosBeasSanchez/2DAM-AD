package json.Ejercicio.JsonPaises;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class EnumContinenteAdapter extends TypeAdapter<Continente> {

	@Override
	public void write(JsonWriter out, Continente value) throws IOException {
		out.value(value != null? value.toString():null);
		
	}

	@Override
	public Continente read(JsonReader in) throws IOException {
		String continente = in.nextString();
		return Continente.crearContinente(continente);
	}

}
