package json.Ejemplo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalDateAdapter extends TypeAdapter<LocalDate> {
	
    DateTimeFormatter formatterOriginal = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //DateTimeFormatter formatterOriginal = DateTimeFormatter.ISO_LOCAL_DATE; LOMISMO
    
	@Override
	public void write(JsonWriter out, LocalDate value) throws IOException {
		
		// si existe lo escribe , sino escribe null
		
		if (value != null) {
			out.value(value.toString());
		} else {
			out.nullValue();
		}
	}

	@Override
	public LocalDate read(JsonReader in) throws IOException {
		
		String fecha = in.nextString();
		return LocalDate.parse(fecha,formatterOriginal);

	}
}
