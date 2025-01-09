package json.Ejercicio.JsonToXml2;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class EnumTipoFormacionAdapter extends TypeAdapter<TipoFormacion>{

	 @Override
	    public void write(JsonWriter out, TipoFormacion value) throws IOException {
	        out.value(value != null ? value.toString() : null); // Usa toString() para la serialización
	    }

	    @Override
	    public TipoFormacion read(JsonReader in) throws IOException {
	        String tipoFormacion = in.nextString();
	        return TipoFormacion.crearFormacion(tipoFormacion); // Usa el método crearFormacion
	    }
}
