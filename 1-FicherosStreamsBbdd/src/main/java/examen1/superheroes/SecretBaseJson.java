package examen1.superheroes;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class SecretBaseJson extends TypeAdapter<SecretBase> {

	@Override
	public void write(JsonWriter out, SecretBase value) throws IOException {

		if (value != null) {
			out.value(value.toString().toLowerCase());
		} else {
			out.nullValue();
		}
	}

	@Override
	public SecretBase read(JsonReader in) throws IOException {
		 String val = in.nextString().toUpperCase(); // top -> TOP el cual concuerda con el valor del eum
	        try {
	            return SecretBase.valueOf(val);
	        } catch (IllegalArgumentException e) {
	            System.err.println("Valor no reconocido para SecretBase: " + val);
	            return null; // Manejo seguro de valores desconocidos
	        }
	}

}
