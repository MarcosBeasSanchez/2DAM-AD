package json.Ejercicio.JsonToXml3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class GenresAdapter extends TypeAdapter<List<Genres>> {

	@Override
	public void write(JsonWriter out, List<Genres> value) throws IOException {

		Gson gson = new Gson();

		/*
		 * out.beginArray(); // Inicia un arreglo for (Genres genre : value) {
		 * out.value(genre.name()); // Escribe el nombre del enum } out.endArray(); //
		 * Finaliza el arreglo
		 */
		
		//out.name("genres");

		if (value.size() > 1) // Si lo que llehaes mayor que uno
		{
			out.beginArray();
			for (Genres g : value)
				out.value(g.toString());
			out.endArray();

		} else
			out.value(value.get(0).toString());
		// escribir fin del objeto

	}

	@Override
	public List<Genres> read(JsonReader in) throws IOException {

		/*
		 * in.beginObject();: Intenta consumir un { en el JSON, esperando el inicio de
		 * un objeto. in.nextName();: Intenta leer el nombre de un campo dentro de ese
		 * objeto.
		 */

		List<Genres> genres = new ArrayList<>();

		if (in.peek() == JsonToken.BEGIN_ARRAY) {
			in.beginArray();
			while (in.hasNext()) {
				String genre = in.nextString();
				genres.add(Genres.crearGenres(genre));
			}
			in.endArray();
		} else if (in.peek() == JsonToken.STRING) {
			String genre = in.nextString();
			genres.add(Genres.crearGenres(genre));
		} else {
			in.skipValue(); // Si no es ni array ni string, lo saltamos
		}

		return genres;
	}

}
