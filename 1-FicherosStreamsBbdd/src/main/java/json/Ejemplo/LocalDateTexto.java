package json.Ejemplo;

import java.io.IOException;
import java.time.LocalDate;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalDateTexto extends TypeAdapter<LocalDate> {

	@Override
	public void write(JsonWriter out, LocalDate value) throws IOException {
		out.beginObject(); //comenzar a leer
		out.name("dia");
		out.value(value.getDayOfMonth());
		out.name("mes");
		out.value(value.getMonthValue());
		out.name("anio");
		out.value(value.getYear());
		out.endObject();
	}

	@Override
	public LocalDate read(JsonReader in) throws IOException {
		int dia,mes,anio;
		
		in.beginObject(); //comenzar a leer
		in.nextName();
		dia = in.nextInt(); //dia
		in.nextName();
		mes = in.nextInt(); //mes
		in.nextName();
		anio = in.nextInt(); //año
		in.endObject();
		
		return LocalDate.of(anio, mes, dia);
	}

}
