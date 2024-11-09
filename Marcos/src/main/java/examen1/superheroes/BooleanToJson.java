package examen1.superheroes;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class BooleanToJson extends TypeAdapter<Boolean>{

	@Override
	public void write(JsonWriter out, Boolean value) throws IOException {
		
        out.value(value != null && value == true ? "On" : "Off");

	}

	@Override
	public Boolean read(JsonReader in) throws IOException {
		String sig = in.nextString();
		return Boolean.parseBoolean(sig);
	}

}
